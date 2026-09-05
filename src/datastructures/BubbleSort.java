package datastructures;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public class BubbleSort {

    public static void bsoft(int[] arr) {
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
                Arrays.stream(arr).forEach(num->System.out.print(num+" "));

            }
        }
    }

    public static void bubbleSort(int[] array) {

        int len = array.length;
        for (int i=0;i<len;i++) {
            var isSorted=true;
            for (int j=1;j<len;j++) {
                if(array[j]<array[j-1]) {
                    array[j] ^= array[j-1]^(array[j-1]=array[j]);
                    isSorted=false;
                }

            }
            if(isSorted) {
                System.out.println(Arrays.toString(array));
            }
        }

    }

    public static void main(String[] args) {
        List<Integer> list = IntStream.range(0,20).boxed().toList();

        int[] reversed = list.stream()
                .sorted(Collections.reverseOrder()).mapToInt(Integer::intValue).toArray();
        System.out.println(Arrays.toString(reversed));

      bsoft(reversed);
    }
}
