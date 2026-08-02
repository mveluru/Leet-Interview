package cacheusingMap;

import java.util.concurrent.ConcurrentHashMap;
import java.time.Instant;

public class CacheImpl<K, V> {
    private final ConcurrentHashMap<K, CacheEntry<V>> cache = new ConcurrentHashMap<>();

    private static class CacheEntry<V> {
        private final V value;
        private final Instant expiryTime;

        private CacheEntry(V value, long ttlInSeconds) {
            this.value = value;
            // FIXED: Explicitly treats the input as seconds to match your main method's intent
            this.expiryTime = Instant.now().plusSeconds(ttlInSeconds);
        }

        private boolean isExpired() {
            return Instant.now().isAfter(expiryTime);
        }
    }

    public void put(K key, V value, long ttlInSeconds) {
        cache.put(key, new CacheEntry<>(value, ttlInSeconds));
    }

    public V get(K key) {
        CacheEntry<V> entry = cache.get(key);

        if (entry == null) {
            return null;
        }

        // FIXED: Condition simplified. Clean up expired entries immediately.
        if (entry.isExpired()) {
            // Thread-safe removal only if another thread hasn't updated it yet
            cache.remove(key, entry);
            return null;
        }

        return entry.value;
    }

    public void clear() {
        cache.clear();
    }

    public static void main(String[] args) throws InterruptedException {
        CacheImpl<String, String> cache = new CacheImpl<>();

        // FIXED: Changed 2000 to 2 because the implementation expects seconds
        cache.put("session_token", "XYZ123", 2);

        System.out.println("Immediate get: " + cache.get("session_token")); // Outputs: XYZ123

        // Wait for 2.5 seconds
        Thread.sleep(2500);

        System.out.println("Get after timeout: " + cache.get("session_token")); // Outputs: null
    }
}