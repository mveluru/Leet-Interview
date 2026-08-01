package leetcode75.java21.pratice.p1;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class AddUniqueNumber {

    public static List<Integer> findDuplicateNumber(int[] nums){
        HashSet<Integer> set = new HashSet<>();
        List<Integer> dupList = Arrays.stream(nums).boxed().filter(n -> !set.add(n)).toList();
        return dupList;

    }
    public static int addNonDupsNumbers(int[] nums){
        List<Integer> dupList = findDuplicateNumber(nums);
        return Arrays.stream(nums).filter(n -> !dupList.contains(n)).sum();

    }


    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 6, 7, 7, 8, 9, 9};
       System.out.println(addNonDupsNumbers(nums));
    }
}
