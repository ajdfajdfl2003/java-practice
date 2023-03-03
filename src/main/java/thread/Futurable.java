package thread;

import java.time.Instant;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Futurable {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(2);

        CompletableFuture.allOf(
                CompletableFuture.runAsync(() -> {
                    try {
                        TimeUnit.SECONDS.sleep(5L);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("Current thread: " + Thread.currentThread().getName());
                }, executorService),
                CompletableFuture.runAsync(() -> {
                    try {
                        TimeUnit.SECONDS.sleep(5L);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("Current thread: " + Thread.currentThread().getName());
                }, executorService)).join();

        System.out.println("The end: " + Instant.now().toString());
    }
}
