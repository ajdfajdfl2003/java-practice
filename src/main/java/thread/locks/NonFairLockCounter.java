package thread.locks;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class NonFairLockCounter {
    // 可重入鎖 + 非公平
    private final Lock lock = new ReentrantLock(false);
    private int sum = 0;

    public int addAndGet() {
        try {
            lock.lock();
            return ++sum;
        } finally {
            lock.unlock();
        }
    }

    public int getSum() {
        return sum;
    }
}
