package leetcode75.java21.pratice;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class FindDuplicateChars {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        char[] arr = str.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        for(char c : arr){
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        int count = 0;
       for(Map.Entry<Character, Integer> entry : map.entrySet()){
           if(entry.getValue() >1){
               System.out.println(entry.getKey() + " : " + entry.getValue());
           }
       }
    }

}
