package leetcode75.medium;

public class HappyNumber_looping_sumOfdigits_Sqr {

    public static void HappyNumber(int n) {
        int number = n;
        boolean ishappyNumber = false;
        while (number!=1) {
            int sum =0;
            while (number>0) {
                int reminder = number%10;
                sum = sum + reminder*reminder;
                number = number/10;
            }
            number = sum;
            if (number==1) {
                ishappyNumber=true;
                System.out.println("Happy Number : "+ishappyNumber);
                break;
            }else if (number>1 && number<10){
                System.out.println("Happy Number : "+ishappyNumber);
                break;

            }

        }
    }

    public static void main(String[] args){
        HappyNumber(19);
        HappyNumber(21);

    }
}
