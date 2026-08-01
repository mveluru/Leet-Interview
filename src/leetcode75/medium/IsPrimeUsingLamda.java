package leetcode75.medium;

import java.util.Scanner;

public class IsPrimeUsingLamda {
    // Odd check using lambda
    static java.util.function.Predicate<Integer> isOdd =
            n -> n % 2 != 0;

    // Prime check using lambda
    static java.util.function.Predicate<Integer> isPrime =
            n -> {

                if (n < 2) {
                    return false;
                }

                for (int i = 2; i * i <= n; i++) {

                    if (n % i == 0) {
                        return false;
                    }
                }

                return true;
            };

    // Palindrome check using lambda
    static java.util.function.Predicate<Integer> isPalindrome =
            n -> {

                int original = n;
                int reverse = 0;

                while (n > 0) {

                    int digit = n % 10;

                    reverse = reverse * 10 + digit;

                    n /= 10;
                }

                return original == reverse;
            };

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        int T = scan.nextInt();

        while (T-- > 0) {

            int condition = scan.nextInt();
            int num = scan.nextInt();

            switch (condition) {

                case 1:

                    System.out.println(
                            isOdd.test(num)
                                    ? "ODD"
                                    : "EVEN"
                    );

                    break;

                case 2:

                    System.out.println(
                            isPrime.test(num)
                                    ? "PRIME"
                                    : "COMPOSITE"
                    );

                    break;

                case 3:

                    System.out.println(
                            isPalindrome.test(num)
                                    ? "PALINDROME"
                                    : "NOT PALINDROME"
                    );

                    break;

                default:

                    System.out.println("Invalid Input");
            }
        }

        scan.close();
    }
}
