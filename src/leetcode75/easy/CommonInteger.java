package leetcode75.easy;

import java.util.*;

public class CommonInteger {
    public static void commonList(List<Integer> l1, List<Integer> l2) {
        Set<Integer> set = new HashSet<>(l2);
        List<Integer> commonList = l1.stream().filter(set::contains).distinct().toList();
        System.out.println(" Common List "+commonList);

    }

    public static void main(String[] args){

        int[] input1 = {2,7,17,19,20,45,56,159,239};
        int[] intput2 = {7,12,15,19,22,34,55,150,159};
         // Common elements
        List<Integer> list1 = Arrays.stream(input1).boxed().toList();
        List<Integer> list2 = Arrays.stream(intput2).boxed().toList();
        List<Integer> list3 = list1.stream().filter(list2::contains).toList();
        System.out.println("Common elements: "+list3);

        // Merge & distinct and sort
        List<Integer> list4 = new ArrayList<>();
        list4.addAll(list1);
        list4.addAll(list2);
        System.out.println("Merge : " +list4);
        List<Integer> list5 = list4.stream().distinct().sorted(Comparator.reverseOrder()).toList();
        System.out.println("Merge,distinct and sort: " + list5);

        //Sum of Arrays
        Integer sum =  list4.stream().distinct().reduce(Integer::sum).orElse(0).intValue();
        System.out.println("Sum :"+sum);


        List<Integer> oddIntegers = list4.stream().filter(e->(e%2)==1).toList();
        System.out.println("Odd Number : "+oddIntegers);

        // Duplicate Integer set
        Set<Integer> dupslist4set = new TreeSet<>();
        List<Integer> nodupsList = list4.stream().sorted().filter(e->!dupslist4set.add(e)).toList();
        System.out.println("dupslist4set : "+dupslist4set);

    }
}
