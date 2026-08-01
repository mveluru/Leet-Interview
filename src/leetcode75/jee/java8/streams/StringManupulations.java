package leetcode75.jee.java8.streams;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StringManupulations {
    public static void main(String[] args) {
        String join = String.join("-","Murali","Dhar","Reddy","Veluru");
        System.out.println(join);

        // count similar worlds
        String value = "Hello Hello Guru Guru Murali Murali Hello Hello Guru Guru Murali Murali " +
                "Hello Hello Guru Guru Murali Murali Hello Hello Guru Guru Murali Murali";
        String[] countSimilar = value.split("\\s");
        Map<String,Long> countMap = Arrays.stream(countSimilar).collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
        countMap.forEach((k,v)-> System.out.println(k+": "+v));

        //StringTokenizer
        StringTokenizer stoken = new StringTokenizer(value);
        System.out.println(stoken.countTokens());
        while (stoken.hasMoreTokens()){
            System.out.print(stoken.nextToken()+" ");
        }
      List<String> stringsort = Arrays.stream(countSimilar).sorted(Comparator.reverseOrder()).toList();
        System.out.print("\n" +stringsort+" ");

        //length of last-word
        Arrays.stream(countSimilar).skip(countSimilar.length-1).forEach(s1 -> System.out.println("\n length of last word: "+s1.length()));
    }
}
