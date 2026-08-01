package leetcode75.jee.patterns;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegEx_Examples {


    private static boolean noVowels(String input){
        String regex ="[^aeiouAEIOU]+"; //+ Quantifier
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);
        return matcher.find();
    }

    public static void main(String[] args){
        System.out.println(noVowels("bbbbcccccddd"));
        System.out.println(noVowels("aaaeeee"));
    }

}
