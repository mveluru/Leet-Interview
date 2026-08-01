package leetcode75.easy;

public class PalindromDigits {
    public static boolean isPalindrom(int num) {
        int palindrom = num;
        int orinum = num;
        int reversed = 0;

        while (palindrom >0) {
            int digit = palindrom % 10;
            reversed = reversed*10 + digit;
            palindrom = palindrom / 10;

        }
        return reversed == orinum;
    }
    public static void main(String[] args) {
        System.out.println(isPalindrom(131));
    }
}
