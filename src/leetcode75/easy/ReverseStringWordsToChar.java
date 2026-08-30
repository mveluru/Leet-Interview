package leetcode75.easy;

import java.util.Arrays;
import java.util.Comparator;


public class ReverseStringWordsToChar {
	
	public static char[] reverseStringwordsInTochar(char[] chars) {
		String str = new String(chars);
		
	String[] result=	Arrays.stream( str.split("\\s+")).sorted(Comparator.reverseOrder()).toArray(String[]::new);
	  return String.join(" ", result).toCharArray();

		
	}
	
	
	public static void main(String[] args) {
		 char[] s = {'J', 'o', 'h', 'n', 'J', 'r', ' ', 'g', 'r', 'e', 'a', 't' };
	        char[] chararray = reverseStringwordsInTochar(s);
	        System.out.println(Arrays.toString(chararray));
	}

}
