package leetcode75.easy;

import java.util.HashMap;
import java.util.Map;

public class Sum9 {

    public static int[] SumTwo9(int[] nums, int target) {

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[] { map.get(complement), i };
            }
            map.put(nums[i], i);
        }

        return new int[] {};
    }

    public static void main(String[] args) {

        int[] nums = { 1, 11, 8, 15 };
        int targetSum = 9;

        int[] indexes = SumTwo9(nums, targetSum);
        System.out.printf("%4d,%4d", indexes[0], indexes[1]);

    }

}
