package leetcode75.jee.patterns;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AllCharsSame {

    public boolean allcharsame(String input){
        Pattern pattern = Pattern.compile("^(.)\\1*$");
        Matcher matcher = pattern.matcher(input);
        return matcher.find();
    }

    public static void main(String[] arg){
        AllCharsSame allCharsareSame = new AllCharsSame();
        //String input = "aaaaaaaaaa";
        //String input = "baaaaaaaaa";
        String input = "aaaaabaaaa";
        boolean allcharsame = allCharsareSame.allcharsame(input);
        System.out.println("All chars are same : "+ allcharsame);

    }
}
