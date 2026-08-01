package leetcode75.medium;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

public class UnquienumberofOccurences {
    public boolean uniqueOccurrences(int[] arr) {
        int n = arr.length - 1;
        if (arr.length < 1 || arr.length > 1000) {
            return false;
        }
        for (int i : arr) {
            if (i < -1000 || i > 1000) {
                return false;
            }
        }
        Map<Integer, Long> occurenceCount = Arrays.stream(arr).boxed().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        Set<Long> uniqueset = new HashSet<>();
        Set<Long> nonuniqueset = occurenceCount.entrySet().stream().map(Map.Entry::getValue).filter(e -> !uniqueset.add(e)).collect(Collectors.toSet());
        if (nonuniqueset.isEmpty()) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        UnquienumberofOccurences unquienumberofOccurences = new UnquienumberofOccurences();
        //int[] nums = {1, 2, 2, 1, 1, 3};
        //int[] nums ={-3,0,1,-3,1,1,1,-3,10,0};
        int[] nums = {1, 2};
        System.out.println(unquienumberofOccurences.uniqueOccurrences(nums));
    }
}
