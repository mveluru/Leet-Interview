package leetcode75.java21.grind75.week1;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DuplicateChars {
    public static void main(String[] args) {
        String input = new Scanner(System.in).nextLine();
        Set<String> dups = new HashSet<>();
        Pattern pattern = Pattern.compile("(.)\\1*");
        Matcher matcher = pattern.matcher(input);
        while (matcher.find()){
            dups.add(String.valueOf(matcher.group().charAt(0)));
        }
        System.out.println(dups);
    }


}
