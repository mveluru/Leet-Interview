package leetcode75.easy;

import java.util.Stack;

public class RemoveNeigborDuplicates {

	public static void removeNeigborDuplicate(String str) {
		char[] strchars = str.toCharArray();
		Stack<Character> stack = new Stack<>();
		StringBuilder sb = new StringBuilder();
		for (char c : strchars) {
			if(!stack.isEmpty()  && stack.peek()==c) {
				stack.pop();
			}else {
				stack.push(c);
			}
		}
		
		while (!stack.isEmpty()) {
			sb.insert(0, stack.pop());
		}
		System.out.printf("\nThe new string %3S", str);
		System.out.printf("\nThe new string %3S", sb);

	}

	public static void main(String[] args) {
		removeNeigborDuplicate("Murarrlill");

	}

}
