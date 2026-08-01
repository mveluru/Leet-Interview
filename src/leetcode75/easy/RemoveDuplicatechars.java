package leetcode75.easy;


import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RemoveDuplicatechars {

    public static String distinctchars_1(String input){

        List<Character> abc = new LinkedList<>();
        char[] inputchars = input.toCharArray();
        for (char c: inputchars){
            abc.add(c);
        }
        String string = abc.stream().distinct().map(String::valueOf).collect(Collectors.joining());
        return string;
    }

    public static String distinctchars_2(String input){
      String string =  Arrays.stream(input.split("")).distinct().map(String::valueOf).collect(Collectors.joining());
      return string;
    }

    public static String distinctchars_3(String input){
        IntStream intStream = input.chars().distinct();
        int[] charintArrays = intStream.toArray();
        StringBuilder sb = new StringBuilder();
        for (int i: charintArrays){
            sb.append((char) i);
        }
        return sb.toString();
    }



    public static void main(String[] args) {
        String input ="ddslkjfdskjdskkkdsla";

        System.out.println(distinctchars_1(input));

        System.out.println(distinctchars_2(input));
        System.out.println(distinctchars_3(input));

    }
}
