package leetcode75.easy;

import java.util.Arrays;
import java.util.List;

public class MovesZeros {

    public static void moveZeroes(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }

        int[] leftadjustArray = new int[nums.length];
        List<Integer> nonZero = Arrays.stream(nums).boxed().filter(i -> i != 0).toList();
        for (int i = 0; i < nonZero.size(); i++) {
            leftadjustArray[i] = nonZero.get(i);
        }
        System.out.println(Arrays.toString(leftadjustArray));
    }
    public static void moveZerosToEnd(int[] nums) {
        int[] numArray = new int[nums.length];
        int index=0;
        for(int value:nums) {
            if(value!=0) {
                numArray[index++]=value;
            }
        }
        System.arraycopy(numArray, 0, nums, 0, nums.length);
        System.out.print(Arrays.toString(nums));

    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{0, 1, 0, 3, 12};
        moveZeroes(nums1);
    }

}
