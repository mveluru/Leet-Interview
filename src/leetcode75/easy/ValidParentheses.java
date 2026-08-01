package leetcode75.easy;

import java.util.Stack;

public class ValidParentheses {

    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }

                char top = stack.pop();
                if (c == ')' && top != '(') {
                    return false;
                } else if (c == '}' && top != '{') {
                    return false;
                } else if (c == ']' && top != '[') {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }

    public static void main(String[] args) {

        String parentheses = "( { [ } ) ]";
        boolean isp0Valid = isValid(parentheses);
        System.out.println(isp0Valid);// false

        String parentheses_1 = "()";
        boolean isp1Valid = isValid(parentheses_1);
        System.out.println(isp1Valid); // true

        String parentheses_2 = "()[]{}";
        boolean isp2Valid = isValid(parentheses_2);
        System.out.println(isp2Valid); // true

        String parentheses_3 = "(]";
        boolean isp3Valid = isValid(parentheses_3);
        System.out.println(isp3Valid); // false

    }


}
