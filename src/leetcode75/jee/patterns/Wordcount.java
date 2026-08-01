package leetcode75.jee.patterns;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Wordcount {

    public static void wordcounts(String sentence) {


        // Create a pattern to match words
        Pattern pattern = Pattern.compile("\\b(\\w+)\\b");

        // Create a matcher to find matches in the sentence
        Matcher matcher = pattern.matcher(sentence);

        // Create a map to store the count of each word
        Map<String, Integer> wordCount = new HashMap<>();

        // Iterate over the matches and update the word count map
        while (matcher.find()) {
            String word = matcher.group();
            int count = wordCount.getOrDefault(word, 0);
            wordCount.put(word, count + 1);
        }

        // Print the word count map
        for (String word : wordCount.keySet()) {
            System.out.println(word + ": " + wordCount.get(word));
        }


    }


    public static void numberOfWords(String sentence) {
        Pattern pattern = Pattern.compile("\\w+");
        Matcher matcher = pattern.matcher(sentence);
        int count = 0;
        while (matcher.find()) {
            count++;
        }
        System.out.println("Number of words : " + count);


    }


    public static void main(String[] args) {
        String sentence = "Big black bug bit a big black dog on his big black nose";
        wordcounts(sentence);
        numberOfWords(sentence);
    }
}
