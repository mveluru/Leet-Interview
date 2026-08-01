package leetcode75.jee.java8.streams;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class StreamPartitions {
    public static void getOddandEvenNumberinSingleStream(List<Integer> nums){
        Map<Boolean,List<Integer>> partitions = nums.stream().collect(Collectors.partitioningBy(value->value%2==0));
        List<Integer> evenNumbers = partitions.get(true);
        List<Integer> oddNumbers = partitions.get(false);
        evenNumbers.forEach(value->System.out.print(value+" "));
        System.out.println();
        oddNumbers.forEach(value->System.out.print(value+" "));

    }

    public static void main(String[] args){
        IntStream stream = IntStream.rangeClosed(1,100);
        getOddandEvenNumberinSingleStream(stream.boxed().toList());

    }

}
