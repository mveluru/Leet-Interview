package leetcode75.medium;

import java.util.Arrays;
import java.util.List;

public class MaxNumOfVowlesinASubstring {


    public static void printSubstring(String substring, int size) {
        int maxVowels = 0;
        for (int i = 0; i < substring.length() - size; i++) {
            String sub = substring.substring(i, i + size);
            maxVowels = Math.max(maxVowels, subStringVowelsCount(sub));;

        }
        System.out.println("Maximum vowels in any substring of size " + size + ": " + maxVowels);

    }
   public static int subStringVowelsCount(String substring) {
        int vowels = 0;
        List<Character> vowelList = Arrays.asList('a', 'e', 'i', 'o', 'u');
        for (char c : substring.toCharArray()) {
            if (vowelList.contains(c)) {
                vowels++;
            }
        }
        return vowels;
    }
    public static void main(String[] args) {
        String s = "abciiidef";
        int size = 3;
        printSubstring(s, size);

        String l = "leetcode";
        int arraySize = 2;
        printSubstring(l, arraySize);
    }
}
