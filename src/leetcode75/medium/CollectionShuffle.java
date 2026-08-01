package leetcode75.medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class CollectionShuffle {

    private void intshuffle() {

        List<Integer> integers = new ArrayList<>();
        int count = 0;
        while (count < 50) {
            integers.add(++count);
        }

        System.out.println("IntStream of Integers");
        System.out.println(integers);
        Collections.shuffle(integers);
        System.out.println("Shuffled Integers");
        System.out.println(integers);

    }

    // Not a good solution , failure % is 1 to 5
    private void wordsshuffle(String[] args) {
        List<String> stringList = new ArrayList<>();
       // stringList=  Arrays.stream(args).toList(); // unsupportOperationException error will be thrown - since it's immutable.
      for (String s : args) {
            stringList.add(s);
        }
        System.out.println(stringList);
        //String string ="wordgoodgoodgoodbestword";
        //String string ="wordgoodwordbestwordgood";
        //String string ="wordgoodwordbestwordgoodhellomuralidhargurureddyvelurunellore";
        String string ="wordgoodefabcdwordgoodhelloabcdefcdefab";
        //String string = "barfoothefoobarman";
        //String string = "thefoobarmanbarfoo";

        for (int i = 0; i < 100000; i++) {
            Collections.shuffle(stringList);
            String comparestring = stringList.stream().collect(Collectors.joining());
           //System.out.println(comparestring);
            if (string.contains(comparestring) || string.matches(comparestring)) {
                System.out.println(true);
               // System.out.println(string.indexOf(comparestring)+" "+(stringList.indexOf(comparestring)+comparestring.length()));
                //System.out.println(i);
                break;
            }
        }


    }

    public static void main(String[] args) {
        CollectionShuffle collectionShuffle = new CollectionShuffle();
        //collectionShuffle.intshuffle();
        //String[] stringarray ={"word","good","best","word"};
        String[] stringarray = {"foo", "bar"};
       // String[] stringarray ={"hello","guru","murali","dhar","reddy","veluru","nellore"};
        //String[] stringarray = {"ab","cd","ef"};
        collectionShuffle.wordsshuffle(stringarray);
    }
}
