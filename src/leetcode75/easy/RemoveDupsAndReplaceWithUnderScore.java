package leetcode75.easy;
//Problem#150
import java.util.Arrays;

public class RemoveDupsAndReplaceWithUnderScore {

    public static void removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        int[] ints = Arrays.stream(nums).sorted().distinct().toArray();

        String[] removeNums = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            removeNums[i] = "_";
        }
        for (int i = 0; i < ints.length; i++) {
            removeNums[i] = String.valueOf(ints[i]);
        }
        System.out.println("Original Array: " + Arrays.toString(nums));
        System.out.println(Arrays.toString(removeNums));
    }// end of method

    public static void main(String[] args) {
        System.out.println("Remove Duplicates and Replace with Underscore");
        int[] nums = {1, 2, 3, 3, 4, 5, 5, 7, 8, 8, 9};
        removeDuplicates(nums);
    }
}// end of class
