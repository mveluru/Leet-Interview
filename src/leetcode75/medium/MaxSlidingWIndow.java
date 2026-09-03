package leetcode75.medium;

import java.util.Arrays;

public class MaxSlidingWIndow {
    public static int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0) return new int[0];

        int n = nums.length;
        // Total number of windows is always (n - k + 1)
        int[] res = new int[n - k + 1];

        // Outer loop moves the start of the window
        for (int i = 0; i <= n - k; i++) {
            int maxVal = nums[i]; // Start by assuming the first element in the window is the largest

            // Inner loop scans the elements inside the current window
            for (int j = i; j < i + k; j++) {
                if (nums[j] > maxVal) {
                    maxVal = nums[j];
                }
            }

            // Store the maximum found for this window
            res[i] = maxVal;
        }

        return res;
    }
    public static void main(String[] args) {
        int[] array = {3, 2, 4, 1, 2, 1, 1};
        int slideWindowSize = 4;

        int[] result = maxSlidingWindow(array, slideWindowSize);
        System.out.println("Output: " + Arrays.toString(result));
        // Expected Output: [4, 4, 4, 2]

    }
}
