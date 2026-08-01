package leetcode75.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class GroupAnagaram {
    public static void main(String[] args) {
        String[] strsa = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<String> string = new ArrayList<>();
        for (String s : strsa) {
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            string.add(String.valueOf(chars));
        }
        Map<String, Long> mapCount = string.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        for (Map.Entry<String, Long> entry : mapCount.entrySet()) {
            if (entry.getValue() == 1) {
                System.out.println("Not a Anagaram " + entry.getKey() + " :" + entry.getValue());
            }
        }

        List<String> filteredList = mapCount.entrySet().stream().filter(entry ->entry.getValue()==1).map(Map.Entry::getKey).collect(Collectors.toList());
        System.out.println(filteredList);
    }
}
