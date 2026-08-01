package leetcode75.easy;

public class MergeStringAlternatively {

    public static void mergeString(String s1, String s2) {
        StringBuilder sb = new StringBuilder();
        int i = 0, j = 0;
        while (i < s1.length() && j < s2.length()) {
            sb.append(s1.charAt(i++));
            sb.append(s2.charAt(j++));
        }
        if (s1.length() > s2.length()) {
            sb.append(s1.substring(i));
        } else if (s2.length() > s1.length()) {
            sb.append(s2.substring(j));
        }
        //System.out.printf("Merged String %4s", sb.toString()); prints all caplongs
        System.out.println(sb.toString());
    }// end of method

    public static void main(String[] args) {
        String s1 = "abc";
        String s2 = "pqr";
        mergeString(s1, s2);
        System.out.println();

        String s3 = "ab";
        String s4 = "kqrsxyz";
        mergeString(s3, s4);


    }
}

