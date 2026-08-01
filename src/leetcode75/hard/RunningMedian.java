package leetcode75.hard;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class RunningMedian {
    private static PriorityQueue<Integer> lower = new PriorityQueue<>(Collections.reverseOrder());
    private static PriorityQueue<Integer> upper = new PriorityQueue<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            add(sc.nextInt());
            System.out.printf("%.1f%n", getMedian());
        }
    }

    private static void add(int num) {
        if (lower.isEmpty() || num <= lower.peek()) {
            lower.add(num);
        } else {
            upper.add(num);
        }

        balance();
    }

    private static void balance() {
        if (lower.size() > upper.size() + 1) {
            upper.add(lower.poll());
        } else if (upper.size() > lower.size()) {
            lower.add(upper.poll());
        }
    }

    private static double getMedian() {
        if (lower.size() == upper.size()) {
            return (lower.peek() + upper.peek()) / 2.0;
        }

        return lower.peek();
    }
}
