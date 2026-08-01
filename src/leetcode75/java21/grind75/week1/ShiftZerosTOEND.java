package leetcode75.java21.grind75.week1;

import java.util.*;

public class ShiftZerosTOEND {
    public static void main(String[] args) {
        int[] nums = {0, 1, 0, 3, 0, 2, 3};

        List<Integer> list = new ArrayList<>(Arrays.stream(nums).boxed().filter(x->x !=0).sorted(Comparator.naturalOrder()).toList());
        while(list.size()<nums.length){
            list.add(0);
        }
        list.forEach(x->System.out.print(x+" "));

        //
        Set<Integer> set = new HashSet<>(Arrays.stream(nums).boxed().filter(x->x !=0).toList());




    }
}
