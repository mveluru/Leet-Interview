package leetcode75.easy;

public class SubArrays {

    static void printSubArrays(int[] arr, int start, int end) {
        // Stop if we have reached the end of the array
        if (end == arr.length)
            return;
            // Increment the end point and start from 0
        else if (start > end)
            printSubArrays(arr, 0, end + 1);
            // Print the subarray and increment the starting
            // point
        else {
            System.out.print("[");
            for (int i = start; i < end; i++)
                System.out.print(arr[i] + ", ");
            System.out.println(arr[end] + "]");
            printSubArrays(arr, start + 1, end);
        }
        return;
    }

    static void subarrays(int[] array) {
        for (int i = 0; i <array.length; i++) {
           // System.out.println();
            for (int j = i; j < array.length; j++) {
                System.out.println();
                for (int k = i; k <= j; k++) {
                    System.out.print(array[k] + " ");
                }

            }

        }

    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4};

        SubArrays.printSubArrays(nums, 0, nums.length - 1);
        System.out.println("++++++++++++++++++++");
        SubArrays.subarrays(nums);

    }
}
