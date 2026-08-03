package leetcode75.easy;
// 724. Find Pivot Index
// The pivot index is the index where the sum of all the numbers strictly to the left of the index is equal to the sum of all the numbers strictly to the index's right.

public class PivotedIndex {
    public int pivotIndex(int[] nums) {
        int totalSum = 0;
        for (int num : nums) {
            totalSum += num;
        }
        int leftSum = 0;
        for (int i = 0; i < nums.length; i++) {
            int rightSum = totalSum - leftSum - nums[i];
            if(rightSum == leftSum){
                System.out.println("Left sum: " + leftSum + ", Right sum: " + rightSum + ", Pivot index: " + i);
                return i;
            }
            leftSum += nums[i];
        }
        return -1;
    }
    public static void main(String[] args) {
        PivotedIndex pivotedIndex = new PivotedIndex();
        int[] nums = {1, 7, 3, 6, 5, 6};
        System.out.println(pivotedIndex.pivotIndex(nums));
    }
}
