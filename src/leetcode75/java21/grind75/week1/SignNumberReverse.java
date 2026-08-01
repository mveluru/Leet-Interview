package leetcode75.java21.grind75.week1;

public class SignNumberReverse {

    public static int signNumReverse(int num) {
        int reverseNum = 0;
        int sign = 0;
        sign = num >= 0 ? 1 : -1;
        num = Math.abs(num);
        while (num != 0) {
            int reminder = num % 10;
            reverseNum = reverseNum * 10 + reminder;
            num = num / 10;
        }

        return reverseNum * sign;
    }

    public static void main(String[] args) {
        System.out.println(signNumReverse(123));
        System.out.println(signNumReverse(-123));
        System.out.println(signNumReverse(120));
        System.out.println(signNumReverse(0));
        System.out.println(signNumReverse(1534236469));
    }
}
