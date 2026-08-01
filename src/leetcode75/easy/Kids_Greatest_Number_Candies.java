package leetcode75.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Kids_Greatest_Number_Candies {
    public static List<Boolean> greaterCandies(int[] nums, int extraCandies) {
        List<Boolean> result = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            result.add(false);
            return result;
        }
        int max = Arrays.stream(nums).max().getAsInt();
        for (int num : nums) {
            if (num + extraCandies >= max) {
                result.add(true);
            } else {
                result.add(false);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] candies1 = new int[]{2, 3, 5, 1, 3};
        List<Boolean> result = greaterCandies(candies1, 3);
        System.out.println(result);

        int[] candies2 = new int[]{4, 2, 1, 1, 2};
        List<Boolean> result2 = greaterCandies(candies2, 1);
        System.out.println(result2);

        int[] candies3= new int[]{12,1,12};
        List<Boolean> result3 = greaterCandies(candies3, 10);
        System.out.println(result3);
    }
}
