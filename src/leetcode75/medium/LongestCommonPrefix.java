package leetcode75.medium;

import java.util.*;
import java.util.stream.Collectors;


public class LongestCommonPrefix {

    public static void main(String[] args) {

        //String[] stringArray = {"flower", "flow", "flight"};
        String[] stringArray = {"flower", "flow", "flog"};
       // String[] stringArray = {"floower", "floowe", "floower"};
        String[] sortedArray = Arrays.stream(stringArray).sorted().toArray(String[]::new);
        System.out.println(Arrays.toString(sortedArray));
        int minlength= Arrays.stream(sortedArray).mapToInt(String::length).min().getAsInt();
        List<String> prefix = new ArrayList<>();
        for (int i=0;i<=minlength;i++){
            boolean isprefix = false;
            String iss = sortedArray[0].substring(0,i);
            for (String s:sortedArray){
                String jss = s.substring(0,i);
                if (iss.equals(jss) ) {
                    isprefix = true;
                }else{
                    isprefix=false;
                }
            }
            if(isprefix){
                prefix.add(iss);
            }

        }
        int maxlen = prefix.stream().mapToInt(e->e.length()).max().getAsInt();
        Set<String> set = prefix.stream().filter(e->e.length()==maxlen).collect(Collectors.toSet());
        System.out.println(set);

    }
}
