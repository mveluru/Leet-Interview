package leetcode75.easy;
//Problem #392
public class isSubSequence {
    public static boolean subSequence(String s, String t) {
        int sourceIndex = 0;
        int targetIndex = 0;
        boolean flag = false;
        while (sourceIndex < s.length() && targetIndex < t.length()) {

            if (s.charAt(sourceIndex) == t.charAt(targetIndex)) {
                sourceIndex++;
                targetIndex++;
                flag = true;

            }else  {
                targetIndex++;
                flag = false;
            }
        }
        return flag;
    }
    public static void main(String[] args) {
        System.out.println(subSequence("abc", "ahbgdc"));
        System.out.println(subSequence("axc", "ahbgdc"));
        System.out.println(subSequence("aem", "ahegdm"));
    }

}
