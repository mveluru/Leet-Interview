package leetcode75.java21.list;

import java.util.LinkedHashSet;
import java.util.SequencedSet;

public class SequenceSets {
    public static void main(String[] args) {
        String[] strs = new String[10];
        SequencedSet<String> set = new LinkedHashSet<>();
        for (int i = 0; i < strs.length; i++) {
            strs[i] = String.valueOf(i) + 1;
            set.add(strs[i]);
        }
        System.out.println(set);
    }
}
