package leetcode75.medium;

import java.util.Arrays;
import java.util.Scanner;

public class Anagram_Scanner_readfromkeyboard {


    static boolean isAnagram(String a, String b) {
        // Complete the function
        if (a.length() != b.length()) {
            return false;
        }
        char[] achar = a.toLowerCase().toCharArray();
        char[] bchar = b.toLowerCase().toCharArray();
        Arrays.sort(achar);
        Arrays.sort(bchar);
        if (Arrays.equals(achar, bchar)) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scan = new Scanner(System.in);
        String a = scan.next();
        String b = scan.next();
        scan.close();
        boolean ret = isAnagram(a, b);
        System.out.println((ret) ? "Anagrams" : "Not Anagrams");
    }
}


