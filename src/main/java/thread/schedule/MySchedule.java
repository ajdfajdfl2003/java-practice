package thread.schedule;

import java.time.Instant;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class MySchedule {
    public static void main(String[] args) throws InterruptedException {
        final ScheduledThreadPoolExecutor poolExecutor =
                new ScheduledThreadPoolExecutor(1);
        poolExecutor.schedule(() -> {
            System.out.println("task 1 " + Instant.now().toEpochMilli());
            sleep(5);
        }, 5, TimeUnit.SECONDS);

        poolExecutor.scheduleAtFixedRate(() -> {
            System.out.println("task 3 " + Instant.now().toEpochMilli());
        }, 0, 1, TimeUnit.SECONDS);

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
