package leetcode75.easy;


import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RemoveDuplicatesReplaceWithUnderScore {
	public static void removedupsReplace_(String str) {
		String strchar = str.chars().distinct().mapToObj(c -> String.valueOf((char)c)).collect(Collectors.joining());
		char[] charsvalue = new char[str.length()];
		
		for (int i = 0; i < charsvalue.length; i++) {
			if (i < strchar.length()) {
                // If we are within the unique characters length, copy the character
                charsvalue[i] = strchar.charAt(i);
            } else {
                // Anything beyond the unique string gets filled with an underscore
                charsvalue[i] = '_';
            }
		}
		IntStream.range(0, charsvalue.length).mapToObj(i -> charsvalue[i]) // Pull the character at that position
				.forEach(System.out::print);
	}

	public static void main(String[] args) {
		removedupsReplace_("Murrali");
	}

}
