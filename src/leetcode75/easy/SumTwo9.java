package leetcode75.easy;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class SumTwo9 {
    public static int[] sumTwo9(int[] nums, int target) {

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

    public static void SumOfTwo_9(String[] args) {
        int [] nums = {2, 7, 11, 15, 3, 6};
        Set<Integer> seen = new HashSet<>();
        int target =9;
        for (int num : nums) {
            int complement = target - num;

            if (seen.contains(complement)) {
                System.out.println(complement + "," + num);
                break;
            }

            seen.add(num);
        }

    }

    public static void main(String[] args) {

        int[] nums = { 1, 11, 8, 15 };
        int targetSum = 9;

        int[] indexes = sumTwo9(nums, targetSum);
        System.out.printf("%4d,%4d", indexes[0], indexes[1]);

    }

}
