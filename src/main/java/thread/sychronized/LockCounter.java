package thread.sychronized;

public class LockCounter {
    private int sum = 0;

    public synchronized int addAndGet() {
        return ++sum;
    }

    public int getSum() {
        return sum;
    }
}
