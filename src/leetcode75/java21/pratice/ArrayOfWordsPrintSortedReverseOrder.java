package leetcode75.java21.pratice;

import java.util.Arrays;

public class ArrayOfWordsPrintSortedReverseOrder {

    public static void main(String[] args) {
        String[] wordsList = new String[]{"hello","world","leetcode"};
        Arrays.sort(wordsList);
        for (int i = wordsList.length - 1; i >= 0; i--) {
            System.out.print(wordsList[i] + " ");
        }
    }
}
