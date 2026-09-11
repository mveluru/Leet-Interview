package leetcode75.medium;
//Leet 560. Subarray Sum Equals K
public class SubArraySumEquals_k {
    public static void subarraySum(int[] nums, int k) {
        int count = 0;

        // Try every possible starting point of a subarray
        for (int start = 0; start < nums.length; start++) {
            int currentSubarraySum = 0;

            // Extend the subarray to the right, one element at a time
            for (int end = start; end < nums.length; end++) {
                currentSubarraySum += nums[end];

                // If the current window matches k, increment count
                if (currentSubarraySum == k) {
                    count++;
                }
            }
        }

        System.out.println( count);
    }

   public static void main(String []args){
       subarraySum(new int[]{1,1,1},2);
       subarraySum(new int[]{1,2,3},3);
   }
}
