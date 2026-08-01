package leetcode75.java21.sorting;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.IntStream;

public class BubbleSort1 {
    public void bubblesort(int[] bsort) {
        int temp = 0;
        for (int i = 0; i < bsort.length; i++) {
            boolean isSorted = true;
            for (int j = 1; j < bsort.length - i; j++) {
                if (bsort[j] < bsort[j - 1]) {
                    temp = bsort[j];
                    bsort[j] = bsort[j - 1];
                    bsort[j - 1] = temp;
                }
                isSorted = false;
            }
            if (isSorted) {
                break;
            }
        }
        System.out.println("Sorted array is:");
        System.out.println(Arrays.toString(bsort));
    }
    public static void main(String[] args) {
        int[] bsort = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 0, -1, -2};
        int[] intarray= IntStream.rangeClosed(0,10).boxed().sorted(Comparator.reverseOrder()).mapToInt(Integer::intValue).toArray();
        BubbleSort1 bubbleSort1 = new BubbleSort1();
        bubbleSort1.bubblesort(bsort);
        bubbleSort1.bubblesort(intarray);
    }
}
