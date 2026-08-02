package leetcode75.medium;

import java.util.stream.Stream;

public class CompressionBuilder {

    public static int compressString(char[] chars) {
       if (chars == null || chars.length==0){
           return 0;
       }
       StringBuilder sb = new StringBuilder();
       int count = 1;
        for (int i = 0; i < chars.length; i++) {
            // If it's the last character or different from the next one
            if (i == chars.length - 1 || chars[i] != chars[i + 1]) {
                sb.append(chars[i]);
                if (count > 1) {
                    sb.append(count);
                }
                count = 1; // Reset count
            } else {
                count++;
            }
        }
        System.out.println(sb.toString());
        return sb.toString().trim().length();
    }
  public static void main(String[] args){
      char[] chars = {'a', 'a', 'a', 'b', 'b', 'c', 'c', 'c','d','d'};
      System.out.println(compressString(chars));
  }
}
