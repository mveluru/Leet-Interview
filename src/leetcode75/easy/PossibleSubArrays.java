package leetcode75.easy;

import java.util.Arrays;

public class PossibleSubArrays {

    public static void main(String[] args) {
        int arr[] = {10, 2, 3, 5, 1};
        for (int i = 0; i < arr.length; i++) {
            for (int j =0;(i!=j &&j<arr.length);j++){

            int[] subarray = Arrays.copyOfRange(arr, i, j+2);
            System.out.println(Arrays.toString(subarray));
            }




        }//for loop


    }
}
