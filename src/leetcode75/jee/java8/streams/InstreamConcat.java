package leetcode75.jee.java8.streams;

import java.util.Arrays;
import java.util.stream.IntStream;

public class InstreamConcat {

    public static int[] contact(int[] input1 ,int[] input2){
      int[] input3 = IntStream.concat(IntStream.of(input1),IntStream.of(input2)).toArray();
      return input3;
    }

    public static void main(String[] args){
        IntStream stream1 = IntStream.rangeClosed(1,20);
        IntStream stream2 = IntStream.rangeClosed(20,40);
        int[] input1 = stream1.toArray();
        int[] input2 = stream2.toArray();
        System.out.println(Arrays.toString(contact(input1,input2)));

    }
}
