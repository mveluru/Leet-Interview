package leetcode75.hard;

public class Median {
    public static double findMedianSortedArrays(int[] nums1) {
        int n = nums1.length;
        if (n % 2 == 0) {
            int mid = n / 2;
            return (nums1[mid] + nums1[mid - 1]) / 2.0;
        }else{
            int mid = n / 2;
            return nums1[mid];
        }
    }
    public static void main(String[] args) {
        int[] nums1 = {1,2,3,4,5,6,7};
       double n = Median.findMedianSortedArrays(nums1);
       System.out.println(n);
    }
}
