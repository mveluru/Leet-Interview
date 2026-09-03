package leetcode75.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindRepeatingChars {

    protected void findduplicateChars(String input){
        char[] chars = input.toCharArray();
        //char[] chars = input.toLowerCase().toCharArray();
        Arrays.sort(chars);
        List<Character> listofchars = new ArrayList<>();
       for(int i = 0;i<chars.length;i++){
           for (int j=0;j<chars.length;j++){
               if(i!=j && chars[i]==chars[j] && !listofchars.contains(chars[j])){
                   listofchars.add(chars[j]);

               }

           }
       }
        System.out.println(listofchars);
    }



    public static void main(String[] args){
        String str ="AaaAppPPPPPle";
        FindRepeatingChars repeatingChars = new FindRepeatingChars();
        repeatingChars.findduplicateChars(str);



    }
}
