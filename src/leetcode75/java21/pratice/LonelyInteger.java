package leetcode75.java21.pratice;

public class LonelyInteger {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 2, 1};
        int result = 0;
        for (int num : arr) {
            result ^= num;
        }

        System.out.println(result);

    }
}
