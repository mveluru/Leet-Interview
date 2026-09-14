package leetcode75.medium;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FirstUniqueCharOfGivenString {

    public static void firstUniqChar(String input) {


        // Expected Output: 0 (because 'm' is the first character that only appears once)

        Map<Character, Long> fequencyMap= input.chars().mapToObj(c->(char)c)
                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new,Collectors.counting()));
        System.out.println(fequencyMap);
        int indexNumber=-1;
        for (int i =0;i<input.length();i++) {
            if(fequencyMap.get(input.charAt(i))==1) {
                indexNumber=i;
                break;
            }
        }
        System.out.println("First unique char index: " + indexNumber);

    }

    public static void main(String[] args) {
        String input = "muraliiiiii";
        firstUniqChar(input);

    }
}
