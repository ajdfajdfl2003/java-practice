package thread.schedule;

import java.time.Instant;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class MySchedule {
    public static void main(String[] args) throws InterruptedException {
        final ScheduledThreadPoolExecutor poolExecutor =
                new ScheduledThreadPoolExecutor(1);
        AtomicInteger counter = new AtomicInteger(0);
        poolExecutor.schedule(() -> {
            try {
                if (3 == counter.get()) {
                    throw new Exception("test test test");
                }
                System.out.println("task 1 " + Instant.now().toEpochMilli());
                sleep(2);
            } catch (Exception e) {
                System.out.println(e);
            }
        }, 0, TimeUnit.SECONDS);

//        poolExecutor.scheduleAtFixedRate(() -> {
//            System.out.println("task 3 " + Instant.now().toEpochMilli());
//        }, 0, 1, TimeUnit.SECONDS);

//        poolExecutor.schedule(() -> {
//            System.out.println("task 2");
//            sleep(1);
//        }, 0, TimeUnit.SECONDS);
//        TimeUnit.SECONDS.sleep(4);
    }

    private static void sleep(int second) {
        try {
            TimeUnit.SECONDS.sleep(second);
        } catch (InterruptedException ignore) {

        }
    }
}
