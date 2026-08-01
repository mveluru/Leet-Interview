package leetcode75.java21.grind75.week1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;


public class Integers_Reverse {
    public void Int_reverse(int[] nums){
        List<Integer> list = new ArrayList<>(Arrays.stream(nums).boxed().toList());
        Collections.reverse(list);
        System.out.println("Collection" + list);

        list.stream().sorted(Integer::compareTo).forEach(integer ->  System.out.print(integer+" "));
        System.out.println();
        System.out.println("num2.....");
        System.out.println();
        list.stream().sorted(Integer::compareTo).forEach(integer ->  System.out.print(integer+" "));
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6,7,8,9,10};
        int[] nums2 = {10,9,8,7,6,5,4,3,2,1};
        Integers_Reverse integers_reverse = new Integers_Reverse();
        integers_reverse.Int_reverse(nums);
        System.out.println();


        Integers_Reverse integers_reverse2 = new Integers_Reverse();
        integers_reverse2.Int_reverse(nums2);

    }
}
