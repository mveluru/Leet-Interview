package leetcode75.medium;

import java.util.Arrays;
import java.util.List;

public class FindFirstAndLastPositionofElement {

    private static int[] findElements(int[] nums, int target) {
        int[] foundElements = new int[2];
        List<Integer> fe = Arrays.stream(nums).boxed().toList();
        boolean allWithinRange = Arrays.stream(nums).allMatch(x -> x >= Math.pow(-10, 9) && x <= Math.pow(10, 9));
        boolean range = nums.length >= 0 && nums.length <= Math.pow(10, 5);

        if (range && allWithinRange) {
            foundElements[0] = fe.indexOf(target);
            foundElements[1] = fe.lastIndexOf(target);
        } else {
            foundElements[0] = -1;
            foundElements[1] = -1;
        }


        return foundElements;
    }

    public static void main(String[] args) {
        //int[] nums = {5, 7, 7, 8, 8, 10};
        //int target = 8;
        //int[] nums = {5, 7, 7, 8, 8, 10};
        //int target = 0;
        int[] nums = {1, 2, 3, 4, -3, 0, -3, 9, 7, 8};
        int target = -3;
        int[] foundelement = FindFirstAndLastPositionofElement.findElements(nums, target);
        System.out.println(Arrays.toString(foundelement));
    }
}
