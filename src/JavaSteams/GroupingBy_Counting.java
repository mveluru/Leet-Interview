package JavaSteams;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class GroupingBy_Counting {
   List<String> names= List.of("Tom", "Bob", "Alice", "Sam", "John");

   public void groupByNameLengthAndCount(){
       Map<Integer, Long> result = names.stream().collect(Collectors.groupingBy(String::length, Collectors.counting()));
       for(Map.Entry<Integer, Long> entry : result.entrySet()){
           System.out.println("Names Length "+entry.getKey()+": Number of Values "+entry.getValue());
       }
   }
   public static void main(String[] args) {
       GroupingBy_Counting g = new GroupingBy_Counting();
       g.groupByNameLengthAndCount();
   }
}
