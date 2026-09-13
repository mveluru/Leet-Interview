package leetcode75.medium;

public class L1910_RemoveAll_Occur_subStringANDFirstOccurence {
    public static void removeSub(String str, String sub) {

        while (str.contains(sub)) {

            str = str.replace(sub, "");
        }
        System.out.println(str);

    }

    public static void removeFirstSub(String str, String sub) {
        // Check if the substring exists first
        if (str.contains(sub)) {
            // Remove ONLY the first match using a regular expression match
            str = str.replaceFirst(sub, "");
        }
        System.out.println("Result: " + str);
    }

    public static void main(String[] args) {
        // Test case 1: axxxxyyyyb -> ab
        String str1 = "axxxxyyyyb";
        String sub1 = "xy";
        System.out.print("Test 1: ");
        removeSub(str1, sub1);

        // Test case 2: daabcbaabcbc -> dababc
        String str2 = "daabcbaabcbc";
        String sub2 = "abc";
        System.out.print("Test 2: ");
        removeSub(str2, sub2);

        // Test case 3: Only the first inner "xy" is removed
        String str3 = "axxxxyyyyb";
        String sub3 = "xy";
        System.out.print("Test 3: ");
        removeFirstSub(str1, sub1);

        // Test case 4: Only the first "abc" is removed
        String str4 = "daabcbaabcbc";
        String sub4 = "abc";
        System.out.print("Test 4: ");
        removeFirstSub(str2, sub2);
    }
}
