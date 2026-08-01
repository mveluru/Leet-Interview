package leetcode75.hard;

import java.util.Scanner;

public class BigInteger {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        long a = scan.nextLong();
        long b = scan.nextLong();
        scan.close();
        System.out.println(a+b +"\n"+a*b);
    }
}
