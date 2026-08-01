package leetcode75.medium;

import java.util.Arrays;

public class RemoveSpecificRepeatedElement {

    private static String[] removeinpalcelements(int[] nums, int value) {

        int[] newArray = Arrays.stream(nums).filter(n -> n != value).toArray();
        int length = nums.length;
        String[] strArray = new String[nums.length];

        for (int i = 0; i < length; i++) {
            if (i < newArray.length) {
                strArray[i] = String.valueOf(newArray[i]);
            } else {
                strArray[i] = "_";
            }
        }
        return strArray;
    }

    public static void main(String[] args) {
        //int[] nums = {3, 2, 2, 3};
        //int value = 3;
        int[] nums = {0, 1, 2, 2, 3, 0, 4, 2};
        int value = 2;
        String[] strArray = RemoveSpecificRepeatedElement.removeinpalcelements(nums, value);
        System.out.println(Arrays.toString(strArray));

    }
}

