package leetcode75.java21.features;

import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;

public class Listiterator {
    public static void main(String[] args){
        List<String> list = Arrays.asList("Toyota", "Tocoma", "General Motors","Ford");
        ListIterator<String> reverse = list.listIterator(list.size());
        while(reverse.hasPrevious()){
            System.out.println(reverse.previous());
        }

    }
}
