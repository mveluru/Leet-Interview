package leetcode75.hard;

public class ShortenUrlService {
    private static final String BASE62 = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    private static final int BASE = BASE62.length();

    // Converts a unique Database Auto-Increment ID to a Short Key
    public String encode(long id) {
        StringBuilder sb = new StringBuilder();
        while (id > 0) {
            sb.append(BASE62.charAt((int) (id % BASE)));
            id /= BASE;
        }
        return sb.reverse().toString(); // e.g., 200921 becomes "eX9"
    }

    // Converts a Short Key back to the Database ID (Optional, if looking up by Numeric ID)
    public long decode(String shortKey) {
        long id = 0;
        for (int i = 0; i < shortKey.length(); i++) {
            id = id * BASE + BASE62.indexOf(shortKey.charAt(i));
        }
        return id;
    }
}
