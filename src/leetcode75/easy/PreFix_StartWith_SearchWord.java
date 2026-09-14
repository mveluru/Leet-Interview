package leetcode75.easy;

public class PreFix_StartWith_SearchWord {
    public static void searchWithPrefix(String[] words, String searchWord) {
        if (words == null || words.length == 0) {
            return;
        }
        int count = 0;
        for (String word : words) {
            if (word.startsWith(searchWord)) {
                System.out.println(count + " " + word+" "+searchWord);
                break;
            }

            if (count == words.length-1 && !word.startsWith(searchWord)) {
                count =-1;
                System.out.println(count + " " + searchWord);
            }
            count++;
        }

    }

    public static void main(String[] args) {
        String sentence0 = "i love eating burger";
        String searchWord0 = "burg";
        String sentence1 = "this theme is thrilling";
        String searchWord1= "th";
        String sentence2 = "apple apple pie";
        String searchWord2= "apple";
        searchWithPrefix(sentence0.split("\\s+"),searchWord0);
        searchWithPrefix(sentence1.split("\\s+"),searchWord1);
        searchWithPrefix(sentence2.split("\\s+"),searchWord2);
    }
}
