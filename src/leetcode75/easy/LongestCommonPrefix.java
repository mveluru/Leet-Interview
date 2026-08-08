package leetcode75.easy;

public class LongestCommonPrefix {


    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0)
            return "";
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < strs[0].length(); i++) {
            char c = strs[0].toLowerCase().charAt(i);
             boolean flag = false;
            for(String str : strs){
                flag = str.toLowerCase().charAt(i) == c;
            }
            if(flag)
                sb.append(c);
            else
                break;
        }
        return sb.toString();
    }
    public static void main(String[] args) {
        LongestCommonPrefix longestCommonPrefix = new LongestCommonPrefix();
        System.out.println(longestCommonPrefix.longestCommonPrefix(new String[]{"abcde","abcdef","abcdefg","abcdefgh"}));
    }
}
