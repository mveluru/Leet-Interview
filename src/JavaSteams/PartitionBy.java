package JavaSteams;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PartitionBy {

    public static void main(String[] args) {

        Map<Boolean, List<Integer>> result = Stream.of(1,2,3,4,5,6,7,8,9,10).collect(Collectors.partitioningBy(x -> x % 2 == 0));
        System.out.println(result.keySet());
        for (Map.Entry<Boolean, List<Integer>> entry : result.entrySet()) {
            System.out.println(entry.getKey() +" "+ entry.getValue());
        }
    }
}
