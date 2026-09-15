package leetcode75.easy;

import java.util.Arrays;

public class ArrayMisMatch {
    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 4};
        int[] nums2 = {1, 2, 3, 4, 5, 6, 7};
        System.out.println(Arrays.mismatch(nums1, nums2));
    }
}
