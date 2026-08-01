package leetcode75.jee.java8.streams;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Instreams {
    public static void main(String[] args){
        int[] m1 = new int[]{1, 2, 3, 0, 0, 0};
        int[] m2 = new int[]{2, 5, 6};
        int[] m3 = IntStream.concat(IntStream.of(m1),IntStream.of(m2)).toArray();
        int[] m4 = IntStream.concat(IntStream.of(m1),IntStream.of(m2)).filter(e->e!=0).toArray();
        System.out.println(Arrays.toString(m3));
        System.out.println(Arrays.toString(m4));
    }
}
