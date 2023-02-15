package practice;

import lombok.extern.log4j.Log4j2;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

@Log4j2
public class MyCountDownLatch {
    public static void main(String[] args) {
        final CountDownLatch latch = new CountDownLatch(3);

        new Thread(() -> {
            log.info("Starting: " + Thread.currentThread().getName());
            try {
                TimeUnit.SECONDS.sleep(2L);
            } catch (InterruptedException e) {
                log.error("job interrupted", e);
            } finally {
                latch.countDown();
            }
        }).start();
        new Thread(() -> {
            log.info("Starting: " + Thread.currentThread().getName());
            try {
                TimeUnit.SECONDS.sleep(4L);
            } catch (InterruptedException e) {
                log.error("job interrupted", e);
            } finally {
                latch.countDown();
            }
        }).start();
        new Thread(() -> {
            log.info("Starting: " + Thread.currentThread().getName());
            latch.countDown();
        }).start();

        try {
            if (!latch.await(4L, TimeUnit.SECONDS)) {
                log.error("job has not been completed");
            }
        } catch (InterruptedException e) {
            log.error("job interrupted", e);
        }
    }
}
