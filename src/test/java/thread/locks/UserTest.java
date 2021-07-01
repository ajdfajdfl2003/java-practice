package thread.locks;

import org.junit.Test;

import java.time.Instant;
import java.util.concurrent.*;

public class UserTest {
    @Test
    public void name() throws InterruptedException, ExecutionException {
        final User user = new User();
        user.setProperty("lock1", new Object());
        user.setProperty("lock2", new Object());

        final ExecutorService executorService = Executors.newFixedThreadPool(2);
        final Future<?> submit1 = executorService.submit(() -> {
            synchronized (user.getProperty("lock1")) {
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (user.getProperty("lock2")) {
                    System.out.println(Instant.now().toString() + ", inner lock2: " + Thread.currentThread().getName() + ", get lock");
                }
                System.out.println(Instant.now().toString() + ", Thread1 lock1: " + Thread.currentThread().getName() + ", get lock");
            }
            return "done with " + Thread.currentThread().getName();
        });

        final Future<?> submit2 = executorService.submit(() -> {
            synchronized (user.getProperty("lock2")) {
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (user.getProperty("lock1")) {
                    System.out.println(Instant.now().toString() + ", inner lock1: " + Thread.currentThread().getName() + ", get lock");
                }
                System.out.println(Instant.now().toString() + ", Thread2 lock2: " + Thread.currentThread().getName() + ", get lock");
            }
            return "done with " + Thread.currentThread().getName();
        });

        System.out.println(Instant.now().toString() + ", " + Thread.currentThread().getName());
        System.out.println(submit1.get());
        System.out.println(submit2.get());
    }
}