package thread.locks;

import java.util.concurrent.locks.ReentrantLock;

public class ReentrantCounter {
    private final ReentrantLock lock = new ReentrantLock(false);

    public void print() {
        try {
            lock.lock();
            inner();
        } finally {
            lock.unlock();
        }
    }

    public void inner() {
        try {
            lock.lock();
            System.out.println("call inner");
        } finally {
            lock.unlock();
        }
    }
}
