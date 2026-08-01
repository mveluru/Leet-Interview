package leetcode75.easy;

public class ChangeWithNoTemp {
    public static void main(String[] args) {
        int a =10;
        int b =11;
        System.out.println("a =" + a + " b =" + b);
        // Step 1:
        // a = 10 ^ 11 = 1
        a ^= b;

        // Step 2:
        // b = 11 ^ 1 = 10 (original value of a)
        b ^= a;

        // Step 3:
        // a = 1 ^ 10 = 11 (original value of b)
        a ^= b;
        System.out.println("a =" + a + " b =" + b);
    }
}
