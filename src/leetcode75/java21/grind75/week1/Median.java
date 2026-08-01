package leetcode75.java21.grind75.week1;

public class Median {
    public static double findMedian(int[] arr) {
        if (arr.length % 2 == 0) {
            return (arr[arr.length / 2 - 1] + arr[arr.length / 2]) / 2.0;
        }
        return arr[arr.length / 2];
    }
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5,6};
        System.out.println(findMedian(nums));
    }
}
