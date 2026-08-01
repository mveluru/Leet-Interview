package leetcode75.java21.grind75.week1;

import java.util.Stack;

public class RemoveAdjacentIntDuplicates {
    public void removeDuplicates(int[] nums) {
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
        for(int i:stack){
            System.out.print(i+" ");
        }
    }
    public static void main(String[] args) {
        RemoveAdjacentIntDuplicates solution = new RemoveAdjacentIntDuplicates();
        solution.removeDuplicates(new int[]{1,2,3,3,4,5,6,6,7,8,8,9});

    }
}

