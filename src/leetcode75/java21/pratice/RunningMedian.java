package leetcode75.java21.pratice;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class RunningMedian {
    private static PriorityQueue<Integer> lowerpriorityQueue = new PriorityQueue<>(Collections.reverseOrder());
    private static PriorityQueue<Integer> upperpriorityQueue = new PriorityQueue<>();

    private void add(int num) {
        if(lowerpriorityQueue.isEmpty() || num < lowerpriorityQueue.peek()) {
            lowerpriorityQueue.add(num);
        }else{
            upperpriorityQueue.add(num);
        }
        balance();
    }
    private static void balance() {
        if (lowerpriorityQueue.size() > upperpriorityQueue.size() + 1) {
            upperpriorityQueue.add(lowerpriorityQueue.poll());
        } else if (upperpriorityQueue.size() > lowerpriorityQueue.size()) {
            lowerpriorityQueue.add(upperpriorityQueue.poll());
        }
    }


    private double getMedian() {
        if (lowerpriorityQueue.size() > upperpriorityQueue.size()) {
            return lowerpriorityQueue.peek();
        } else if (upperpriorityQueue.size() > lowerpriorityQueue.size()) {
            return upperpriorityQueue.peek();
        } else {
            return (lowerpriorityQueue.peek() + upperpriorityQueue.peek()) / 2.0;
        }
    }

    public static void main(String[] args) {
        RunningMedian runningMedian = new RunningMedian();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            runningMedian.add(sc.nextInt());
            System.out.printf("%.1f%n", runningMedian.getMedian());

        }
    }
}
