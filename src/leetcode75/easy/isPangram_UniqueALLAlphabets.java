package leetcode75.easy;

public class isPangram_UniqueALLAlphabets {
    public static String isPangrams(String sentence) {
        if (sentence == null || sentence.length() < 26) {
            return "not pangram";
        }
        long uniqueLetters = sentence.toLowerCase().chars().filter(Character::isLetter).distinct().count();
        return uniqueLetters == 26 ? "pangram" : "not pangram";

    }

    public static void main(String[] args) {
        System.out.println(isPangrams("We promptly Judged antique ivory Buckles for the next prize"));
        System.out.println(isPangrams("We promptly judged antique ivory buckles for the prize"));
    }
}
