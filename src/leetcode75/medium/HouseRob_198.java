package leetcode75.medium;

public class HouseRob_198 {
    // even number home index has security
    public static int rob(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        if (nums.length > 100) return 0;
        int money = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (i % 2 != 0) {
                money += nums[i];
            }

        }
        return money;
    }
    public static void main(String[] args) {
        int[] nums = {2, 7, 9, 3, 1};
        System.out.println(rob(nums));
        int[] nums2 = {1,2,3,1};
        System.out.println(rob(nums2));
    }
}
