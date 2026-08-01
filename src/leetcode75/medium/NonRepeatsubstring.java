package leetcode75.medium;

import java.util.*;
import java.util.stream.Collectors;

public class NonRepeatsubstring {

    public static void main(String[] args) {
        //String input = "lkjsdflkjldsfffffsss";
        //String input = "abcdefghijklmnopqrst";
        //String input = "abcabcbb";
        //String input = "bbbbbbb";
        String input = "pwwkew";
        Set<String> setinput = new HashSet<>();
        for (int i = 0; i < input.length(); i++) {
            for (int j = i + 1; j <= input.length(); j++) {
                String ss = input.substring(i, j);
                if (ss.length()>=1 && (ss.chars().distinct().count() == ss.length())) {
                    setinput.add(input.substring(i, j));
                }

            }
        }

        int lenMax = setinput.stream().mapToInt(String::length).max().getAsInt();
       Set<String> maxLengset = setinput.stream().filter(s -> s.length()==lenMax).collect(Collectors.toSet());

        //Arrays.sort(setinput.toArray());
        System.out.println(maxLengset);




    }
}
