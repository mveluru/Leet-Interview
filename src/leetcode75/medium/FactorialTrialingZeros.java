package leetcode75.medium;

public class FactorialTrialingZeros {

    private static int factorial(int n) {
        if (n == 0)
            return 0;
        if (n == 1)
            return 1;
        return n * factorial(n - 1);
    }

    public static int findTrailingZero(int n) {
        int factorial = factorial(n);
        System.out.println("Factorial of " + n + " is: " + factorial);
        if (factorial == 0)
            return 0;
        if (factorial == 1)
            return 1;
        int count = 0;
        while (factorial % 10 == 0) {
            count++;
            factorial = factorial / 10;

        }
        return count;

    }

    public static void main(String[] args) {
        System.out.println("Number of trailing zeros in 5! is: " + findTrailingZero(5));
        System.out.println("Number of trailing zeros in 6! is: " + findTrailingZero(6));
        System.out.println("Number of trailing zeros in 9! is: " + findTrailingZero(9));
        System.out.println("Number of trailing zeros in 10! is: " + findTrailingZero(10));
    }
}
