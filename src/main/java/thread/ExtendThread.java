package thread;

import java.util.concurrent.TimeUnit;

public class ExtendThread extends Thread {
    public ExtendThread(String name, boolean isDaemon) {
        this.setName(name);
        this.setDaemon(isDaemon);
    }

    @Override
    public void run() {
        try {
            TimeUnit.SECONDS.sleep(5L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Current thread: " + Thread.currentThread().getName());
    }
}
