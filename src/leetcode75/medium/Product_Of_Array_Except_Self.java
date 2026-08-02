package leetcode75.medium;
// problem:238

import java.util.Arrays;

public class Product_Of_Array_Except_Self {

    public static void  productExceptSelf(int[] nums) {

        int[] products = new int[nums.length];
        for(int i=0;i<nums.length;i++){
            int num = 1;
            for (int j=0;j<nums.length;j++){
                if (i!=j){
                    num *= nums[j];
                }
            }
            products[i] = num;
        }
        System.out.println("Products: "+ Arrays.toString(products));
    }
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        productExceptSelf(nums);
    }
}
