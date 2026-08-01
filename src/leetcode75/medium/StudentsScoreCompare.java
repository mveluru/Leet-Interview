package leetcode75.medium;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StudentsScoreCompare {
    static class Student {
        String name;
        int score;

        public Student(String name, int score) {
            this.name = name;
            this.score = score;
        }

        @Override
        public String toString() {
            return "Student [name=" + name + ", score=" + score + "]";
        }
    }

    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();

        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        while (n-- > 0) {
            String line = in.next();
            int score = in.nextInt();
            students.add(new Student(line, score));
        }
        students.sort((s1, s2) -> {
            if (s1.score != s2.score) {
                return Integer.compare(s2.score, s1.score);
            }

            // Then alphabetical name
            return s1.name.compareTo(s2.name);
        });

        students.forEach(System.out::println);
    }
}
