package leetcode75.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class InSteams {

    public static void main(String[] args) {
        List<String> names = Arrays.asList(
                "java",
                "spring",
                "boot",
                "Application",
                "microservices"

        );
        List<String> languages = Arrays.asList(
                "python", "golang", "c++", "dotNet"
        );
        System.out.println("Filters\n");
        // names.stream().filter(s -> s.startsWith("java")).forEach(System.out::println);
        names.stream().filter(s -> s.length() > 5).forEach(System.out::println);

        var Mapvalue = names.stream().collect(Collectors.toMap(name -> name, String::length));
        System.out.println(Mapvalue);

       // names.stream().map(String::toUpperCase).forEach(System.out::println);

        List<List<String>> bookApps = new ArrayList<>();
        bookApps.add(names);
        bookApps.add(languages);
        bookApps.stream().flatMap(List::stream).forEach(s -> System.out.print(s + " "));
        System.out.println();

        // flatMap + uppercase + sort using String compare
        List<String> result = Stream.of(names, languages)
                .flatMap(List::stream)
                .map(String::toUpperCase)
                .sorted(String::compareTo)
                .collect(Collectors.toList());

        System.out.println(result);

        // 9. takeWhile() (Java 9+)
        System.out.println("\ntakeWhile():");

        //List<Integer> nums = Arrays.asList(1,2,3,4,1,2);
        List<Integer> nums = Arrays.asList(1,2,3,1,2,4,7,8);

        nums.stream()
                .takeWhile(n -> n < 4)
                .forEach(System.out::println);

        // 10. dropWhile() (Java 9+)
        System.out.println("\ndropWhile():");

        nums.stream()
                .dropWhile(n -> n < 4)
                .forEach(System.out::println);

    }

    /*
    // 2. map()
        System.out.println("\nmap():");
        names.stream()
                .map(String::toUpperCase)
                .forEach(System.out::println);

        // 3. flatMap()
        System.out.println("\nflatMap():");

        List<List<Integer>> numbers = Arrays.asList(
                Arrays.asList(1, 2),
                Arrays.asList(3, 4)
        );

        numbers.stream()
                .flatMap(Collection::stream)
                .forEach(System.out::println);

        // 4. distinct()
        System.out.println("\ndistinct():");
        names.stream()
                .distinct()
                .forEach(System.out::println);

        // 5. sorted()
        System.out.println("\nsorted():");
        names.stream()
                .sorted()
                .forEach(System.out::println);

        // 6. peek()
        System.out.println("\npeek():");
        names.stream()
                .peek(s -> System.out.println("Processing: " + s))
                .count();

        // 7. limit()
        System.out.println("\nlimit():");
        names.stream()
                .limit(3)
                .forEach(System.out::println);

        // 8. skip()
        System.out.println("\nskip():");
        names.stream()
                .skip(2)
                .forEach(System.out::println);

        // 9. takeWhile() (Java 9+)
        System.out.println("\ntakeWhile():");

        List<Integer> nums = Arrays.asList(1,2,3,4,1,2);

        nums.stream()
                .takeWhile(n -> n < 4)
                .forEach(System.out::println);

        // 10. dropWhile() (Java 9+)
        System.out.println("\ndropWhile():");

        nums.stream()
                .dropWhile(n -> n < 4)
                .forEach(System.out::println);
     */
}
