package leetcode75.medium;
import java.util.Stack;


public class Stack_Balanced_Brackets {
    public boolean checkBalanced(String s) {
        // Use a stack to store opening brackets
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '{' || c == '[' || c == '(') {
                stack.push(c);
            }
            else {
                if (stack.isEmpty()){
                    return false;
                }
                char top = stack.pop();
                if ((c == ')' && top != '(') ||
                        (c == '}' && top != '{') ||
                        (c == ']' && top != '[')) {
                    return false;
                }
            }


        }
        return stack.isEmpty();

    }
    public static void main(String[] args) {
        Stack_Balanced_Brackets sb = new Stack_Balanced_Brackets();
        System.out.println("Enter a string: "+sb.checkBalanced("{[]}"));


    }
}
