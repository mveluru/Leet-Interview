package leetcode75.medium;

import java.util.Stack;
import java.util.stream.Stream;

public class ReverseTheline_wordsUsingLoop {

    public static String wordsUsingStack(String words) {
        String[] stringArray = words.split("\\s+");
        Stack<String> stack = new Stack<>();
        Stream.of(stringArray).forEach(stack::push);
        StringBuffer sb = new StringBuffer();
        while (!stack.isEmpty()) {
            sb.append(stack.pop()).append(" ");
        }

        System.out.println(sb.toString());
        return sb.toString();
    }

    public String reverseWords(String string) {
        String[] words = string.split("\\s+");
        StringBuffer sb = new StringBuffer();
        for (int i = words.length - 1; i >= 0; i--) {
            sb.append(words[i].trim()).append(" ");
        }
        System.out.println(sb.toString());
        //Collections.reverse(Arrays.asList(words));
        return sb.toString();
    }

    public static void main(String[] args) {
        String s = "the sky is blue";
        System.out.println("Reversed string using stack: " + wordsUsingStack(s));

    }
}
