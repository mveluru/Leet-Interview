package leetcode75.easy;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class IntersetTwoIntegers {


    public static void main(String[] arg) {
        int[] nums1 = {1, 2, 2, 3, 4, 5};
        int[] nums2 = {2, 2, 4, 6};

        Set<Integer> set1 = new HashSet<>();
        Set<Integer> result = new LinkedHashSet<>();

        for (int n : nums1) {
            set1.add(n);
        }

        for (int n : nums2) {
            if (set1.contains(n)) {
                result.add(n);
            }
        }

        System.out.println(result);
    }
}
