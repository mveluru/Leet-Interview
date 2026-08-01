package leetcode75.java21.grind75.PracticeAndDelete;

import java.util.Arrays;

public class Anagram {

    public static void main(String[] args) {
        String str1 = "abc";
        String str2 = "cba";
        char[] arr1 = str1.toCharArray();
        char[] arr2 = str2.toCharArray();
        Arrays.sort(arr1);
        Arrays.sort(arr2);

        System.out.println(Arrays.equals(arr1, arr2));


    }
}
