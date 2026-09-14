package leetcode75.hard;

import java.util.LinkedList;
import java.util.Queue;

public class movingAverage_running {

    private final Queue<Integer> queue;
    public double running_sum;
    public int maxSize;

    public movingAverage_running(int size) {
        this.queue = new LinkedList<>();
        this.running_sum = 0.0;
        this.maxSize = size;
    }

    public double next(int value) {
        // 1. If the window is full, remove the oldest element from the sum and queue
        if (queue.size() == maxSize) {
            running_sum -= queue.poll();
        }
        // 2. Add the new value to the queue and update the running sum
        queue.offer(value);
        running_sum += value;
        // 3. Calculate and return the average
        return running_sum / queue.size();
    }

    public static void main(String[] args) {
        movingAverage_running movingAverage = new movingAverage_running(3);
        System.out.println(movingAverage.next(1));  // Output: 1.0
        System.out.println(movingAverage.next(10)); // Output: 5.5
        System.out.println(movingAverage.next(3));  // Output: 4.666666666666667
        System.out.println(movingAverage.next(5));  // Output: 6.0
    }
}
