package leetcode75.java21.pratice;

import java.util.Arrays;
import java.util.List;

public class ShiftZerosToEnd {
    public static void main(String[] args) {
        int[] nums = {0, 1, 0, 3, 0, 2, 3};
        int len = nums.length;

        List<Integer> nonZeroElements = Arrays.stream(nums).boxed().filter(e -> e > 0).toList();
        int[] res = new int[len];
        for (int i = 0; i < nonZeroElements.size(); i++) {
            res[i] = nonZeroElements.get(i);
        }

        System.out.println(Arrays.toString(res));

    }
}
