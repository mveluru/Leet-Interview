package leetcode75.easy;
//Problem#169
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MajorityElementMoreThanitsHalfSize {
    public static void majorityElement(int[] nums) {
        int maxOccurence = nums.length / 2;
        Arrays.sort(nums);
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
            if (map.get(num) >= maxOccurence) {
                maxOccurence = map.get(num);
            }
        }
        //System.out.println(maxOccurence);
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == maxOccurence) {
                System.out.println(entry.getKey());
                break;
            }
        }

    }

    public static void main(String[] args) {
        int[] nums = {3, 2, 3};
        majorityElement(nums);
        int[] nums2 = {2, 2, 1, 1, 1, 2, 2};
        majorityElement(nums2);
        int[] nums3 = {5, 5, 5, 5, 1, 5, 5};
        majorityElement(nums3);
    }
}
