package bybInterview.stacks;

import java.util.Arrays;

public class RightImmediateLargeNumber {

    public static void main(String[] args) {
        //int[] nums= new int[] {2, 1, 2, 4, 3};//Output Array (res): [4, 2, 4, -1, -1]
        int[] nums = new int[] {5, 4, 3, 2, 1};
        //int[]nums =new int[] {5, 2, 4, 6, 1,9};

        int[] result = new int[nums.length];
        Arrays.fill(result, -1);

        for (int i=0;i<nums.length;i++) {
            for (int j=i+1;j<nums.length;j++) {
                if (nums[j]>nums[i]) {
                    result[i] = nums[j];
                    break;
                }
            }
        }
        System.out.println(Arrays.toString(result));
    }
}
