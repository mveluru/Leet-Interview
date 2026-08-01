package leetcode75.java21.grind75.week1;

import java.util.Arrays;
import java.util.stream.IntStream;

public class MissingNumber {
    public static void missingNumber(int[] arr) {
        Arrays.sort(arr);
        int n = arr.length;
        int sum = 0;
        sum= IntStream.rangeClosed(1,9).sum();
        for (int i = n-1; i >= 0; i--) {
            sum = sum-arr[i];
        }
        System.out.println(sum);
    }
    public static void StringToInt(String str) {
        System.out.println(Integer.parseInt(str));
    }
    public static void main(String[] args) {
        int[] arr = new int[] { 1, 2, 3, 4, 6, 7, 8, 9 };
        missingNumber(arr);
        StringToInt("1234567");

    }
}
