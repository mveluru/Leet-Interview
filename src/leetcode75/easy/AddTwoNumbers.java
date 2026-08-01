package leetcode75.easy;

import java.util.*;

public class AddTwoNumbers {

    public static void main(String[] args) {
        int[] l1 = {2, 4, 3};
        int[] l2 = {5, 6, 4};

        StringBuilder sb = new StringBuilder();
        Arrays.stream(l1).forEach(e->sb.append(e));
        int a = Integer.valueOf(sb.toString());
        sb.setLength(0);
        Arrays.stream(l2).forEach(e->sb.append(e));
        int b = Integer.valueOf(sb.toString());
        sb.setLength(0);
        int c = a + b;
        LinkedList<Integer> ll = new LinkedList<>();
        int sum = 0;
        while (c > 0) {
            int reminder = c % 10;
            ll.add(reminder);
            sum = (sum * 10) + reminder;
            c = c / 10;
        }
        System.out.println(ll);

    }
}
