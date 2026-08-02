package leetcode75.easy;

public class Tribonacci {

    public int tribonacci(int n) {
        {
            // Base cases handled immediately before array allocation
            if (n == 0) return 0;
            if (n == 1 || n == 2) return 1;

            // FIXED: Array size must be n + 1 to safely hold index 'n'
            int[] tribo = new int[n + 1];

            tribo[0] = 0;
            tribo[1] = 1;
            tribo[2] = 1;

            // FIXED: Loop condition runs up to 'n' to calculate the target value
            for (int i = 3; i <= n; i++) {
                tribo[i] = tribo[i - 1] + tribo[i - 2] + tribo[i - 3];

                // Handle integer overflow gracefully
                if (tribo[i] < 0) {
                    System.out.println("Warning: Integer overflow detected at n = " + i);
                    return -1;
                }
            }

            // FIXED: Returns index 'n' directly
            return tribo[n];
        }
    }

    public static void main(String[] args) {
        Tribonacci tribonacci = new Tribonacci();
        System.out.println(tribonacci.tribonacci(25));
    }
}
