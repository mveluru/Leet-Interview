package leetcode75.java21.list;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class ListEhancement {

    public static void main(String[] args) {
        int[] arr = IntStream.range(0,100).toArray();
        List<Integer> list = Arrays.stream(arr).boxed().toList().reversed();
       list.forEach(x->System.out.print(x+" "));


    }
}
