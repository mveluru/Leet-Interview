package leetcode75.java21.grind75.week1;

import java.util.Arrays;
import java.util.List;

public class StreamMapTo {
    public int[] lengthOfEachFruit(List<String> fruits) {
        return fruits.stream().mapToInt(String::length).toArray();
    }

    public void printNumberOfFruits(List<String> fruits) {
        int[] lengthOfEachFruit = lengthOfEachFruit(fruits);
        int sum = Arrays.stream(lengthOfEachFruit).sum();
        System.out.println("sum: " + sum);
        double average = fruits.stream().mapToDouble(String::length).average().getAsDouble();
        System.out.println("average: " + average);
    }


    public static void main(String[] args) {
        List<String> fruits = Arrays.asList("apple", "banana", "orange", "grape", "grape fruit");
        StreamMapTo streamMapTo = new StreamMapTo();
        System.out.println(Arrays.toString(streamMapTo.lengthOfEachFruit(fruits)));
        streamMapTo.printNumberOfFruits(fruits);

    }
}
