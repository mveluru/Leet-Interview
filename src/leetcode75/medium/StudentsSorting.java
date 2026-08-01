package leetcode75.medium;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StudentsSorting {
    static class Student {

        int id;
        String firstName;
        double cgpa;

        Student(int id, String firstName, double cgpa) {
            this.id = id;
            this.firstName = firstName;
            this.cgpa = cgpa;
        }
    }

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        int n = scan.nextInt();

        List<Student> students = new ArrayList<>();

        for (int i = 0; i < n; i++) {

            int id = scan.nextInt();
            String name = scan.next();
            double cgpa = scan.nextDouble();

            students.add(new Student(id, name, cgpa));
        }

        scan.close();

        // Sort using Comparator
        students.sort((s1, s2) -> {

            // Descending CGPA
            if (Double.compare(s2.cgpa, s1.cgpa) != 0) {
                return Double.compare(s2.cgpa, s1.cgpa);
            }

            // Alphabetical first name
            if (!s1.firstName.equals(s2.firstName)) {
                return s1.firstName.compareTo(s2.firstName);
            }

            // Ascending ID
            return Integer.compare(s1.id, s2.id);
        });

        // Print names
        for (Student s : students) {
            System.out.println(s.firstName);
        }
    }
}
/*
5
33 Rumpa 3.68
85 Ashis 3.85
56 Samiha 3.75
19 Samara 3.75
22 Fahim 3.76
 */