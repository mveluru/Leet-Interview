package leetcode75.medium;

import java.util.Comparator;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class CollectionLIstCopy {
    public static void main(String[] args){
        List<Integer> list1 = IntStream.range(1,10).boxed().toList();
        List<Integer> list2 = IntStream.rangeClosed(9,30).boxed().toList();
        List<Integer> list3 = IntStream.rangeClosed(21,30).boxed().toList();
        List<Integer> list4 = Stream.concat(list1.stream(), list2.stream()).toList();
        List<Integer> list5 = Stream.concat(list4.stream(), list3.stream()).distinct().
                sorted(Comparator.reverseOrder()).toList();
        System.out.println(list5);
    }
}
