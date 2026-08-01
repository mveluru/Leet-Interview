package leetcode75.hard;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class BowlingPIN {
    // Maximum pin string length based on HackerRank constraints
    private static final int MAX_PINS = 301;
    private static final int[] grundyValues = new int[MAX_PINS];

    public static void main(String[] args) {
        // Precompute all Grundy values up to MAX_PINS
        precomputeGrundy();

        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) return;

        int t = scanner.nextInt(); // Number of test cases

        while (t-- > 0) {
            int n = scanner.nextInt(); // Number of pins
            String s = scanner.next(); // Pin configuration string (e.g., "IXXII")

            int totalNimSum = 0;
            int consecutivePins = 0;

            // Segment the board into independent sections of consecutive 'I's
            for (int i = 0; i < n; i++) {
                if (s.charAt(i) == 'I') {
                    consecutivePins++;
                } else {
                    if (consecutivePins > 0) {
                        totalNimSum ^= grundyValues[consecutivePins];
                    }
                    consecutivePins = 0;
                }
            }
            // Handle trailing group of 'I's if the string ends with 'I'
            if (consecutivePins > 0) {
                totalNimSum ^= grundyValues[consecutivePins];
            }

            // A non-zero Nim-sum represents a winning position for the first player
            if (totalNimSum != 0) {
                System.out.println("WIN");
            } else {
                System.out.println("LOSE");
            }
        }
        scanner.close();
    }

    /**
     * Precomputes the Grundy values using the Minimum Excluded value (MEX) property.
     */
    private static void precomputeGrundy() {
        grundyValues[0] = 0; // Base case: 0 pins remaining is a losing state

        for (int i = 1; i < MAX_PINS; i++) {
            Set<Integer> reachableGrundyValues = new HashSet<>();

            // Option 1: Knock down exactly ONE pin at index 'j' (0-indexed)
            // This splits the line of length 'i' into two groups of lengths: j and (i - j - 1)
            for (int j = 0; j < i; j++) {
                int leftGroup = j;
                int rightGroup = i - j - 1;
                reachableGrundyValues.add(grundyValues[leftGroup] ^ grundyValues[rightGroup]);
            }

            // Option 2: Knock down TWO adjacent pins starting at index 'j'
            // This splits the line of length 'i' into two groups of lengths: j and (i - j - 2)
            for (int j = 0; j <= i - 2; j++) {
                int leftGroup = j;
                int rightGroup = i - j - 2;
                reachableGrundyValues.add(grundyValues[leftGroup] ^ grundyValues[rightGroup]);
            }

            // Assign the MEX of the reachable set to current length i
            grundyValues[i] = getMex(reachableGrundyValues);
        }
    }

    /**
     * Helper method to find the Minimum Excluded Value (MEX) from a set.
     */
    private static int getMex(Set<Integer> set) {
        int mex = 0;
        while (set.contains(mex)) {
            mex++;
        }
        return mex;
    }
}
