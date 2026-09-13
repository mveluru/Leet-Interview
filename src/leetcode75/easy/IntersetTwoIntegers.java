package leetcode75.easy;

import java.util.*;
import java.util.stream.Collectors;

public class IntersetTwoIntegers {
    public static void IntersetTwoIntegers(int[] nums1, int[] nums2) {


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

    public static void IntersetTwoIntegers2(int[] nums1, int[] nums2) {
        Set<Integer> nums2Set = Arrays.stream(nums2).boxed().collect(Collectors.toSet());
        List<Integer> results = Arrays.stream(nums1).boxed().distinct().filter(nums2Set::contains).toList();
        System.out.println(results);
    }

    public static void main(String[] arg) {
        int[] nums1 = {1, 2, 2, 3, 4, 5};
        int[] nums2 = {2, 2, 4, 6};
        IntersetTwoIntegers(nums1, nums2);
        IntersetTwoIntegers2(nums1, nums2);

    }
}
