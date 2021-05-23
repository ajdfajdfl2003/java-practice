package thread;

import java.util.concurrent.TimeUnit;

public class ANewThread {
    public static void main(String[] args) throws InterruptedException {
        //first way:
        final Runnable runnable = () -> {
            try {
                TimeUnit.SECONDS.sleep(5L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Current thread: " + Thread.currentThread().getName());
        };
        final Thread thread = new Thread(runnable);
        thread.setName("test_thread_1");
        thread.setDaemon(true);
        thread.start();

        //second way:
        new ExtendThread("test_thread_2", true).start();

        TimeUnit.SECONDS.sleep(6);
    }
}
