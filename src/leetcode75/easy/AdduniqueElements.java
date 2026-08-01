package leetcode75.easy;



import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class AdduniqueElements {

    public static int addUnique(int[] nums) {

        Map<Integer, Long> counting = Arrays.stream(nums).
                boxed().sorted().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        int sum = 0;
        for (Map.Entry<Integer, Long> entryset : counting.entrySet()) {
            if (entryset.getValue().intValue() == 1) {
                sum = sum + entryset.getKey();
            }
        }
        return sum;
    }

    //identify duplicate elements
    //add elements != duplicate elements
    public static int addUniques(int[] nums) {
        Set<Integer> uniqueelements = new HashSet<>();
        List<Integer> dups = Arrays.stream(nums).filter(e -> !uniqueelements.add(e)).boxed().toList();
        int sum = 0;
        for (Integer i : uniqueelements) {
            if (!dups.contains(i)) {
                sum = sum + i;
            }

        }
        return sum;
    }

    public static int addnonrepeat(int[] nums) {
        Set<Integer> uniqueueelements = new HashSet<>();
        List<Integer> dups = Arrays.stream(nums).filter(value -> !uniqueueelements.add(value)).boxed().toList();
        int sum = uniqueueelements.stream().filter(value -> !dups.contains(value)).reduce(Integer::sum).get().intValue();
        return sum;
    }


    public static void main(String[] args) {

        int[] nums = {1, 2, 2, 3, 4, 4, 5};

        System.out.println(addUnique(nums));
        System.out.println(addUniques(nums));
        System.out.println(addnonrepeat(nums));
    }

}
