package leetcode75.medium;

public class MaxSumOfArrays {

    public int maxSum(int[] arr, int k) {
        int windowSum = 0;
        int maxSum = 0;
        if (arr == null || arr.length == 0)
            return 0;

        for (int i = 0; i < k; i++) {
            windowSum += arr[i];
        }
        maxSum = Math.max(maxSum, windowSum);
        for (int i = k; i < arr.length; i++) {
            windowSum = windowSum- arr[i-k]+arr[i];
            maxSum = Math.max(maxSum, windowSum);
        }
        return maxSum;
    }
}
