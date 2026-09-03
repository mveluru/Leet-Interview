package leetcode75.easy;

import java.util.Stack;

public class RemoveNeigborDuplicates {

	public static void removeNeigborDuplicate(String str) {
		char[] strchars = str.toLowerCase().toCharArray();
		Stack<Character> stack = new Stack<>();
		StringBuilder sb = new StringBuilder();
		for (char c : strchars) {
			// If stack is empty OR the current char is DIFFERENT from the neighbor on top
			if (stack.isEmpty() || stack.peek() != c) {
				stack.push(c);
			}
			// If stack.peek() == c, it's a repeated neighbor, so we skip it completely!
		}
		while (!stack.isEmpty()) {
			sb.append(stack.pop());
		}
		System.out.println(sb.reverse());

	}

	public static void main(String[] args) {
		removeNeigborDuplicate("Murarrlii");
		//removeNeigborDuplicate("MMurarrlii");

	}

}
