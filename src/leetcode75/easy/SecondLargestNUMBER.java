package leetcode75.easy;

public class SecondLargestNUMBER {
    public static void main(String[] args) {
        int[] nums = {12, 35, 1, 10, 34, 1};
        int largest = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;
        for (int num:nums) {
            if (num>largest) {
                secondLargest = largest;
                largest = num;

            }else {
                if (num> secondLargest && num!=largest) {
                    secondLargest=num;
                }
            }
        }
        System.out.println(secondLargest);
    }
}
