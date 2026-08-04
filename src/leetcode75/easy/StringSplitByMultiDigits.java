package leetcode75.easy;

public class StringSplitByMultiDigits {
    public static void checkSubstring(String substring) {
        String[] split = substring.split("\\d+");
        System.out.println("Split result: " + String.join(", ", split));

    }
    public static void main(String[] args) {
        checkSubstring("ABAB12ABABAB345ABABABAB6ABABAB124ABABAB");
    }
}
