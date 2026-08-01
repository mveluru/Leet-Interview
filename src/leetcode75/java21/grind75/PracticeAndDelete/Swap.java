package leetcode75.java21.grind75.PracticeAndDelete;

public class Swap {
    public static void main(String[] args) {
        int a=10;
        int b=20;

        b = b^a;
        a = a^b;
        b = b^a;
        System.out.println(b +" "+a);


    }
}
