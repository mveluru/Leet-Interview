package leetcode75.jee.java8.streams;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.util.Arrays.stream;

public class WordCount {

    public static void wordGroupingCount(String wordCount){
        Map<String,Long> countMap = stream(wordCount.split("\\s")).collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
       /* for(Map.Entry<String,Long> entry: countMap.entrySet()){
            System.out.println(entry.getKey()+" "+entry.getValue());
        }*/

        countMap.forEach((k,v)-> System.out.println("Word: "+k +" <-->: "+v));
    }

    public static void main(String[] arg){

        wordGroupingCount(("I live in Austin Texas USA I live in Austin Texas USA I live in Austin Texas USA "));

    }
}
