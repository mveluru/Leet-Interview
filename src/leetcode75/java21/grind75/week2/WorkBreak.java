package leetcode75.java21.grind75.week2;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WorkBreak {
    public static void main(String[] args) {
        String[] words = {"leet", "code"};
        String str = "leetcodeleet";
        String[] words1 = {"apple","pen"};
        String str1 = "applepenapple";


        for (int i = 0; i < words.length; i++) {


            Pattern pattern = Pattern.compile(words1[i]);
            Matcher matcher = pattern.matcher(str1);
            int count = 0;
            while (matcher.find()) {
                //System.out.println(matcher.group());
                count++;
            }
            System.out.println(words1[i] + " " + count);
        }

    }
}
