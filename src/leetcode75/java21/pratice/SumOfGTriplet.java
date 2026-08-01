package leetcode75.java21.pratice;

import java.util.*;

public class SumOfGTriplet {
    public static void main(String[] args) {
        int[] array = {-1, 0, 1, 2, -1, -4};
        Set<List<Integer>> resultset = new HashSet<>();
        int length = array.length;
        for (int i = 0; i < length - 2; i++) {
            Set<Integer> seen = new HashSet<>();

            for (int j = i + 1; j < length - 1; j++) {
                int sum = -1 * (array[i] + array[j]);
                if (seen.contains(sum)) {
                    List<Integer> triplet = Arrays.asList(array[i], array[j], sum);
                    Collections.sort(triplet);
                    resultset.add(triplet);

                }
                seen.add(array[j]);
            }

        }
        System.out.println(resultset);
    }
}
