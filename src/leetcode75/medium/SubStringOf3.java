package leetcode75.medium;


import java.util.Scanner;
import java.util.TreeSet;

public class SubStringOf3 {

    public static TreeSet<String> substring3(String s, int n) {
        TreeSet<String> set = new TreeSet<>();
        for (int i = 0; i < s.length()-2; i++) {
            String substring = s.substring(i, i + n);
            set.add(substring);

        }
        return set;
    }

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scan = new Scanner(System.in);
        String s = scan.next().replaceAll("[^a-zA-Z]", "");
        int n = scan.nextInt();
        scan.close();
        TreeSet<String> set = substring3(s, n);
        System.out.println(set.first());
        System.out.println(set.last());
    }
}
