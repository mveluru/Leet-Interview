package leetcode75.java21.pratice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class MergesortIntArrays {
    public void merge(int[] a, int[] b) {

        List<Integer> list = new ArrayList<>();
       List<Integer> lista = Arrays.stream(a).boxed().toList();
       List<Integer> listb = Arrays.stream(b).boxed().toList();
       list.addAll(lista);
       list.addAll(listb);
        System.out.println(list);

    }
   public static void main(String[] args) {
        int[] a = IntStream.range(0,26).toArray();
        int[] b = IntStream.range(26,51).toArray();

        MergesortIntArrays mergeIntArrays = new MergesortIntArrays( );
        mergeIntArrays.merge(a,b);


    }
}
