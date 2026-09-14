package leetcode75.medium;

import java.util.Arrays;

public class MoveTargetTotheEndOfArray {

    public static int[] movetargettoEnd(int[] input, int target){

        int[] nums1 = Arrays.stream(input).filter(value -> value!=target).toArray();
        int[] nums2= Arrays.stream(input).filter(value -> value==target).toArray();
        int[] result = Arrays.copyOf(nums1, nums1.length + nums2.length);
        System.arraycopy(nums2, 0, result, nums1.length, nums2.length);
        return result;
    }
    public static void movetargettoEnd2(int[] nums, int target){
        int length = nums.length;
        int insertPosition=0;
        for (int i=0;i<length;i++) {
            if(nums[i]!=target) {
                nums[insertPosition]=nums[i];
                insertPosition++;

            }

        }
        while (insertPosition<length) {
            nums[insertPosition]=target;
            insertPosition++;

        }
        System.out.println(Arrays.toString(nums));
    }



    public static void main(String[] args){

        int[] nums = {1,2,3,4,5,1,6};
        int moveToEnd_target = 1;
        int[] result =movetargettoEnd(nums,moveToEnd_target);
        System.out.println(Arrays.toString(result));
        movetargettoEnd2(nums,moveToEnd_target);

    }
}
