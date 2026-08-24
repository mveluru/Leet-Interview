package leetcode75.medium;

import java.util.*;
import java.util.stream.Collectors;

public class NonRepeatsubstring {

   public void nonRepeatSubstring(String S,int size) {
       char[] charS = S.toCharArray();
       List<String> result = new ArrayList<>();
       if (charS.length < size) {
           return;
       }
       for (int i = 0; i <= charS.length - size; i++) {
           String substring = S.substring(i, i + size);
           if (checkSubstring(substring)) {
               result.add(substring);
           }
       }
         if (result.isEmpty()) {
             System.out.println("no substring found");
             return;
         }
         System.out.println(String.join(",", result));

    }
    public boolean checkSubstring(String S) {

       Set<String> set = new HashSet<>();
      for (char c : S.toCharArray()) {
          set.add(String.valueOf(c));

      }
        return set.size() == S.length();

    }
    public static void main(String[] args) {
       NonRepeatsubstring nrs = new NonRepeatsubstring();
       nrs.nonRepeatSubstring("abcabcbb", 3);
       nrs.nonRepeatSubstring("bbbb", 2);
    }
}
