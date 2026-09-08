package JavaSteams;

import java.util.*;
import java.util.Map.Entry;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * A collection of small, self-contained examples demonstrating common
 * {@link java.util.stream.Stream} operations and collectors in the Java Streams API.
 */
public class JavaStreams {
	List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);
	List<String> names = List.of("spring", "java", "aws");
	
	
	/**
	 * Filters the even numbers from {@link #numbers} and multiplies each by 10.
	 */
	public void evenNumberAndMultiply() {
		List<Integer> result = numbers.stream().filter(n->n%2==0).map(n->n*10).toList();
		System.out.println(result);
		
		
	}
	
	/**
	 * Sorts {@link #names} alphabetically and converts each entry to upper case.
	 */
	public void upperCaseAndSort() {
		List<String> result = names.stream().sorted().map(n->n.toUpperCase()).toList();
		System.out.println(result);
	}
	
	/**
	 * Removes duplicate values from a list of integers and sorts the remaining values
	 * in natural (ascending) order.
	 */
	public void removeDupsAndSort() {
		List<Integer> numbers= List.of(5, 2, 3, 2, 1, 5, 4, 3);
		List<Integer> result = numbers.stream().distinct().sorted(Comparator.naturalOrder()).toList();
		System.out.println(result);
	}
	
	/**
	 * Demonstrates {@link Collectors#partitioningBy(java.util.function.Predicate)}:
	 * first partitions numbers by a "greater than 3" predicate while counting each
	 * partition, then partitions a separate list into even/odd buckets and prints
	 * each partition's contents.
	 */
	public void partitionBy() {
		Map<Boolean, Long> result =
			    Stream.of(1,2,3,4,5,6)
			        .collect(Collectors.partitioningBy(
			            n -> n > 3,
			            Collectors.counting()
			        ));

			System.out.println(result.get(true));
			
			// partition by true or false
			
			List<Integer> numbers =
				    List.of(1, 2, 3, 4, 5, 6, 7, 8);
			
			Map<Boolean,List<Integer>> result1 = numbers.stream().collect(Collectors.partitioningBy(n->n%2==0));
			for(Entry<Boolean, List<Integer>> entity:result1.entrySet()) {
				System.out.println(entity.getKey()+"->"+entity.getValue());
				
			}
	}
	
	/**
	 * Demonstrates {@link Collectors#groupingBy} in three forms: grouping employees by
	 * department while mapping to names, grouping names by their length while counting
	 * occurrences, and grouping employees by department while summarizing their salaries
	 * with {@link Collectors#summarizingInt}.
	 */
	public void groupingBy() {
		record Employee(String name, String department) {}

		List<Employee> employees = List.of(
		    new Employee("John", "IT"),
		    new Employee("Sam", "HR"),
		    new Employee("Mike", "IT"),
		    new Employee("Amy", "HR")
		);
		Map<String,List<String>> results = employees.stream()
				.collect(Collectors.groupingBy(Employee::department,Collectors.mapping(Employee::name,Collectors.toList())));
		System.out.println(results);
		
		System.out.println ("GROUPING BY AND COUNTING\n");
		List<String> names =
			    List.of("Tom", "Bob", "John", "Sam", "Mike", "Alex");
		Map<Integer,Long> result1= names.stream().collect(Collectors.groupingBy(String::length,Collectors.counting()));
		for(Entry<Integer, Long> entity: result1.entrySet()){
			System.out.println(entity.getKey()+"->"+entity.getValue());
		}
		
		System.out.println ("\n GROUPING BY AND SummingInt\n");
		
		record Employee1(
			    String name,
			    String department,
			    int salary
			) {}

			List<Employee1> employees1 = List.of(
			    new Employee1("John", "IT", 100000),
			    new Employee1("Mike", "IT", 120000),
			    new Employee1("Sam", "HR", 80000),
			    new Employee1("Amy", "HR", 90000)
			);
			Map<String, IntSummaryStatistics> empGrouping = employees1.stream()
					.collect(Collectors.groupingBy(Employee1::department,Collectors.summarizingInt(Employee1::salary)));
			System.out.println(empGrouping);
			
			for (Entry<String, IntSummaryStatistics> entry : empGrouping.entrySet()) {
			    String department = entry.getKey();
			    IntSummaryStatistics stats = entry.getValue();
			    if (department.equals("IT")|| department.equals("HR")) {
			    	System.out.println(department+"->"+stats.getSum());
			    	
			    }
			    
			   
			    
			    // Your logic here (e.g., stats.getAverage(), stats.getMax())
			}
		
	}
	
	/**
	 * Collects a stream of employees into a {@code Map} keyed by id with the employee
	 * name as the value, using {@link Collectors#toMap}.
	 */
	public void streamtoMAP() {
		record Employee(int id, String name) {}

		List<Employee> employees = List.of(
		    new Employee(101, "John"),
		    new Employee(102, "Sam"),
		    new Employee(103, "Mike")
		);
		Map<Integer,String> result = employees.stream().collect(Collectors.toMap(Employee::id, Employee::name));
		System.out.println(result);
		
	}
	
	/**
	 * Finds the employee with the highest salary using
	 * {@code Stream.max(Comparator.comparing(...))}.
	 */
	public void findMax() {
		record Employee(String name, int salary) {}

		List<Employee> employees = List.of(
		    new Employee("John", 80000),
		    new Employee("Sam", 95000),
		    new Employee("Mike", 120000),
		    new Employee("Amy", 90000)
		);
		Optional<Employee> result = employees.stream().max(Comparator.comparing(Employee::salary));
		result.ifPresent(emp->System.out.print(emp.name+"-"+emp.salary));
		
	}
	/**
	 * Flattens a list of lists of integers into a single list using
	 * {@link java.util.stream.Stream#flatMap}, shown both with a lambda and a method
	 * reference.
	 */
	public void flatMap() {
		List<List<Integer>> numbers = List.of(
			    List.of(1, 2, 3),
			    List.of(4, 5),
			    List.of(6, 7, 8)
			);
		List<Integer> result = numbers.stream().flatMap(n->n.stream()).toList();
		System.out.print(result);
		
		List<Integer> result1 = numbers.stream()
			    .flatMap(List::stream)
			    .toList();
		
	}
	/**
	 * Uses {@code flatMap} to combine each employee's list of tasks into one flat list
	 * of all company tasks, then separately maps each employee's name to their own
	 * list of tasks.
	 */
	public void flatMapExample1() {
	    // Record where each employee has a List of tasks
	    record Employee(String name, List<String> tasks) {}

	    List<Employee> employees = List.of(
	        new Employee("John", List.of("Fix Bug A", "Write Docs")),
	        new Employee("Sam", List.of("Interview Candidate")),
	        new Employee("Mike", List.of("Fix Bug B", "Code Review"))
	    );

	    // Using flatMap to combine all individual task lists into one stream
	    List<String> allCompanyTasks = employees.stream()
	        .flatMap(emp -> emp.tasks().stream()) // Converts List<String> to Stream<String>
	        .collect(Collectors.toList());

	    System.out.println(allCompanyTasks);
	    // Output: [Fix Bug A, Write Docs, Interview Candidate, Fix Bug B, Code Review]
		Map<String,List<String>> employeesduties = employees.stream().collect(Collectors.toMap(Employee::name, e->e.tasks.stream().toList()));
		System.out.println(employeesduties);
	}
	
	/**
	 * Splits each sentence into words and flattens the resulting arrays into a single
	 * list of words using {@code flatMap}.
	 */
	public void faltMapExample2() {
		List<String> sentences = List.of(
			    "Java Spring",
			    "AWS Docker",
			    "Kafka Microservices"
			);
		List<String> words = sentences.stream().map(s->s.split("\\s+")).flatMap(Arrays::stream).toList();
		System.out.println(words);
		List<String> wordss = sentences.stream()
			    .flatMap(s -> Arrays.stream(s.split("\\s+")))
			    .toList();
	}
	
	/**
	 * Skips the first 3 elements of a list and then limits the result to 4 elements.
	 */
	public void skipandLimit() {
		List<Integer> numbers =
			    List.of(10, 20, 30, 40, 50, 60, 70, 80, 90);
		List<Integer> results = numbers.stream().skip(3).limit(4).toList();
		System.out.println(results);
		
	}
	/**
	 * Filters numbers greater than 10 and divisible by 3 (using chained filters and a
	 * combined predicate), then squares the results.
	 */
	public void filterandMap() {
		List<Integer> numbers =
			    List.of(3, 6, 9, 12, 15, 18, 20, 21);
		List<Integer> result= numbers.stream().filter(n->n>10).filter(n->n%3==0).map(n->n*n).toList();
		System.out.println(result);
		List<Integer> result1= numbers.stream().filter(n -> n > 10 && n % 3 == 0).map(n->n*n).toList();
		
	}
	/**
	 * Sorts numbers in descending order and limits the result to the top 3 values.
	 */
	public void sortAndLimit() {
		List<Integer> numbers =
			    List.of(40, 10, 90, 30, 70, 50, 80);
		List<Integer> result = numbers.stream().sorted(Comparator.reverseOrder()).limit(3).toList();
		System.out.println(result);
	}
	
	/**
	 * Demonstrates {@link java.util.stream.Stream#takeWhile}: takes elements while
	 * they are below 50 (stopping at the first element that fails, even if later
	 * elements would pass), and separately takes even numbers into a primitive
	 * {@code int[]} array.
	 */
	public void takwhile() {
		List<Integer> numbers =
			    List.of(10, 20, 30, 40, 50, 25, 60);
		List<Integer> result = numbers.stream().takeWhile(n-> n<50).toList();
		System.out.println(result);

		List<Integer> result1 = List.of(2, 4, 6, 7, 8, 10);
		int[] array = result1.stream().takeWhile(n->n%2==0).mapToInt(Integer::intValue).toArray();
		System.out.println(Arrays.toString(array));
	}
	
	/**
	 * Demonstrates {@link java.util.stream.Stream#dropWhile}: drops elements from the
	 * start of the stream while they are below 40, keeping everything from the first
	 * element that fails the condition onward.
	 */
	public void dropwhile() {
		List<Integer> numbers =
			    List.of(10, 20, 30, 40, 50, 25, 60);
		List<Integer> result = numbers.stream().dropWhile(n->n<40).toList();
		System.out.println("drop everything until I encounter exactly 40");
		System.out.println(result);
	}
	/**
	 * Maps each word to its length and sums the lengths using
	 * {@link java.util.stream.Stream#mapToInt}.
	 */
	public void mapToIntAndSum() {
		List<String> words =
			    List.of("Java", "Spring", "AWS");
		int result = words.stream().mapToInt(String::length).sum();
		System.out.println(result);
		
	}
	
	/**
	 * Finds the first number greater than 50, both unwrapping the {@link Optional}
	 * directly and using {@code orElse} to supply a default when absent.
	 */
	public void filterAndFind() {
		List<Integer> numbers =
			    List.of(10, 30, 55, 70, 90);
		Optional<Integer> result = numbers.stream().filter(n->n>50).findFirst();
		int resultInt = result.get().intValue();
		System.out.println(resultInt);
	    
		int resultInts = numbers.stream()
			    .filter(n -> n > 50)
			    .findFirst()
			    .orElse(-1);
		
	}
	
	/**
	 * Uses {@link java.util.stream.Stream#peek} to print each element as it flows
	 * through the pipeline, then filters values greater than 2 and multiplies them
	 * by 10.
	 */
	public void peekFilterMap() {
		List<Integer> numbers = List.of(1, 2, 3, 4);
		List<Integer> result = numbers.stream().peek(System.out::println).filter(n->n>2).map(n->n*10).toList();
		System.out.println(result);
	}
	
	/**
	 * Filters names longer than 4 characters, maps them to their lengths, and sorts
	 * the resulting lengths in natural order.
	 */
	public void mapFilterSorted() {
		List<String> names =
			    List.of("Tom", "Spring", "Java", "Docker", "AWS", "Kafka");
		List<Integer> result = names.stream().filter(str->str.length()>4).map(String::length).sorted().toList();
		System.out.println("MAP-FILTER-Sorted");
		System.out.println(result);
		
	}

	/**
	 * Collects names into a map keyed by string length, merging colliding values by
	 * concatenating them with {@link Collectors#toMap} (merge function), and
	 * separately achieves a similar grouped concatenation with
	 * {@link Collectors#groupingBy} combined with {@link Collectors#joining}.
	 */
	public void ToMapAndConcat() {
		List<String> names =
				List.of("Tom", "Bob", "Sam", "Alice");
		Map<Integer,String> result = names.stream().collect(Collectors.toMap(String::length, Function.identity(),(s1, s2)->s1+":"+ s2));
		System.out.println(result);
		Map<Integer,String> result2 = names.stream().filter(Objects::nonNull)
				.collect(Collectors.groupingBy(String::length, Collectors.joining(":")));
		System.out.println(result);
	}

	/**
	 * Demonstrates short-circuiting behavior of {@code findFirst()}: once the filter
	 * condition is met for an element, the stream stops processing further elements.
	 */
	public void findFrist(){
		Optional<Integer> result =
				Stream.of(1, 2,3, 4, 5)
						.filter(n -> {
							System.out.print(n);
							return n > 2;
						})
						.findFirst();

		System.out.println(":" + result.get());
	}

	/**
	 * Finds the elements in an {@code int[]} array that occur exactly once, by
	 * grouping and counting occurrences and then filtering to counts equal to 1.
	 */
	public  void getUnique(){
		int[] nums = {1, 2, 2, 3, 4, 4, 5};
		Map<Integer,Long> counts = Arrays.stream(nums).boxed().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		int[] unique = Arrays.stream(nums).filter(n->counts.get(n) ==1).toArray();
		System.out.println(Arrays.toString(unique));

	}

	/**
	 * Generates a bounded sequence of numbers using
	 * {@link java.util.stream.Stream#iterate(Object, java.util.function.Predicate, java.util.function.UnaryOperator)},
	 * starting at 1, incrementing by 2, while the value stays below 10.
	 */
	public void streamIterator() {
		List<Integer> stream = Stream.iterate(1, n->n<10,n -> n+2).toList();
		System.out.println(stream);
	}

	/**
	 * Counts occurrences of each value in an {@code int[]} array using
	 * {@link Collectors#groupingBy} with {@link Collectors#counting}.
	 */
	public void groupingByAndSortedMap(){
		int[] array = {10,10,1,1,2,3,3,3,4,4,5,6,6,6,7,8,9,9};
		//
		Map<Integer,Long> mapCount = new TreeMap<>();
		mapCount = Arrays.stream(array).boxed().collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
		System.out.println(mapCount);
	}

	/**
	 * Filters out {@code null} and blank/whitespace-only strings from a
	 * {@code String[]}, collecting the remaining values back into an array.
	 */
	public void removeSpaceObjectNullAndNextraBlanks(){
		String[] stringArray = {"java",""," ",null,"C++","goLang"};
		String[] result = Arrays.stream(stringArray).filter(str->str!=null && !str.isBlank()).toArray(String[]::new);
		System.out.println(Arrays.toString(result));
	}

	public void removeDuplicatesUseCollection(){
		// Create a mutable-backed list containing duplicate elements
		List<Integer> numbers = Arrays.asList(5, 2, 8, 2, 3, 5, 9, 3);

		// Collect into a LinkedHashSet:
		// 1. .distinct() filters out duplicate numbers
		// 2. LinkedHashSet preserves the original insertion order of the unique elements
		Set<Integer> linkedHashSet = numbers.stream()
				.distinct()
				.collect(Collectors.toCollection(LinkedHashSet::new));

		// Collect into a TreeSet:
		// 1. .distinct() filters duplicates (though TreeSet inherently does this)
		// 2. TreeSet automatically sorts the unique elements in ascending natural order
		Set<Integer> treeSet = numbers.stream()
				.distinct()
				.collect(Collectors.toCollection(TreeSet::new));

		// Prints: [5, 2, 8, 3, 9] (Maintains original order of appearance)
		System.out.println(linkedHashSet);

		// Prints: [2, 3, 5, 8, 9] (Sorted numerically)
		System.out.println(treeSet);

	}

	/**
	 * Computes the average of a list of numbers using both
	 * {@link Collectors#averagingDouble} and {@code mapToDouble(...).average()},
	 * checks whether all numbers are positive with {@code allMatch}, and partitions
	 * the numbers into even/odd buckets.
	 */
	public void average(){
		List<Integer> numbers = Arrays.asList(5,10,15,20,25);
		Double average= numbers.stream().collect(Collectors.averagingDouble(Integer::intValue));
		Double doubleAverage= numbers.stream().mapToDouble(Integer::intValue).average().orElse(0.0);
		System.out.println(average);
		//
		boolean allMatch = numbers.stream().allMatch(n->n>0);
		System.out.println(allMatch);
		Map<Boolean,List<Integer>> addEven = numbers.stream().collect(Collectors.partitioningBy(n->n%2==0));
		System.out.println(addEven);
	}
	/**
	 * Reverses the word order of a sentence (trimming excess whitespace) using
	 * {@link IntStream#rangeClosed} to walk the split words backwards and rejoin
	 * them with spaces.
	 */
	public void reverseTheSentence(){
		String input = "searching for my laptop      ";
		String[] stringArray = input.trim().split("\\s+");
		int len = stringArray.length-1;
		String newinput= IntStream.rangeClosed(0, len)
				.mapToObj(i-> stringArray[len-i]).collect(Collectors.joining(" "));
		System.out.println(newinput);
	}

    /**
     * Finds the second-largest distinct value in an {@code int[]} array by sorting
     * distinct values in descending order and skipping the first one.
     */
    public  void findSecondMaxInArray(){
		int[] nums = {10, 40, 20, 50, 40, 30, 50};
		//int[] nums = {12, 35, 1, 10, 34, 1};
		int secondMax = Arrays.stream(nums).boxed().distinct()
				.sorted(Comparator.reverseOrder()).skip(1).mapToInt(Integer::intValue).findFirst().orElse(0);
		System.out.println(secondMax);
	}
	
	/**
	 * Groups employees by department (collecting names), finds the highest-paid
	 * employee per department using {@link Collectors#maxBy} combined with
	 * {@link Collectors#collectingAndThen}, and separately sums salaries per
	 * department using both {@link Collectors#summarizingInt} and
	 * {@link Collectors#summingInt}.
	 */
	public void findMaxSalaray(){
		record Employee(String name, String department, int salary) {}

		List<Employee> employees = List.of(
				new Employee("John", "IT", 90000),
				new Employee("Mike", "IT", 85000),
				new Employee("Sara", "HR", 70000),
				new Employee("Emma", "HR", 75000),
				new Employee("David", "Finance", 95000)
		);
		Map<String,List<String>> groupingBy = employees.stream()
				.collect(Collectors.groupingBy(Employee::department,Collectors.mapping(Employee::name, Collectors.toList())));
		//System.out.print(groupingBy);
		Map<String,Employee> highestPaid = employees.stream()
				.collect(Collectors.groupingBy(Employee::department,Collectors.collectingAndThen(
						Collectors.maxBy(Comparator.comparingInt(Employee::salary)), // Compare by salary int
						Optional::get)));
		highestPaid.forEach((dept,emp)->System.out.println(dept + " -> " + emp.name() + ", " + emp.salary())  );
		// intSummaryStatistics
		Map<String, IntSummaryStatistics> summingInt = employees.stream().collect(Collectors.groupingBy(Employee::department,Collectors.summarizingInt(Employee::salary)));
		summingInt.forEach((dept,intsummary)->System.out.println(dept+"->"+intsummary.getSum()));

		Map<String, Integer> summingInts = employees.stream().collect(Collectors.groupingBy(Employee::department,Collectors.summingInt(Employee::salary)));
		summingInts.forEach((dept,saltotal)->System.out.println(dept+"->"+saltotal));
	}

	/**
	 * Finds the values in a list that occur more than once, by grouping and counting
	 * occurrences and then filtering for counts greater than 1.
	 */
	public void occurenceMoreThanOnce(){
		List<Integer> numbers = List.of(10, 20, 30, 20, 40, 10, 50, 30);
		Map<Integer,Long> nums = numbers.stream().collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
		List<Integer> occurengreaterThan1 = nums.entrySet().stream().filter(entry->entry.getValue()>1).map(Map.Entry::getKey).toList();
		System.out.println(occurengreaterThan1);
	}

	/**
	 * Finds the most frequently occurring word in a sentence, by grouping and
	 * counting word occurrences and then taking the entry with the highest count
	 * via {@link Map.Entry#comparingByValue()}.
	 */
	public void maxOccurence(){
		String sentence = "java spring java aws spring java docker aws";
		Map<String,Long> groupingby = Arrays.stream(sentence.split("\\s+")).collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));


		// 2. Find the entry with the highest count value
		Optional<Map.Entry<String, Long>> maxEntry = groupingby.entrySet().stream()
				.max(Map.Entry.comparingByValue());

		// Print the result
		// Output: java -> 3
		maxEntry.ifPresent(entry ->
				System.out.println(entry.getKey() + " -> " + entry.getValue()));
	}

	public static void findDuplicateElement(){
		int[] nums = {5, 3, 8, 2, 3, 7, 5};
		Set<Integer> nonDups = new HashSet<>();
		Set<Integer> dups = Arrays.stream(nums).boxed().filter(n->!nonDups.add(n)).collect(Collectors.toCollection(LinkedHashSet::new));

		System.out.println(dups);
		//find first dups break the loop
		Integer duplicateElement = Arrays.stream(nums).boxed().filter(n->!nonDups.add(n)).findFirst().orElse(-1);
		System.out.println(duplicateElement);

		// using loop
		Set<Integer> seen = new HashSet<>();

		for (int num : nums) {
			if (!seen.add(num)) {
				System.out.println(num);
				break;
			}
		}
	}

	public void findDuplicate(){
		String input = "programming";

		// 1. Fixed: Change to Set<Integer> to match input.chars() ASCII stream
		Set<Integer> hashSet = new HashSet<>();

		Set<String> set = input.chars()
				.filter(c -> !hashSet.add(c)) // 2. Filters out first occurrences
				.mapToObj(c -> String.valueOf((char) c)) // 3. Fixed: mapToObj converts int to String
				.collect(Collectors.toCollection(LinkedHashSet::new)); // 4. Fixed lowercase typo

		// Output: [r, g, m]
		System.out.println(set);
	}

	/**
	 * Runs each of the demonstration methods above in sequence, printing their
	 * output to standard out.
	 */
	public static void main(String[] args) {
		JavaStreams jstreams = new JavaStreams();
		jstreams.evenNumberAndMultiply();
		jstreams.upperCaseAndSort();
		jstreams.partitionBy();
		jstreams.removeDupsAndSort();
		jstreams.groupingBy();
		jstreams.streamtoMAP();
		jstreams.findMax();
		jstreams.flatMap();
		jstreams.flatMapExample1();
		jstreams.skipandLimit();
		jstreams.filterandMap();
		jstreams.sortAndLimit();
		jstreams.takwhile();
		jstreams.dropwhile();
		jstreams.mapToIntAndSum();
        jstreams.filterAndFind();
        jstreams.peekFilterMap();
        jstreams.faltMapExample2();
        jstreams.mapFilterSorted();
		jstreams.mapFilterSorted();
		jstreams.getUnique();
		jstreams.average();
		jstreams.reverseTheSentence();
		jstreams.findSecondMaxInArray();
		
	}

}
