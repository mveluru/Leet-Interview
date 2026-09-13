package leetcode75.medium;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ReverseSentence {
    public static void main(String[] args) {
        String input = "searching for my laptop      ";
        String[] inputArray = input.split("\\s+");
        int len = inputArray.length - 1;
        String newinput = IntStream.rangeClosed(0, len).map(i -> len - i).mapToObj(i -> inputArray[i])
                .collect(Collectors.joining(" "));
        System.out.println(newinput);

        //
        String newStr = IntStream.iterate(len, i -> i - 1).limit(inputArray.length).mapToObj(i -> inputArray[i])
                .collect(Collectors.joining(" "));
        System.out.println(newinput);
    }
}
