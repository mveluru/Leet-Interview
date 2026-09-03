package leetcode75.medium;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class MissingNumberInSequence {
	public static void MissingNumber(int[] intArray) {
		OptionalInt maxNum = Arrays.stream(intArray).max();
		if (maxNum.isPresent()) {
			int num = maxNum.getAsInt() * ((maxNum.getAsInt() + 1)) / 2;
			for (int i : intArray) {
				num -= i;
			}
			System.out.printf("Missing Number: %3d ", num);
		}
	}

	public static void findMissingNumbersInSequence() {
		//int[] intarray = {2,3,3,3,4,4,5,7,8,9,1};
		int[] intarray = {2,3,3,3,4,4,7,8,9,1};
		// removeDuplication
		Set<Integer> set = Arrays.stream(intarray).boxed().sorted().collect(Collectors.toCollection(LinkedHashSet::new));
		List<Integer> list = IntStream.rangeClosed(1, 9)
				.filter(i -> !set.contains(i)).boxed().toList();
		System.out.println("\n Missing numbers[s]: "+list);
	}


	public static void main(String[] main) {
		int[] intArray = { 1, 2, 3, 4, 5, 6, 7, 9 };
		System.out.println(Arrays.toString(intArray));
		MissingNumber(intArray);
		findMissingNumbersInSequence();

	}

}
