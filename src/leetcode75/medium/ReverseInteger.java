package leetcode75.medium;

// This code doesn't work on Integer over flow cases.
public class ReverseInteger {
    private static int reverseNumber(int x) {
        long y = x;
        long sum = 0;
        boolean isNegativex = false;

        if (x < 0 && x > Integer.MIN_VALUE) {
            isNegativex = true;
            x= Math.abs(x);

        } else if (x > Integer.MAX_VALUE && x < Integer.MIN_VALUE) {
            sum = y;
            return (int) sum;
        }

        while (x > 0) {
            int reminder = x % 10;
                sum = (sum * 10);
            if (sum == (int) sum && sum > Integer.MIN_VALUE && sum < Integer.MAX_VALUE) {
                 sum = sum + reminder;
                  x = x / 10;
            }
            if (sum != (int) sum || sum < Integer.MIN_VALUE && sum > Integer.MAX_VALUE ){
                sum = y;
                return (int) sum;
            }

        }

        sum = isNegativex ?  sum * (-1) : (int) sum;
        return (int)sum;
    }

    public static void main(String[] args) {
        //Integer x = 321;
        //Integer x = -123;
        //Integer x = 120;
       // System.out.println(Integer.MIN_VALUE);
        Integer x = -2147483641;



        System.out.println(ReverseInteger.reverseNumber(x));
    }
}
