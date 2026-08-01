package leetcode75.jee.Arrays;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SubArray {

    public static int findArray(int[] source, int[] target) {
        List<Integer> sourceList = Arrays.stream(source).boxed().toList();
        List<Integer> targetList = Arrays.stream(target).boxed().toList();

        return Collections.indexOfSubList(sourceList, targetList);
    }

    public static void main(String[] args) {
        int[] input1 = {1, 2, 3, 4, 5, 6};
        int[] input2 = {2, 3, 4, 5};
        System.out.println(findArray(input1, input2));
    }

}
