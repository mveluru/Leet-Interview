package leetcode75.easy;

public class IndexOfFirstOccurrence {

    private static void firstoccurence1(String haystack, String needle) {
        if (haystack.indexOf(needle) != -1) {
            int haystacklength = haystack.length();
            int needleLength = needle.length();
            for (int i = 0; i < haystacklength; i++) {
                if ((i + needleLength) < haystacklength) {
                    String substring = haystack.substring(i, i + needleLength);
                    if (needle.equals(substring)) {
                        //System.out.println(substring);
                        System.out.println("start_index : " + (i) + " end_index  " + ((i + needleLength - 1)));
                        break;
                    }

                }
            }

        } else {
            System.out.println(-1);
            //System.out.println(0);
        }
    }

    private static void firstoccurence2(String haystack, String needle) {
        if (haystack.toLowerCase().contains(needle.toLowerCase())) {
            int start_index = haystack.indexOf(needle);
            System.out.println("start_index : " + start_index + " end_index: " + (start_index + needle.length() - 1));
        } else {
            System.out.println(-1);
        }
    }

    public static void main(String[] args) {
        //String haystack = "leetcode";
        //String needle = "leetco";
        //String haystack = "sadbutsad";
        //String needle = "sad";
        String haystack = "greekforgreek";
        String needle = "for";
        // String haystack = "kavihellohello";
        //String needle = "hello";
        //String haystack ="dubaikamir";
        //String needle = "mir";

        IndexOfFirstOccurrence.firstoccurence1(haystack, needle);
        IndexOfFirstOccurrence.firstoccurence2(haystack, needle);
    }
}
