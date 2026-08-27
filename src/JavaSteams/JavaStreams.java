package JavaSteams;

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
        List<Integer> result = numbers.stream().filter(n -> n % 2 == 0).map(n -> n * 10).toList();
        System.out.println(result);


    }

    public void upperCaseAndSort() {
        List<String> result = names.stream().sorted().map(n -> n.toUpperCase()).toList();
        System.out.println(result);
    }

    public void removeDupsAndSort() {
        List<Integer> numbers = List.of(5, 2, 3, 2, 1, 5, 4, 3);
        List<Integer> result = numbers.stream().distinct().sorted(Comparator.naturalOrder()).toList();
        System.out.println(result);
    }

    public void partitionBy() {
        Map<Boolean, Long> result =
                Stream.of(1, 2, 3, 4, 5, 6)
                        .collect(Collectors.partitioningBy(
                                n -> n > 3,
                                Collectors.counting()
                        ));

        System.out.println(result.get(true));

        // partition by true or false

        List<Integer> numbers =
                List.of(1, 2, 3, 4, 5, 6, 7, 8);

        Map<Boolean, List<Integer>> result1 = numbers.stream().collect(Collectors.partitioningBy(n -> n % 2 == 0));
        for (Entry<Boolean, List<Integer>> entity : result1.entrySet()) {
            System.out.println(entity.getKey() + "->" + entity.getValue());

        }
    }

    public void groupingBy() {
        record Employee(String name, String department) {
        }

        List<Employee> employees = List.of(
                new Employee("John", "IT"),
                new Employee("Sam", "HR"),
                new Employee("Mike", "IT"),
                new Employee("Amy", "HR")
        );
        Map<String, List<String>> results = employees.stream()
                .collect(Collectors.groupingBy(Employee::department, Collectors.mapping(Employee::name, Collectors.toList())));
        System.out.println(results);

        System.out.println("GROUPING BY AND COUNTING\n");
        List<String> names =
                List.of("Tom", "Bob", "John", "Sam", "Mike", "Alex");
        Map<Integer, Long> result1 = names.stream().collect(Collectors.groupingBy(String::length, Collectors.counting()));
        for (Entry<Integer, Long> entity : result1.entrySet()) {
            System.out.println(entity.getKey() + "->" + entity.getValue());
        }

        System.out.println("\n GROUPING BY AND SummingInt\n");

        record Employee1(
                String name,
                String department,
                int salary
        ) {
        }

        List<Employee1> employees1 = List.of(
                new Employee1("John", "IT", 100000),
                new Employee1("Mike", "IT", 120000),
                new Employee1("Sam", "HR", 80000),
                new Employee1("Amy", "HR", 90000)
        );
        Map<String, IntSummaryStatistics> empGrouping = employees1.stream()
                .collect(Collectors.groupingBy(Employee1::department, Collectors.summarizingInt(Employee1::salary)));
        System.out.println(empGrouping);

        for (Entry<String, IntSummaryStatistics> entry : empGrouping.entrySet()) {
            String department = entry.getKey();
            IntSummaryStatistics stats = entry.getValue();
            if (department == "IT" || department == "HR") {
                System.out.println(department + "->" + stats.getSum());

            }

            // Your logic here (e.g., stats.getAverage(), stats.getMax())
        }

    }

    public void streamtoMAP() {
        record Employee(int id, String name) {
        }

        List<Employee> employees = List.of(
                new Employee(101, "John"),
                new Employee(102, "Sam"),
                new Employee(103, "Mike")
        );
        Map<Integer, String> result = employees.stream().collect(Collectors.toMap(Employee::id, Employee::name));
        System.out.println(result);

    }

    public void findMax() {
        record Employee(String name, int salary) {
        }

        List<Employee> employees = List.of(
                new Employee("John", 80000),
                new Employee("Sam", 95000),
                new Employee("Mike", 120000),
                new Employee("Amy", 90000)
        );
        Optional<Employee> result = employees.stream().max(Comparator.comparing(Employee::salary));
        result.ifPresent(emp -> System.out.print(emp.name + "-" + emp.salary));

    }

    public void flatMap() {
        List<List<Integer>> numbers = List.of(
                List.of(1, 2, 3),
                List.of(4, 5),
                List.of(6, 7, 8)
        );
        List<Integer> result = numbers.stream().flatMap(n -> n.stream()).toList();
        System.out.print(result);

        List<Integer> result1 = numbers.stream()
                .flatMap(List::stream)
                .toList();

    }

    public void flatMapExample() {
        // Record where each employee has a List of tasks
        record Employee(String name, List<String> tasks) {
        }

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
        jstreams.flatMapExample();

    }

}
