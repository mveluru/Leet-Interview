package leetcode75.java21.pratice;

public class ReverseNum {

        public static void revnum(int num){
            int reversed = 0;
            if (num>10 && num<Integer.MAX_VALUE){
                while (num!=0){
                    int temp=num%10;
                    num=num/10;
                    reversed = reversed * 10 + temp;
                }
                System.out.println("Reversed number: " + reversed);
            }

        }


    public static void main(String[] args) {
        int num = 20001;
        ReverseNum.revnum(num);
    }
}

