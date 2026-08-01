package leetcode75.medium;

import java.util.Arrays;
import java.util.List;

public class First_Missing_Positive {
    public static void firstMissingpositive(int[] nums) {
        boolean arraylength_range = nums.length >= 1 && nums.length <= Math.pow(10, 5);
        boolean allWithinRange = Arrays.stream(nums).allMatch(x -> x >= Math.pow(-2, 31) && x <= Math.pow(2, 31));
        List<Integer> numbers = Arrays.stream(nums).boxed().toList();
        if (arraylength_range && allWithinRange) {
            for (int i = 1; i <= Integer.MAX_VALUE; i++) {
                if (!numbers.contains(i)) {
                    System.out.println(i);
                    break;
                }

            }
        }

    }

    public static void main(String[] arg) {
        int[] nums = {1, 2, 0};
        // int[] nums = {3,4,-1,1};
        //int[] nums = {7, 8, 9, 11, 12};
        First_Missing_Positive.firstMissingpositive(nums);
    }
}
