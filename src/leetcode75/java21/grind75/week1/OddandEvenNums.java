package leetcode75.java21.grind75.week1;

import java.util.Arrays;

public class OddandEvenNums {

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int[] even = Arrays.stream(arr).filter(x -> x % 2 == 0).toArray();
        System.out.println(Arrays.toString(even));
        int[] odd = Arrays.stream(arr).filter(x -> x % 2 == 1).toArray();
        System.out.println(Arrays.toString(odd));
    }
}
