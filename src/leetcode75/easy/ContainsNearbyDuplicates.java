package leetcode75.easy;
//problem:219

import java.util.HashMap;
import java.util.Map;

public class ContainsNearbyDuplicates {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if (nums == null || nums.length == 0)
            return false;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            if(map.containsKey(nums[i])){
                int index = map.get(nums[i]);
                if(i-index<=k){
                    return true;
                }
            }else{
                map.put(nums[i],i);
            }
        }
        return false;
    }
   public static void main(String[] args) {
        ContainsNearbyDuplicates duplicates = new ContainsNearbyDuplicates();
        System.out.println(duplicates.containsNearbyDuplicate(new int[]{1,0,2,1,5}, 3));
        System.out.println(duplicates.containsNearbyDuplicate(new int[]{1,2,3,1}, 3));
        System.out.println(duplicates.containsNearbyDuplicate(new int[]{0,1,3,1}, 2));
   }
}
