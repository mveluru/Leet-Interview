package leetcode75.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubArrayAndMaxAverage {

    public static List<int[]> subArrays(int[] nums, int size) {
        List<int[]> subArraylist  = new ArrayList<>();
        for (int i=0; i<nums.length-size; i++){

           int[] subArray =Arrays.copyOfRange(nums, i, i + size);
            subArraylist.add(subArray);
        }
        return subArraylist;

    }

    public static double maxAverage(int[] nums, int k) {
        List<int[]> subArraylist= subArrays(nums, k);
        double max = 0;
        for (int[] subArray : subArraylist) {
            int sum = 0;
            for (int i : subArray) {
                sum += i;
            }
            double average = sum / (double)k;
            max = Math.max(max, average);
        }// outer loop
        return max;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,12,-5,-6,50,3};
        int k = 4;
        System.out.println(maxAverage(nums, k));
    }
}
