package thread.atomic;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicCounter {
    private final AtomicInteger sum = new AtomicInteger(0);

    public int addAndGet() {
        return sum.incrementAndGet();
    }

    public int getSum() {
        return sum.get();
    }
}
