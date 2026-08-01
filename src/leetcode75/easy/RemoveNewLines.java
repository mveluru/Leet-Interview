package leetcode75.easy;

import java.util.stream.Collectors;

public class RemoveNewLines {
    public static void main(String[] args) {
        String names =
                """
                Murali 
                dhar 
                Reddy
                """;
       String contact =  names.lines().collect(Collectors.joining(","));
        System.out.println(contact);

    }
}
