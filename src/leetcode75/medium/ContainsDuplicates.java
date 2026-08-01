package leetcode75.medium;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class ContainsDuplicates {
    protected boolean containsDuplicate(int[] nums) {
        if (nums.length > Math.pow(10, 5) || nums.length >= 1) {
            System.out.println();;
        }else{
            return false;
        }

        for (int i : nums) {
            if (i < Math.pow(-10, 9) || i > Math.pow(10, 9)) {
                return false;
            }
        }
        Set<Integer> uniqueElements = new HashSet<>();
        Set<Integer> dupsset = Arrays.stream(nums).boxed().filter(e -> !uniqueElements.add(e)).collect(Collectors.toSet());
        if (!dupsset.isEmpty()) {
            return true;
        }
        return false;

    }

    public static void main(String[] args) {
        ContainsDuplicates duplicates = new ContainsDuplicates();
        int[] nums = {0,4,5,0,3,6};
        //int[] nums = {1,2,3,1};
        //int[] nums = {1, 1, 1, 3, 3, 4, 3, 2, 4, 2};
        //int [] nums = {1,2,3,4};
        System.out.println(duplicates.containsDuplicate(nums));

    }
}
