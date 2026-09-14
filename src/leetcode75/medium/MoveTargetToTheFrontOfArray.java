package leetcode75.medium;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class MoveTargetToTheFrontOfArray {
    public static void movesToTarget(int[] nums, int target) {
        int[] numbers = {1, 0, 3, 0, 12, 0, 5};

        Queue<Integer> queue = new LinkedList<>();
        int zeroCount = 0;

        for (int number : numbers) {
            if (number == 0) {
                zeroCount++;
            } else {
                queue.offer(number);
            }
        }

        int insertPosition = 0;

        while (insertPosition < zeroCount) {
            numbers[insertPosition++] = 0;
        }

        while (!queue.isEmpty()) {
            numbers[insertPosition++] = queue.poll();
        }

        System.out.println(Arrays.toString(numbers));
    }

    public static void movesToTarget2(int[] nums, int target) {
        int[] numbers = {1, 0, 3, 0, 12, 0, 5};

        int insertPosition = numbers.length - 1;

// Move non-zero values from right to left
        for (int i = numbers.length - 1; i >= 0; i--) {
            if (numbers[i] != 0) {
                numbers[insertPosition] = numbers[i];
                insertPosition--;
            }
        }

// Fill remaining positions with zeroes
        while (insertPosition >= 0) {
            numbers[insertPosition] = 0;
            insertPosition--;
        }

        System.out.println(Arrays.toString(numbers));
    }

    public static void main(String[] args) {
        int[] numbers = {1, 0, 3, 0, 12, 0, 5};
        int targets = 0;
        movesToTarget(numbers, targets);
        movesToTarget2(numbers, targets);
    }
}
