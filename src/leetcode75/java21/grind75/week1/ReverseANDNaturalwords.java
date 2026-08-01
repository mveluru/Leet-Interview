package leetcode75.java21.grind75.week1;

import java.util.Arrays;
import java.util.Comparator;

public class ReverseANDNaturalwords {

    public void reverseWords(String[] words) {
        Arrays.stream(words).sorted(Comparator.reverseOrder()).forEach(word->System.out.print(word+" "));
        System.out.println();

        Arrays.stream(words).sorted(Comparator.naturalOrder()).forEach(word->System.out.print(word+" "));
    }

    public static void main(String[] args) {

        String[] words = {"hello", "Apple", "world", "leetcode","Boy"};

        new ReverseANDNaturalwords().reverseWords(words);
    }
}
