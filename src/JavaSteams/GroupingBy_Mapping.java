package JavaSteams;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GroupingBy_Mapping {
    record Employee(String department, String name) {
    }

    List<Employee> employees = List.of(
            new Employee("IT", "John"),
            new Employee("HR", "Sam"),
            new Employee("IT", "Mike"),
            new Employee("IT", "Hudson")
    );

    public void streamGroupByDepartment() {
        Map<String, List<String>> result = new HashMap<>();
        result = employees.stream().collect(Collectors.groupingBy(Employee::department, Collectors.mapping(Employee::name, Collectors.toList())));
        for (Map.Entry<String, List<String>> entry : result.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }

    public static void main(String[] args) {
        GroupingBy_Mapping s = new GroupingBy_Mapping();
        s.streamGroupByDepartment();
    }
}
