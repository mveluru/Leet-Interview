package leetcode75.easy;

import java.util.LinkedHashSet;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class FizzBuzz {
	
	public static void fizzBuzz(int n) {
		Set<String> fizzBuzzSet = IntStream.rangeClosed(1, n)
				.mapToObj(i-> { if(i%3==0&& i%5==0)return "FizzBuzz";
				if(i%3==0)return "Fizz";
				if(i%5==0)return "Buzz";
				return String.valueOf(i);
			
		}).collect(Collectors.toCollection(LinkedHashSet::new));
		System.out.println(fizzBuzzSet);
	}
	
	public static void main(String[] args) {
		fizzBuzz(20);
		
	}
		

}
