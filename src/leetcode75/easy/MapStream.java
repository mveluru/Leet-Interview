package leetcode75.easy;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class MapStream {

    public static void main(String[] args) {

        String input = "swiss";
        Map<Character, Long> result = input.chars().mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()));

        for (Map.Entry<Character, Long> entry : result.entrySet()) {
            if (entry.getValue() == 1) {
                System.out.println(entry.getKey());
            }

        }
        result.forEach((character,count)->{
            System.out.println(character+" "+count);
        });;

        result.entrySet().stream().forEach(entry->System.out.println(entry.getKey()+" "+entry.getKey()));

    }
}
