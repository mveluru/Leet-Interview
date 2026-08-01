package leetcode75.easy;

import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;

public class Reversewords {

public void reverse(String words){

    List<String> toList = Arrays.stream(words.split("\\s")).toList();
    ListIterator<String> reverseList = toList.listIterator(toList.size());// Java 21
    StringBuilder sb = new StringBuilder();
    while (reverseList.hasPrevious()){
        sb.append(reverseList.previous()).append(" ");
    }
    System.out.println(sb);
    sb.setLength(0);

}
public static void main(String[] args){
    Reversewords rw = new Reversewords();
    System.out.println("Write code Practice");
    rw.reverse("Write code Practice");
}
}
