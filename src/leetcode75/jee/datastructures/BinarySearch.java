package leetcode75.jee.datastructures;

import java.util.Arrays;

public class BinarySearch {
    //two step process 1. sort 2. search by partitioning
    public static final String NO_DATA_FOUND ="No Data Found";
    private static int[] bubblesort(int[] input) {
        int length = input.length;
        for (int i = 0; i < length; i++) {
            boolean issorted = true;
            for (int j = 1; j < length; j++) {
                if (input[j - 1] > input[j]) {
                    input[j] = input[j] ^ input[j - 1] ^ (input[j - 1] = input[j]);
                    issorted = false;
                }
            }
            if (issorted) {
                break;
            }
        }
        return input;
    }

    public static boolean binarysearch(int[] nums, int data) {
        int[] sortedInput = bubblesort(nums);
        int beginIndex = 0;
        int endIndex = sortedInput.length - 1;
        boolean issearchfound = false;
        while (!false) {

            int midIndex = beginIndex + (endIndex - beginIndex) / 2;
            if (sortedInput[midIndex] == data) {
                System.out.println("Data found in sorted index " + midIndex);
                System.out.println("Sorted Array " + Arrays.toString(sortedInput));
                return true;
            }else if (sortedInput[midIndex]< data){
                if ((midIndex+1)>endIndex){
                    System.out.println(NO_DATA_FOUND);
                    return false;
                }
                beginIndex = midIndex+1;

            }else if(sortedInput[midIndex]> data){
                endIndex = midIndex-1;

            }
        }
    }


    public static void main(String[] args) {
        int[] input = { 24, 2, 45, 20, 56, 75, 2, 55, 99, 53, 12, 100, 52 ,21,30,29,28,46};
        //System.out.println("Bubble Sort");
       // System.out.println(Arrays.toString(bubblesort(input)));

        System.out.println( binarysearch(input,53));

    }
}
