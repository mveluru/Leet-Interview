package leetcode75.medium;

import java.util.*;

public class LongestStringPalingdrom {

    public static void main(String[] args) {

        //String input = "babad";
        String input = "cbbbbbdaaaa";
        Set<String> set = new HashSet<>();
        Map<String, Integer> stringMap = new HashMap<>();

        for (int i = 0; i < input.length() && (input.length() >= 1 && input.length() <= 1000); i++) {
            for (int j = i + 1; j <= input.length(); j++) {
                String s = input.substring(i, j);
                if (s.length() > 1) {
                    set.add(s);
                }
            }

        }

        StringBuffer sb = new StringBuffer();
        int stringLength = 0;
        for (String s : set) {
            if (s.equals(sb.append(s).reverse().toString())) {
                //System.out.print(s + " ");
                stringMap.put(s, s.length());
                stringLength = Math.max(stringLength, s.length());
            }
            sb.setLength(0);
        }
        int stringer = stringLength;
        stringMap.entrySet().stream().filter(e -> e.getValue() == stringer).forEach(e -> System.out.println(e.getKey() + " " + e.getValue()));
    }
}
