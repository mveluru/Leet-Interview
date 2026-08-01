package leetcode75.easy;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ArrayCopy {
    public static void main(String[] args) {

        //int[] nums = {16, 2, 3, 14, 10, 0,11,4,15,16,17,1};
        int[] nums = {1, 2, 3, 1, 2, 3, 5, 6, 7, 5, 6, 7, 1, 2, 3, 1, 2, 3, 1, 2, 3, 5, 6, 7, 5, 6, 7, 1, 2, 3, 1, 2, 3, 1, 2, 3, 5, 6, 7, 5, 6, 7, 1, 2, 3, 1, 2, 3, 1, 2, 3, 5, 6, 7, 5, 6, 7, 1, 2, 3};
        Set<int[]> orginalset = new HashSet<>();
        int chunk = 3; // chunk size to divide
        int original = nums.length;
        for (int i = 0; i < nums.length; i += chunk) {
            orginalset.add(Arrays.copyOfRange(nums, i, Math.min(original, i + chunk)));
            System.out.println(Arrays.toString(Arrays.copyOfRange(nums, i, Math.min(original, i + chunk))));
        }
        System.out.println();
       /*for (int[] a: orginal){
           System.out.println(Arrays.toString(a));
       }*/

        List<int[]> newList = new ArrayList<>();
        for (int[] array : orginalset) {
            newList.add(array);
        }

        for (int i = 0; i < newList.size(); i++) {
            for (int j =0; j < newList.size(); j++) {
                if (i!=j && Arrays.equals(newList.get(i), newList.get(j))) {
                     newList.remove(j);
                }
            }

        }

        for (int[] array : newList) {
            System.out.println(Arrays.toString(array));
        }
        Map<int[], Long> a= newList.stream().collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
        System.out.println(a);

    }
}
