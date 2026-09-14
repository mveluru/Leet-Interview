package leetcode75.medium;

import java.util.Arrays;

public class MaxSlidingWIndow_FindMaxAverage {
    public static void findAverageDouble(int[] nums, int k) {

        double total = 0;
         total = Arrays.stream(nums).limit(k).sum();
         double max = total;

        for (int i = k; i < nums.length; i++) {
            //System.out.println(i + " " + nums[i]);
            total += nums[i]-nums[i-k];
            max = Math.max(max, total);
        }
        System.out.println(max);
        System.out.println((double)max/k);
    }

    public static void main(String[] args){
       // int[] input= {1, 12, -5, -6, 50, 3};
        //int k =4;
        int[] input= {1,10,2};
        int k =2;
        findAverageDouble(input,k);
    }
}
