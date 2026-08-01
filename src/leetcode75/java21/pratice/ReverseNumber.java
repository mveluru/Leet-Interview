package leetcode75.java21.pratice;

public class ReverseNumber {
    private static int reverseNumber(int num){
        int reverse = 0;

        if (num > Integer.MAX_VALUE || num < Integer.MIN_VALUE) {
            return -1;
        }
        while (num != 0) {
            int temp = num % 10;
            num = num / 10;
            reverse = (reverse * 10) + temp;
        }
       return(reverse);

    }
    public static void main(String[] args) {
        int num = 20001;
        System.out.println(reverseNumber(num));

    }
}
