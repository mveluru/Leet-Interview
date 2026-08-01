package leetcode75.jee.java8.streams;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class StreamExamples {
    public static void main(String[] args) {
        IntStream intStream1 = IntStream.rangeClosed(1, 50); //includes both starting and ending
        IntStream intStream2 = IntStream.range(51, 100); //includes starting end exclusive

        System.out.println("Collect InStream as set");
        /*--Collect Instream as set --*/
        Set<Integer> set1 = intStream1.boxed().collect(Collectors.toSet());
        Set<Integer> set2 = intStream2.boxed().collect(Collectors.toSet());

        System.out.println(set1);
        System.out.println(set2);

        System.out.println("Natural Order");
        int[] numss =new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10,11};
        int[] numarray = Arrays.stream(numss).sorted().toArray();
        System.out.println(Arrays.toString(numarray));

        List<Integer> list = Arrays.stream(numss).boxed().sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());
        System.out.println("Print Reverse order");
        System.out.println(list);

       int a = Arrays.stream(numss).boxed().sorted().skip((numss.length-1)).findFirst().get();
        System.out.println(a);



        int[] dupsarray = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 8,9};

        Set<Integer> finalDupsets = new HashSet<>();
        System.out.println(Arrays.stream(dupsarray).boxed().filter(e->!finalDupsets.add(e)).collect(Collectors.toSet()));


        int[] numbers = {1, 1, 1, 2, 3};
        Arrays.parallelPrefix(numbers,Integer::sum);
        System.out.println(Arrays.toString(numbers));


        //*****Adding two Arrays on Position based******//
        int[] l1 = {2,4,3};
        int[] l2 ={5,6,4};

        List<Integer> ll3 = new LinkedList<>();

        IntStream range = IntStream.range(0, Math.min(l1.length, l1.length));
        List<Integer> ranges = range.map(i -> l1[i] + l2[i]).boxed().sorted(Comparator.reverseOrder()).toList();
        System.out.println(ranges);


        int[] input3 = {2,7,17,19,20,45,56,159,239};
        int[] intput4 = {7,12,15,19,22,34,55,150,159};

        // Common elements
        List<Integer> list1 = Arrays.stream(input3).boxed().toList();
        List<Integer> list2 = Arrays.stream(intput4).boxed().toList();
        List<Integer> list3 = list1.stream().filter(list2::contains).toList();
        System.out.println("Common elements: "+list3);

        // Merge & distinct and sort
        List<Integer> list4 = new ArrayList<>();
        list4.addAll(list1);
        list4.addAll(list2);
        System.out.println("Merge : " +list4);
        List<Integer> list5 = list4.stream().distinct().sorted(Comparator.reverseOrder()).toList();
        System.out.println("Merge,distinct and sort: " + list5);




        List<Integer> oddIntegers = list4.stream().filter(e->(e%2)==1).toList();
        System.out.println("Odd Number : "+oddIntegers);

        // Duplicate Integer set
        Set<Integer> dupslist4set = new TreeSet<>();
        List<Integer> nodupsList = list4.stream().sorted().filter(e->!dupslist4set.add(e)).toList();
        System.out.println("dupslist4set : "+dupslist4set);

       //Missing Number
        int[] missingNumbers = new int[]{1,3,5,11,10,14,13,12,7,6};

        List<Integer> slist = Arrays.stream(missingNumbers).boxed().sorted().toList();
        System.out.println(slist);
        System.out.println(slist.getFirst()+" : "+slist.getLast());
        for(int i= slist.getFirst();i<=slist.getLast();i++){
            if(!slist.contains(i)){
                System.out.print(i+" ");
            }
        }

        // min number
        int[] findMin = new int[]{2, 22, 10, 4, 5, 10, 11, 12};
        int minNumber = Arrays.stream(findMin).min().getAsInt();
        int maxNumber = Arrays.stream(findMin).max().getAsInt();
        System.out.println("\nMinNumber:"+ minNumber);
        System.out.println("\nMaxNumber:"+ maxNumber);


    }
}
