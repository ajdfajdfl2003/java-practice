package thread.locks;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class FairLockCounter {
    // 可重入鎖 + 公平
    private final Lock lock = new ReentrantLock(true);
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
