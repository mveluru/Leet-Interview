package leetcode75.medium;

import java.util.HashMap;
import java.util.Map;

public class GroupOfPalindroms {

    public static String reverseString(String str){
        StringBuilder sb = new StringBuilder(str);
        return sb.reverse().toString();
    }
    public void palindroms(String[] words) {
        Map<String, Boolean> palindrom = new HashMap<>();
        for(String word : words){
            palindrom.put(word, word.equalsIgnoreCase(reverseString(word)));
        }
        for(String word : palindrom.keySet()){
            if(palindrom.get(word)){
                System.out.println(word + ": " + palindrom.get(word));
            }else{
                System.out.println(word + ": " + palindrom.get(word));
            }
        }
    }


    public static void main(String[] args){
     String[] palindroms ={"Radar", "Kayak", "Madam", "Level", "Refer", "Rotor", "Stats", "Tenet", "Minim", "Sagas","Notes"};
     GroupOfPalindroms group = new GroupOfPalindroms();
     group.palindroms(palindroms);
    }
}
