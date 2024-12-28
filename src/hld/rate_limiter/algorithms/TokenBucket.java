package hld.rate_limiter.algorithms;

import java.util.concurrent.atomic.AtomicLong;

public class TokenBucket {

    private final long capacity;
    private final long refillRate;
    private final AtomicLong tokens;
    private final AtomicLong lastRefillTimestamp;
    private final long refillIntervalNanos;

    public TokenBucket(long capacity, long refillRate) {
        this.capacity = capacity;
        this.refillRate = refillRate;
        this.refillIntervalNanos = 1_000_000_000L;

        this.tokens = new AtomicLong(capacity);
        this.lastRefillTimestamp = new AtomicLong(System.nanoTime());
        System.out.println(lastRefillTimestamp);
    }

    public synchronized boolean allowRequest(int tokenCost) {
        refill();
        if (tokens.get() >= tokenCost) {
            tokens.getAndAdd(-tokenCost);
            return true;
        }
        return false;
    }

    private void refill() {
        long now = System.nanoTime();
        long timeElapsed = now - lastRefillTimestamp.get();
        if (timeElapsed >= refillIntervalNanos) {
            long tokensToAdd = (timeElapsed / refillIntervalNanos) * refillRate;
            long newTokens = Math.min(tokens.get() + tokensToAdd, capacity);
            tokens.set(newTokens);
            lastRefillTimestamp.set(now);
        }
    }

    public static void main(String[] args) {
        // Capacity = 10 tokens, Refill Rate = 5 tokens / second
        TokenBucket tokenBucket = new TokenBucket(10, 5);

        for (int i = 0; i < 100; i++) {
            if (tokenBucket.allowRequest(1)) {
                System.out.println("Request " + (i + 1) + " allowed.");
            } else {
                System.out.println("Request " + (i + 1) + " denied.");
            }

            try {
                Thread.sleep(100); // simulate time between requests
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
