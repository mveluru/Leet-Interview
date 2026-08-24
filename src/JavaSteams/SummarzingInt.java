package JavaSteams;

import java.util.HashMap;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class SummarzingInt {
    record Employee(String name, Integer salary) {
    }

    List<Employee> employees = List.of(
            new Employee("A", 100),
            new Employee("B", 200),
            new Employee("C", 300),
            new Employee("D", 300),
            new Employee("E", 200)

    );

    public void streamGroupBySalary() {
        Map<Integer, List<String>> result = new HashMap<>();
        result = employees.stream().collect(Collectors.groupingBy(Employee::salary, Collectors.mapping(Employee::name, Collectors.toList())));
        for (Map.Entry<Integer, List<String>> entry : result.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
        IntSummaryStatistics stats =
                employees.stream()
                        .collect(Collectors.summarizingInt(
                                Employee::salary
                        ));
        System.out.println(
                stats.getCount() + ":" +
                        stats.getSum() + ":" +
                        stats.getMax()
        );

    }

    public static void main(String[] args) {
        SummarzingInt s = new SummarzingInt();
        s.streamGroupBySalary();
    }
}
