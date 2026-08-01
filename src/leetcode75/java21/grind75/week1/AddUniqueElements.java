package leetcode75.java21.grind75.week1;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class AddUniqueElements {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 3,4, 5, 5 ,6, 6,7, 7};
        Set<Integer> set = new HashSet<>();
        List<Integer> dups = Arrays.stream(nums).filter(e -> !set.add(e)).boxed().toList();
        List<Integer> numbs = Arrays.stream(nums).filter(e -> !dups.contains(e)).boxed().toList();
        System.out.println(numbs.stream().reduce(Integer::sum).orElse(0));

    }
}
