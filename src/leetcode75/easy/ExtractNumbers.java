package leetcode75.easy;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ExtractNumbers {


    public static void main(String[] args) {
        String input = "1,2,\"Hello\",3.45,3 ,5";

        List<Integer> integers = Arrays.stream(input.split(",")) // 1. Split by comma
                .map(String::trim)                               // 2. Clean up spaces
                .filter(s -> s.matches("\\d+"))                 // 3. Keep only digits
                .map(Integer::parseInt)                          // 4. Convert to int
                .collect(Collectors.toList());                   // 5. Save to list

        System.out.println(integers); // Output: [1, 2, 3, 5]
    }

}
