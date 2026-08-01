package leetcode75.java21.grind75.week1;

import java.util.Arrays;

public class BubblesortReverse {

    public static int[] bSortReversse(int[] arr) {
       //ReversedOrder
        for (int i = 0; i < arr.length - 1; i++) {
            boolean flag = true;
            for (int j = 1; j < arr.length; j++) {
                if (arr[j] > arr[j-1]) {
                    int temp = arr[j];
                    arr[j]= arr[j-1];
                    arr[j-1] = temp;
                    flag = false;

                }
            }
            if (flag) {
                break;
            }
        }
        //System.out.println(Arrays.toString(arr));
        return arr;
    }


    public static void main(String[] args) {
        int[] oddArray = {7,3,4,9};
        System.out.println(Arrays.toString(bSortReversse(oddArray)));

    }
}
