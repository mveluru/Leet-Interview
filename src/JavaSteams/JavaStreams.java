package JavaSteams;

import java.util.Arrays;
import java.util.Comparator;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class JavaStreams {
	List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);
	List<String> names = List.of("spring", "java", "aws");
	
	
	public void evenNumberAndMultiply() {
		List<Integer> result = numbers.stream().filter(n->n%2==0).map(n->n*10).toList();
		System.out.println(result);
		
		
	}
	
	public void upperCaseAndSort() {
		List<String> result = names.stream().sorted().map(n->n.toUpperCase()).toList();
		System.out.println(result);
	}
	
	public void removeDupsAndSort() {
		List<Integer> numbers= List.of(5, 2, 3, 2, 1, 5, 4, 3);
		List<Integer> result = numbers.stream().distinct().sorted(Comparator.naturalOrder()).toList();
		System.out.println(result);
	}
	
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
	
	public void skipandLimit() {
		List<Integer> numbers =
			    List.of(10, 20, 30, 40, 50, 60, 70, 80, 90);
		List<Integer> results = numbers.stream().skip(3).limit(4).toList();
		System.out.println(results);
		
	}
	public void filterandMap() {
		List<Integer> numbers =
			    List.of(3, 6, 9, 12, 15, 18, 20, 21);
		List<Integer> result= numbers.stream().filter(n->n>10).filter(n->n%3==0).map(n->n*n).toList();
		System.out.println(result);
		List<Integer> result1= numbers.stream().filter(n -> n > 10 && n % 3 == 0).map(n->n*n).toList();
		
	}
	public void sortAndLimit() {
		List<Integer> numbers =
			    List.of(40, 10, 90, 30, 70, 50, 80);
		List<Integer> result = numbers.stream().sorted(Comparator.reverseOrder()).limit(3).toList();
		System.out.println(result);
	}
	
	public void takwhile() {
		List<Integer> numbers =
			    List.of(10, 20, 30, 40, 50, 25, 60);
		List<Integer> result = numbers.stream().takeWhile(n-> n<50).toList();
		System.out.println(result);
	}
	
	public void dropwhile() {
		List<Integer> numbers =
			    List.of(10, 20, 30, 40, 50, 25, 60);
		List<Integer> result = numbers.stream().dropWhile(n->n<40).toList();
		System.out.println("drop everything until I encounter exactly 40");
		System.out.println(result);
	}
	public void mapToIntAndSum() {
		List<String> words =
			    List.of("Java", "Spring", "AWS");
		int result = words.stream().mapToInt(String::length).sum();
		System.out.println(result);
		
	}
	
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
	
	public void peekFilterMap() {
		List<Integer> numbers = List.of(1, 2, 3, 4);
		List<Integer> result = numbers.stream().peek(System.out::println).filter(n->n>2).map(n->n*10).toList();
		System.out.println(result);
	}
	
	public void mapFilterSorted() {
		List<String> names =
			    List.of("Tom", "Spring", "Java", "Docker", "AWS", "Kafka");
		List<Integer> result = names.stream().filter(str->str.length()>4).map(String::length).sorted().toList();
		System.out.println("MAP-FILTER-Sorted");
		System.out.println(result);
		
	}

	public void ToMapAndConcat() {
		List<String> names =
				List.of("Tom", "Bob", "Sam", "Alice");
		Map<Integer,String> result = names.stream().collect(Collectors.toMap(String::length, Function.identity(),(s1, s2)->s1+":"+ s2));
	}

	// once it conditions met and find first it stops executing.
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

	public  void getUnique(){
		int[] nums = {1, 2, 2, 3, 4, 4, 5};
		Map<Integer,Long> counts = Arrays.stream(nums).boxed().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		int[] unique = Arrays.stream(nums).filter(n->counts.get(n) ==1).toArray();
		System.out.println(Arrays.toString(unique));

	}
	
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
		
	}

}
