package leetcode75.jee.j21_features;

import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;

public class ListEnhancements {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("Toyota", "Tocoma", "van");
        ListIterator<String> reverseIterator = list.listIterator(list.size());
        while (reverseIterator.hasPrevious()) {
            System.out.print(reverseIterator.previous()+" ");
        }
    }
}
