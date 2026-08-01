package leetcode75.easy;

import java.util.Scanner;

public class LeftJustify {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        int n = in.nextInt();
        System.out.printf("Formated String %-15s%03d\n",s,n);
    }

}
