package leetcode75.jee.Arrays;

import java.util.Arrays;

public class AllElementWithRange {

    public static boolean allMatch(int[] input){
        boolean allMatchWithinRange = Arrays.stream(input).allMatch(value -> value>=1 && value<=100);
        return allMatchWithinRange;
    }

    public static void main(String[] args){
        int[] input1 = {10,20,11,13,14,15,16,17};
        System.out.println(allMatch(input1));
        int[] input2 = {10,20,11,13,14,151,161,171};
        System.out.println(allMatch(input2));
    }
}
