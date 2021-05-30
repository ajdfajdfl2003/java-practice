package thread.locks;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class FairReadWriteLockCounter {
    // 可重入鎖 + 讀寫鎖 + 公平
    private final ReadWriteLock lock = new ReentrantReadWriteLock(true);
    private int sum = 0;

    public int addAndGet() {
        try {
            lock.writeLock().lock();
            return ++sum;
        } finally {
            lock.writeLock().unlock();
        }
    }

    public int getSum() {
        try {
            lock.readLock().lock();
            return sum;
        } finally {
            lock.readLock().unlock();
        }
    }
}
