package leetcode75.easy;

public class PalindromDigits {
    public static boolean isPalindrom(int num) {
        int palindrom = num;
        int orinum = num;
        int reversed = 0;

        while (palindrom > 0) {
            int digit = palindrom % 10;
            reversed = reversed * 10 + digit;
            palindrom = palindrom / 10;

        }
        return reversed == orinum;
    }

    public static void negativePlaindrom(int num) {
        int sign = 0;
        int palinNum = 0;
        int reverseNum = 0;

        if (num < 0) {
            sign = -1;
            palinNum = Math.abs(num);
        }
        while (palinNum > 0) {
            reverseNum = reverseNum * 10 + palinNum % 10;
            palinNum = palinNum / 10;
        }
        if (reverseNum == Math.abs(num)) {
            if (sign == -1) {
                reverseNum = reverseNum * sign;
            }
            System.out.print("Palindrom  " + reverseNum);
        } else {
            System.out.print("Not Palindrom " + num);
        }


    }

    public static void main(String[] args) {
        System.out.println(isPalindrom(131));
    }
}
