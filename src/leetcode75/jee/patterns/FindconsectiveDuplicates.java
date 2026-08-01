package leetcode75.jee.patterns;

import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FindconsectiveDuplicates {

    public static Set<String> findconsectiveDuplicates(String input) {
        Set<String> dupchars = new HashSet<>();
        Pattern pattern = Pattern.compile("(.)\\1+");
        Matcher matcher = pattern.matcher(input);
        while (matcher.find()) {

            dupchars.add(matcher.group());
            //dupchars.add(matcher.group(1))
        }
        return dupchars;
    }

    public static Set<String> findduplicates(String input){
        Set<String> dupchars = new HashSet<>();
        Pattern pattern = Pattern.compile("(.)\\1*");
        Matcher matcher = pattern.matcher(input);
        while (matcher.find()){
            dupchars.add(matcher.group());
        }
        return dupchars;
    }

    public static void main(String[] args) {
        String str1 = "hellohello";
        System.out.println(findconsectiveDuplicates(str1));

        String str2 = "goodgod";
        System.out.println(findconsectiveDuplicates(str2));


        System.out.println(findduplicates(str1));

        System.out.println(findduplicates(str2));
    }
}
