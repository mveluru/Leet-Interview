package RateLimit;

import java.time.Instant;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

public class CustomRateLimiter {
    private final int maxRequests =100;
    private final long windowSizeinMIlls = 10_000;
    private final AtomicInteger requestCount = new AtomicInteger(0);
    private final AtomicLong windowStartTime = new AtomicLong(System.currentTimeMillis());

    public boolean allowRequest() {
        long currentTime = System.currentTimeMillis();
        long startTime = windowStartTime.get();
        if (currentTime - startTime >= windowSizeinMIlls) {
            if (windowStartTime.compareAndSet(startTime, currentTime)) {
                requestCount.set(0); // Reset count for the new window
            }
        }

        if (requestCount.incrementAndGet() <= maxRequests) {
            return true; // Request allowed
        } else {
            return false; // Request blocked (Limit exceeded)
        }
    }

    public static void main(String[] args) {
        CustomRateLimiter limiter = new CustomRateLimiter();

        // Simulate incoming requests
        for (int i = 1; i <= 105; i++) {
            if (limiter.allowRequest()) {
                System.out.println("Request " + i + ": Allowed");
            } else {
                System.out.println("Request " + i + ": Blocked (Rate limit exceeded)");
            }
        }
    }
}
