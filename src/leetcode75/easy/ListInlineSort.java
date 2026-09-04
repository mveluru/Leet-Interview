package leetcode75.easy;

import java.util.Arrays;
import java.util.List;

public class ListInlineSort {
    public static  void main(String[] args){
        List<Integer> nums =
                Arrays.asList(5, 2, 8, 1);
        nums.sort(Integer::compareTo);
        System.out.println(nums);
    }
}
