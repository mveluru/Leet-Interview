package leetcode75.easy;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


public class ReverseStringWordsToChar {
	
	public static char[] reverseStringwordsInTochar(char[] chars) {
		String str = new String(chars);
		
	String[] result=	Arrays.stream( str.split("\\s+")).sorted(Comparator.reverseOrder()).toArray(String[]::new);
	  return String.join(" ", result).toCharArray();

	}
	public static char[] reverseStringwordsInTochars(char[] chars) {
		String charString = new String (chars);
		String[] stringArray = charString.split("\\s+");
		int len = stringArray.length-1;
		String newString = IntStream.rangeClosed(0, len).mapToObj(i->stringArray[len-i])
				.collect(Collectors.joining(" "));
		return newString.toCharArray();

	}
	
	public static void main(String[] args) {
		 char[] s = {'J', 'o', 'h', 'n', 'J', 'r', ' ', 'g', 'r', 'e', 'a', 't' };
	        char[] chararray = reverseStringwordsInTochar(s);
	        System.out.println(Arrays.toString(chararray));
		char[] chararrays = reverseStringwordsInTochars(s);
		System.out.println(Arrays.toString(chararrays));
	}

}
