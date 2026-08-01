package leetcode75.java21.pratice.streams;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.IntStream;

public class Instreamrange {

    public static void main(String[] args){
        int[] intarray = IntStream.range(1, 10).toArray();
        System.out.println("IntStream.range(1, 10) : " + Arrays.toString(intarray));
        int[] intarray1 = IntStream.range(1, 10).boxed().sorted(Comparator.reverseOrder()).mapToInt(Integer::intValue).toArray();
        System.out.println("IntStream.range(1, 10) reversed sorted: " + Arrays.toString(intarray1));
        int[] intarray2 = IntStream.rangeClosed(1, 20).toArray();
        System.out.println("IntStream.rangeClosed(1, 20) : " + Arrays.toString(intarray2));
        List<Integer> list0 = IntStream.range(1, 10).boxed().sorted(Comparator.reverseOrder()).toList();
        System.out.println("IntStream.range(1, 10) reversed sorted as List: " + list0);

    }
}
