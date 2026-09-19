package leetcode75.medium;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum_Leet39 {
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {

        List<List<Integer>> result = new ArrayList<>();

        backtrack(candidates, target, 0, new ArrayList<>(), result);

        return result;
    }

    private static void backtrack(
            int[] candidates,
            int target,
            int start,
            List<Integer> current,
            List<List<Integer>> result) {

        // Found a valid combination
        if (target == 0) {
            result.add(new ArrayList<>(current));
            return;
        }

        for (int i = start; i < candidates.length; i++) {

            // Too large
            if (candidates[i] > target) {
                continue;
            }

            // Choose
            current.add(candidates[i]);

            // Explore
            // Use i instead of i + 1 because we can reuse the same number
            backtrack(
                    candidates,
                    target - candidates[i],
                    i,
                    current,
                    result
            );

            // Undo
            current.removeLast();
        }
    }
    public static void main(String[] args) {

        // Test Case 1
        int[] candidates1 = {2, 3, 6, 7};
        int target1 = 7;

        System.out.println(
                combinationSum(candidates1, target1)
        );

        // Test Case 2
        int[] candidates2 = {2, 3, 5};
        int target2 = 8;

        System.out.println(
                combinationSum(candidates2, target2)
        );

        // Test Case 3
        int[] candidates3 = {2};
        int target3 = 1;

        System.out.println(
                combinationSum(candidates3, target3)
        );
    }
}
