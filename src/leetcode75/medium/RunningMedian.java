package leetcode75.medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class RunningMedian {
    // Stores the smaller half of the numbers (highest value at the top)
    private final PriorityQueue<Double> maxHeap;
    private final PriorityQueue<Double> minHeap;

    public RunningMedian() {
        maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        minHeap = new PriorityQueue<>();
    }

    public void addNum(double num) {
        if (maxHeap.isEmpty() || num <= maxHeap.peek()) {
            maxHeap.add(num);
        } else {
            minHeap.add(num);
        }

        // balance
        if (maxHeap.size() > minHeap.size()) {
            minHeap.add(maxHeap.poll());
        } else if (minHeap.size() > maxHeap.size()) {
            maxHeap.add(minHeap.poll());
        }
    }

    public double findMedian() {
        if (maxHeap.isEmpty() || minHeap.isEmpty()) {
            return 0;
        }
        if (maxHeap.size() == minHeap.size()) {
            return (maxHeap.peek() + minHeap.peek()) / 2.0;
        }
        return maxHeap.peek();
    }

    public static void main(String[] args) {
        double[] stream = {5.0, 15.0, 1.0, 3.0, 8.0, 7.0};
        RunningMedian tracker = new RunningMedian();

        for (double num : stream) {
            tracker.addNum(num);
            System.out.printf("Added: %-4.1f | Current Median: %.1f%n", num, tracker.findMedian());
        }
    }
}
