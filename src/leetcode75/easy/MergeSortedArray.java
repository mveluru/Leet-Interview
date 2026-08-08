package leetcode75.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MergeSortedArray {

    public static void merge(int[] nums1, int[] nums2) {

        int[] merged;
        List<Integer> list1 = new ArrayList<>(Arrays.stream(nums1).boxed().toList());
        List<Integer> list2 = new ArrayList<>(Arrays.stream(nums2).boxed().toList());
        list2.addAll(list1);
        merged = list2.stream().filter(e -> e != 0).sorted().mapToInt(Integer::intValue).toArray();
        System.out.println(Arrays.toString(merged));

    }




    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int[] nums2 = {2, 5, 6};
        merge(nums1, nums2);
    }
}
