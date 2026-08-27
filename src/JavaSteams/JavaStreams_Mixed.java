package JavaSteams;

import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class JavaStreams_Mixed {
	public void findVowels() {
		String vowels = "aeiouAEIOU";
		String input = "SpringBoot";
		List<String> charValues = input.chars().mapToObj(c -> String.valueOf((char) c)).filter(vowels::contains)
				.toList();
		System.out.println(charValues);
	}

	public void characterFrequency() {
		String input = "banana";
		Map<String, Long> result = input.chars().mapToObj(ch -> String.valueOf((char) ch))
				.collect(Collectors.groupingBy(ch -> ch, Collectors.counting()));
		System.out.println(result);
		
		// Better approach
		Map<String, Long> result1 = input.chars().mapToObj(ch -> String.valueOf((char) ch))
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		System.out.println(result1);
	}
	
	public void distinctSorted() {
		String input = "programming";
		List<String> result = input.chars().mapToObj(ch->String.valueOf((char)ch)).distinct().sorted(Comparator.naturalOrder()).toList();
		System.out.println(result);
	}
	public void findSinglechar() {
		String input = "swiss";
		
		
		Map<String, Long> result = input.chars()
			    .mapToObj(ch -> String.valueOf((char) ch))
			    .collect(Collectors.groupingBy(
			        Function.identity(),
			        LinkedHashMap::new,
			        Collectors.counting()
			    ));

			String first = result.entrySet().stream()
			    .filter(e -> e.getValue() == 1)
			    .map(Map.Entry::getKey)
			    .findFirst()
			    .orElse(null);

			System.out.println(first);
	}
	
	public void toUpper() {
		String input = "java";
		List<String> result = input.chars().mapToObj(ch->String.valueOf((char)ch)).map(String::toUpperCase).toList();
		System.out.println(result);
	}
	
	public void extractInteger() {
		List<Object> values =
			    List.of("Java", 10, "Spring", 20, 30, "AWS");
		// Better Approach
		List<Integer> result = values.stream()
			    .filter(Integer.class::isInstance) // Keeps only the Integer objects
			    .map(Integer.class::cast)          // Safely casts Object to Integer
			    .toList();
		
		List<Integer> results = values.stream().map(String::valueOf)
				.filter(s->s.matches("\\d+")).mapToInt(Integer::parseInt).boxed().toList();
	}
	
	public void extractStringAndIntegerSeperately() {
		List<Object> values =
			    List.of("Java", 10, "Spring", 20, "AWS", 30);
		List<String> result = values.stream().filter(String.class::isInstance).map(String.class::cast).toList();
		Map<String, List<Object>> results = values.stream()
			    .collect(Collectors.groupingBy(
			        obj -> obj.getClass().getSimpleName()
			    ));

			System.out.println(results);
		System.out.println(result);
		
	}
	
	public void extractStringAndIntegerSeperatelyUpper() {
		List<Object> values =
			    List.of("java", 10, "spring", 20, "aws", 30);
		List<Object> result = values.stream()
			    .map(obj -> {
			        if (obj instanceof String s) {
			            return s.toUpperCase();
			        }

			        if (obj instanceof Integer n) {
			            return n * 10;
			        }

			        return obj;
			    })
			    .toList();

			System.out.println(result);
	}
	
	public void sumOfIntegers() {
		List<Object> values =
			    List.of("Java", 10, "Spring", 20, "AWS", 30);
		
		int sum = values.stream().filter(Integer.class::isInstance).map(Integer.class::cast).mapToInt(Integer::intValue).sum();
		System.out.println(sum);
		
		
	}
	
	public void mixedFiltering() {
		List<Object> values =
			    List.of("Java", 10, "Spring", 25, "AWS", 40, "Docker", 5);
		List<Object> result = values.stream().filter(obj->{
			if (obj instanceof String s && s.length()>3) {
				return true;
			}
			if (obj instanceof Integer n && n>20) {
				return true;
			}
			return false;
		}).toList();
		System.out.println(result);
	}

	public static void main(String[] args) {
		JavaStreams_Mixed jsm = new JavaStreams_Mixed();
		jsm.findVowels();
		jsm.characterFrequency();
		jsm.distinctSorted();
		jsm.findSinglechar();
		jsm.findSinglechar();
		jsm.toUpper();
		jsm.mixedFiltering();
	}
}
