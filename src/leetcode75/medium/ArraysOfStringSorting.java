package leetcode75.medium;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class ArraysOfStringSorting {
    public List<String> sortString(List<String> s) {
       return s.stream().sorted(String::compareTo).toList();

    }
    public List<String> reversed_sortString(List<String> s) {
        return s.stream().sorted(Comparator.reverseOrder()).toList();

    }

    public List<Integer> reverseIntegers(int[] nums) {
        return Arrays.stream(nums).boxed().sorted(Comparator.reverseOrder()).toList();
    }

    public static void main(String[] args) {
        List<String> list = Arrays.asList("Silent", "listen", "java", "python");
        ArraysOfStringSorting s = new ArraysOfStringSorting();
        System.out.println(s.reversed_sortString(list));
        System.out.println(s.sortString(list));
        int[] nums = new int[]{21,1, 2, 3, 4, 5, 6, 7, 8, 9};
        System.out.println(s.reverseIntegers(nums));
    }
}