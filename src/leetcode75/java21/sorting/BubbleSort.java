package leetcode75.java21.sorting;

import java.util.Arrays;

public class BubbleSort {
    public static void bsort(int[] arr) {
        int len = arr.length;
        for (int i = 0; i < len; i++) {
            boolean isSorted=true;
            for (int j = 1; j < len - i; j++) {
                if (arr[j] < arr[j - 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = temp;
                    isSorted=false;
                }
            }
            if (isSorted) {
                Arrays.stream(arr).forEach(System.out::println);

            }
        }
    }

    public static void main(String[] args) {
        int[] intarry ={10,9,8,7,6,5,4,3,2,1,0,-1,-2,0};
        BubbleSort.bsort(intarry);
    }
}
