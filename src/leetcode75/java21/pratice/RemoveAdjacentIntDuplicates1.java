package leetcode75.java21.pratice;

import java.util.Stack;

public class RemoveAdjacentIntDuplicates1 {
    public static void removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        Stack<Integer> stack = new Stack<>();
        for (int i : nums) {
            if (!stack.isEmpty() && stack.peek() == i) {
                stack.pop();
            } else {
                stack.push(i);
            }


        }
        for (int i : stack) {
            System.out.print(i + " ");
        }

    }

    public static void main(String[] args) {
        RemoveAdjacentIntDuplicates1 r = new RemoveAdjacentIntDuplicates1();
        r.removeDuplicates(new int[]{1, 2, 3, 3, 4, 5, 5, 7, 8,8,9});
    }
}
