package leetcode75.jee.j21_features;


public class StringBuilderEnhancements {

    public static void main(String[] args){

        StringBuilder sb = new StringBuilder();
        sb.repeat(43, 20);
        System.out.println(sb.toString());
        StringBuilder sb1 = new StringBuilder();
        sb1.repeat("-=", 20);
        System.out.println(sb1.toString());

    }
}
