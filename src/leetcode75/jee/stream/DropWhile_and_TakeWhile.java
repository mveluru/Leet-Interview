package leetcode75.jee.stream;

import java.util.stream.IntStream;

public class DropWhile_and_TakeWhile {
    public static void main(String[] args) {
        IntStream stream = IntStream.rangeClosed(1, 50);
        stream.takeWhile(integer->integer!=49).forEach(System.out::print); // it prints upto 10 and doesn't move forward;
        System.out.println("\n======================================");
        IntStream streams = IntStream.rangeClosed(1, 20);
        streams.dropWhile(integer->integer!=10).forEach(System.out::print); // DropWhile starts from condition




    }
}
