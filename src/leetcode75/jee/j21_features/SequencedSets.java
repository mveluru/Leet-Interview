package leetcode75.jee.j21_features;

import java.util.LinkedHashSet;
import java.util.SequencedSet;

public class SequencedSets {
    public static void main(String[] args){
        SequencedSet<String> sequencedSet = new LinkedHashSet<>();

        // Add some elements to the sequenced set.
        sequencedSet.add("Three");
        sequencedSet.add("One");
        sequencedSet.add("Two");
        sequencedSet.add("Five");
        sequencedSet.add("Four");
        sequencedSet.add("Six");

        

        // Print the elements of the sequenced set in the order they were added.
       sequencedSet.stream().forEach(System.out::println);

        // Get the first and last elements of the sequenced set.
        String firstElement = sequencedSet.getFirst();
        String lastElement = sequencedSet.getLast();

        System.out.println("First element: " + firstElement);
        System.out.println("Last element: " + lastElement);
        System.out.println("reversed elements: " + sequencedSet.reversed());
    }

    }

