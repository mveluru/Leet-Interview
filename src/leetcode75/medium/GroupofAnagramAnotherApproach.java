package leetcode75.medium;

import java.util.*;

public class GroupofAnagramAnotherApproach {
    public static void groupAnagrams(List<String> wordsList) {

        Map<String, List<String>> map = new HashMap<>();

        for (String word : wordsList) {

            String key = getSortedKey(word);

            map.putIfAbsent(key, new ArrayList<>());

            map.get(key).add(word);
        }

        for (List<String> group : map.values()) {

            if (group.size() > 1) {
                System.out.println(group + " are anagrams");
            }
        }
    }

    private static String getSortedKey(String word) {

        char[] chars = word.trim().toLowerCase().toCharArray();

        Arrays.sort(chars);

        return new String(chars);
    }

    public static void main(String[] args) {

        List<String> words = Arrays.asList(
                "eat",
                "tea",
                "tan",
                "ate",
                "nat",
                "bat"
        );

        groupAnagrams(words);
    }
}
