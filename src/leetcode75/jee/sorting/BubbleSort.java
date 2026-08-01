package leetcode75.jee.sorting;

import java.util.Arrays;

public class BubbleSort {

    public void sort(int[] array) {
        int n = array.length;

        for (int i = 0; i < n; i++) {
            boolean isSorted = true;
            for (int j = 1; j < n; j++) {
                if (array[j] < array[j-1]) {
                    array[j-1] = array[j-1] ^ array[j] ^ (array[j] = array[j-1]);
                    isSorted = false;
                }
            }
            if (isSorted) {
                System.out.println(Arrays.toString(array));
                break;
            }
        }
    }
public static void main(String[] args){
        BubbleSort bsort = new BubbleSort();
        int[] sort = {21,9,10,20,80,3,50};
        bsort.sort(sort);
}
}
