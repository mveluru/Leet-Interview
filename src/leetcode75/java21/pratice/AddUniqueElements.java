package leetcode75.java21.pratice;

import java.util.*;

public class AddUniqueElements {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 3, 4, 5, 5, 6, 6, 7, 7,10};
        Set<Integer> set = new HashSet<>();
        List<Integer> dups = Arrays.stream(nums).filter(e -> !set.add(e)).boxed().toList();
        System.out.println(dups);
        int sum = 0;
        for (int j = 0; j < nums.length; j++) {
            if (!dups.contains(nums[j])) {
                sum += nums[j];
            }
        }
        System.out.println("Sum of unique elements: " + sum);
    }
}
