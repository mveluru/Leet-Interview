package leetcode75.java21.grind75.week1;

import java.util.List;
import java.util.stream.IntStream;

public class CommonIntegers {
    public static void main(String[] args) {
        List<Integer> list = IntStream.rangeClosed(1, 50).boxed().toList();
        List<Integer> list2 = IntStream.rangeClosed(25, 60).boxed().toList();
        List<Integer> list3 = list.stream().filter(list2::contains).toList();
        list3.forEach(System.out::println);

    }
}
