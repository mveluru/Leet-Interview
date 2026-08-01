package leetcode75.jee.datastructures;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class MergeTwoSingleLists {
    public static List<Integer> mergeTwoLists(List<Integer> a, List<Integer> b) {
        List<Integer> res;
       return res= Stream.concat(a.stream(), b.stream()).toList();
    }



    public static void main(String[] args) {
     List<Integer> a = Arrays.asList(1,2,3,4,5);
     List<Integer> b = Arrays.asList(1,2,3,4,5);
     List<Integer> res = mergeTwoLists(a,b);
     System.out.println(res);
    }


}
