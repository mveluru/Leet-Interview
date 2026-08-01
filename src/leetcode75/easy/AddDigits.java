package leetcode75.easy;

public class AddDigits {

    public static int addDigits(int num) {
        int sum = 0;
        if (num >= 0 && num <= (Math.pow(2, 31) - 1)) while (num > 0) {
            int reminder = num % 10;
            num = num / 10;
            sum += reminder;
            if (num == 0 && sum >= 10) {
                num = sum;
                sum = 0;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        //int num = 38;
        //int num = 39;
        //int num =40;
        //int num =51;
        int num = 1234;
        int singleDigit = addDigits(num);
        System.out.println(singleDigit);
    }
}
