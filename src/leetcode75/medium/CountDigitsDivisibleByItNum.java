package leetcode75.medium;

public class CountDigitsDivisibleByItNum {
    private int countdigits(int nums) {
        int count = 0;
        if (nums >= 1 && nums <= Math.pow(10, 9)) {
            int divisor = nums;
            while (nums > 0) {
                int reminder = nums % 10;
                if (divisor % reminder == 0) {
                    count++;
                }
                nums = nums / 10;

            }
        }

        return count;
    }

    public static void main(String[] args) {
        CountDigitsDivisibleByItNum countDigitsDivisibleByItNum = new CountDigitsDivisibleByItNum();
        int nums = 1248;
        //int nums = 121;
        //int nums = 7;
        System.out.println(countDigitsDivisibleByItNum.countdigits(nums));
    }
}
