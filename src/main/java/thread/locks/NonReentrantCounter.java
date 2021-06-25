package thread.locks;

public class NonReentrantCounter {
    private final NonReentrant lock = new NonReentrant();

    public void print() throws InterruptedException {
        lock.lock();
        inner();
        lock.unlock();
    }

    public void inner() throws InterruptedException {
        lock.lock();
        System.out.println("call inner");
        lock.unlock();
    }
}
