package leetcode75.medium;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class SetIterator  {
    public static void main(String[] args) {
        Set<String> set = new HashSet<String>();
        set.add("a");
        set.add("b");
        set.add("c");
        set.add("d");

        Iterator<String> iterator = set.iterator();
        while (iterator.hasNext()) {
            System.out.print(iterator.next()+" ");
        }


    }
}
