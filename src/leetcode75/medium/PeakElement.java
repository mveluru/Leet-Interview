package leetcode75.medium;
//162. Find Peak Element

public class PeakElement {
    public int findPeakElement(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        // Binary search to find the peak in an unsorted array
        while (left < right) {
            int mid = left + (right - left) / 2;

            // Check the right neighbor to determine the local slope
            if (nums[mid] < nums[mid + 1]) {
                // You are standing on an UPWARD slope going right.
                // A peak is guaranteed to exist somewhere to your right.
                left = mid + 1;
            } else {
                // You are standing on a DOWNWARD slope going right.
                // This means 'mid' itself could be a peak, or a peak is to the left.
                right = mid;
            }
        }

        // 'left' and 'right' converge at a valid peak index
        return left;
    }

    public static void main(String[] args) {
        PeakElement solver = new PeakElement();

        // Example 1 (Multiple peaks, unsorted)
        int[] nums1 = {1, 2, 1, 3, 5, 6, 4};
        System.out.println("Peak Index: " + solver.findPeakElement(nums1));
        // Output can be 1 (value 2) or 5 (value 6). Both are valid.

        // Example 2
        int[] nums2 = {1, 2, 3, 1};
        System.out.println("Peak Index: " + solver.findPeakElement(nums2));
        // Output: 2 (value 3)
    }
}
