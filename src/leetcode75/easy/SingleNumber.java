package leetcode75.easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SingleNumber {
    public static List<Integer> singleNumber(int[] nums) {

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i : nums) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        List<Integer> list = new ArrayList<>();
        for (int i : map.keySet()) {
            if (map.get(i) == 1) {
                list.add(i);
            }
        }
        return list;
    }

    public static void findSingleNumber(int[] nums){
        if (nums == null || nums.length == 0){
            System.out.println("Input array is empty or null");
            return;
        }
        if(nums.length == 1) {
            System.out.println("Single number is: " + nums[0]);
            return;
        }
        System.out.println("Single numbers are: " + singleNumber(nums));

    }
    public static void main(String[] args){
        int[] nums = new int[]{1,2,2,3,4,5,2};
        findSingleNumber(nums);
    }
}



