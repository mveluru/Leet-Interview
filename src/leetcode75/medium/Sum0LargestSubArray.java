package leetcode75.medium;

public class Sum0LargestSubArray {
    private static int sum0largesubarr(int[] arr) {
        int maxlen = 0;
        for (int i = 0; i < arr.length; i++) {
            int sum = 0;
            for (int j = i; j < arr.length; j++) {
                sum += arr[j];
                if (sum == 0) {
                    maxlen = Math.max(maxlen,
                            (j - i) + 1);
                }

            }
        }
        return maxlen;
    }

    public static void main(String[] args) {
       // int[] arr = {15, -2, 2, -8, 1, 7, 10, 23};
        int[] arr = {0, -1, -1, 6, -1, -3, -10, 10};
        int maxLengthofSubArray = Sum0LargestSubArray.sum0largesubarr(arr);
        System.out.println(maxLengthofSubArray);
    }
}
