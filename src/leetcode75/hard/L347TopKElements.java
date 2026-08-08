package leetcode75.hard;

import java.util.*;

public class L347TopKElements {

    public static List<Integer> topKFrequent(int[] nums, int k) {
        //Step1
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++){
            countMap.put(nums[i], countMap.getOrDefault(nums[i], 0) + 1);
        }
        // Create Min-Heap Priority Queue
        PriorityQueue<Integer> minHeap = new PriorityQueue<>((a, b) -> countMap.get(a) - countMap.get(b));
        for (int num : countMap.keySet()) {
            minHeap.add(num);
            if (minHeap.size() > k) {
                minHeap.poll(); // Removes the element with the lowest frequency
            }
        }
        List<Integer> result = new ArrayList<>();
        while(!minHeap.isEmpty()){
            result.add(minHeap.poll());
        }
        Collections.reverse(result);
        return result;
    }


    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 2, 2, 3, 4, 4, 4, 4};
        int k = 2;
        System.out.println(topKFrequent(nums, k));
    }

}
