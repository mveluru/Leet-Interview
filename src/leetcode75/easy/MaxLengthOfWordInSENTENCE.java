package leetcode75.easy;

public class MaxLengthOfWordInSENTENCE {
    public static void main(String[] args) {
        String input = "Java Spring Microservices AWS";
        String[] inputArray = input.split("\\s+");
        int maxLength =0;
        String word ="";
        for (String str: inputArray) {
            if (str.length()>maxLength) {
                maxLength = str.length();
                word = str;
            }
        }
        System.out.println(word+","+maxLength);

    }
}
