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
        int index = 0;
        for (int value : nums) {
            if (value != 0) {
                numArray[index++] = value;
            }
        }
        System.arraycopy(numArray, 0, nums, 0, nums.length);
        System.out.print(Arrays.toString(nums));

    }

    public static void moveZeroesToEnd(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        int[] zeroAtEnd = new int[nums.length];
        int[] nonzero = Arrays.stream(nums).filter(n -> n != 0).toArray();
        System.arraycopy(nonzero, 0, zeroAtEnd, 0, nonzero.length);
        System.out.print(Arrays.toString(zeroAtEnd));
    }

    public static void MoveZeroesToEndDontcreateNewArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        int len = nums.length;
        int insertposition = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[insertposition] = nums[i];
                insertposition++;
            }

        }
        while (insertposition < len) {
            nums[insertposition] = 0;
            insertposition++;
        }
        System.out.println(Arrays.toString(nums));
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{0, 1, 0, 3, 12};
        int[] nums = {0, 5, 0, 3, 8, 0, 2};
        moveZeroes(nums1);
        MoveZeroesToEndDontcreateNewArray(nums);
    }

}
