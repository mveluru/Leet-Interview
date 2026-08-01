package leetcode75.easy;

import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;

public class ReverseWordsInStringII {

    private static char[] reverseStringwordsInTochar(char[] s) {

        String str = new String(s);
        // System.out.println(str);

        List<String> list = Arrays.stream(str.split("\\s")).toList();
        ListIterator<String> reverselist = list.listIterator(list.size());
        String newString = "";
        while (reverselist.hasPrevious()) {
            newString += reverselist.previous() + " ";

        }
        char[] chars = newString.trim().toCharArray();
        return chars;
    }

    public static void main(String[] args) {
        // char[] s = {'t', 'h', 'e', ' ', 's', 'k', 'y', ' ', 'i', 's', ' ', 'b', 'l', 'u', 'e' };
        //char[] s = {'a'};
        char[] s = {'J', 'o', 'h', 'n', 'J', 'r', ' ', 'g', 'r', 'e', 'a', 't' };
        char[] chararray = reverseStringwordsInTochar(s);
        System.out.println(Arrays.toString(chararray));
    }

}
