package leetcode75.jee.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StreamNullTest {

    public static void main(String[] args) {
       // List<String> list = Arrays.asList("geeks", "gfg", "g", "e", "e", "k", "s");
        List<String> list =new ArrayList<>();
        List<String> upperCaseList = list.stream()
                .map(String::toUpperCase)
                .collect(Collectors.toList());
        System.out.println(upperCaseList);

    }
}
