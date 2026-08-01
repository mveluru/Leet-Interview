package leetcode75.java21.grind75.week1;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class ReversedOrder {


    public static void main(String[] args) {
        int[] arr = {3, 1, 4, 1, 5, 9, 2, 6};
        List<Integer> nums = Arrays.stream(arr).boxed().toList();
        // find largest number
        int largest = nums.stream().max(Integer::compareTo).get();
        // find smallest number
        int smallest = nums.stream().min(Integer::compareTo).get();
        int largestIndex = nums.stream().min(Comparator.reverseOrder()).get();
        System.out.println(largestIndex);

        // Top 3
        List<Integer> largestList = nums.stream().sorted(Comparator.reverseOrder()).limit(3).toList();
        System.out.println("largestList: " + largestList);
        List<Integer> smallestList = nums.stream().sorted(Comparator.naturalOrder()).limit(3).toList();
        System.out.println("smallestList: " + smallestList);
    }
}
