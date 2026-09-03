package leetcode75.medium;

import java.util.Arrays;
import java.util.OptionalInt;

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



	public static void main(String[] main) {
		int[] intArray = { 1, 2, 3, 4, 5, 6, 7, 9 };
		System.out.println(Arrays.toString(intArray));
		MissingNumber(intArray);


	}

}
