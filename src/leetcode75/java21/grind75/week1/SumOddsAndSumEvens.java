package leetcode75.java21.grind75.week1;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class SumOddsAndSumEvens{
    public static void main(String[] args) {
        int[] nums = IntStream.rangeClosed(1, 10).toArray();
       int evenSum = 0;
       int oddSum = 0;
        System.out.println(Arrays.stream(nums).filter(i->i%2==0).sum());
        System.out.println(Arrays.stream(nums).filter(i->i%2!=0).sum());

        Map<Boolean, Integer> sumMap = IntStream.rangeClosed(1, 10)
                .boxed()
                .collect(Collectors.partitioningBy(
                        n -> n % 2 == 0,
                        Collectors.summingInt(Integer::intValue)
                ));

        int evenSums = sumMap.get(true);
        int oddSums= sumMap.get(false);

        System.out.println("Sum of Even Numbers: " + evenSums);
        System.out.println("Sum of Odd Numbers: " + oddSums);


    }

}
