package leetcode75.jee.java8.streams;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class StreamSums {

    public static void streamsumdifferentapproches(List<Integer> nums){

        //stream.reduce for each element
        int sum0 = nums.stream().reduce((value1,value2)-> value1+value2).get().intValue();
        System.out.println("sum: "+sum0);

        // stream.reduce Integer::sum
        int sum1 = nums.stream().reduce(Integer::sum).get().intValue();
        System.out.println("sum: "+sum1);

        //stream.collect(collectors.summingInt
        int sum2 = nums.stream().collect(Collectors.summingInt(Integer::intValue)).intValue();
        System.out.println("sum: " +sum2);

        //stream.mapToInt().sum
        int sum3 = nums.stream().mapToInt(value->value).sum();
        System.out.println("sum: " +sum3);

    }

    public static void main(String[] args){
        IntStream instream  = IntStream.rangeClosed(1,100);
        streamsumdifferentapproches(instream.boxed().toList());
    }
}
