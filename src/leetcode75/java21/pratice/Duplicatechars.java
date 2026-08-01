package leetcode75.java21.pratice;

import java.util.HashSet;
import java.util.Set;

public class Duplicatechars {
    public static void main(String args[]){
        String p ="Programming";
       Set<Character> set = new HashSet<>();
       p.chars().mapToObj(c->(char)c).filter(c->!set.add(c)).forEach(System.out::println);

    }
}
