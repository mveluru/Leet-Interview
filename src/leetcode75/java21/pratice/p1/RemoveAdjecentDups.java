package leetcode75.java21.pratice.p1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class RemoveAdjecentDups {

    public static void removeadjectDupsonly(int[] nums) {

        List<Integer> list = new ArrayList<>();
        list.add(nums[0]);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] != nums[i]) {
                list.add(nums[i]);
            }
        }
        list.forEach(n -> System.out.printf("%5d ", n));
    }

    public static void distinct(int[] nums) {
        List<Integer> list = Arrays.stream(nums).boxed().distinct().toList();
        list.forEach(n -> System.out.printf("%5d ", n));

    }

    public static void reverse(int[] nums) {
        List<Integer> list = Arrays.stream(nums).boxed().distinct().sorted(Comparator.reverseOrder()).toList();
        list.forEach(n -> System.out.printf("%5d ", n));
    }


    public static void main(String[] args) {
        int[] nums = {1, 1, 2, 3, 4, 4, 4, 5, 6, 6, 7, 8, 8, 9, 9, 10, 9};
        removeadjectDupsonly(nums);
        System.out.println();
        distinct(nums);
        System.out.println();
        reverse(nums);
    }
}
