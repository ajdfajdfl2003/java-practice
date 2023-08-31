package thread.future;

import lombok.SneakyThrows;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.Instant;
import java.util.concurrent.*;

public class MyCompletableFuture {
    public static void main2(String[] args) {
//        final CompletableFuture<String> cf = CompletableFuture.supplyAsync(() -> "YOYO, bro");
//        final String result = cf.thenApply(String::toLowerCase).join();
//        System.out.println(result);
//        final String result1 = cf.thenCompose(s -> CompletableFuture.supplyAsync(s::toUpperCase)).join();
//        System.out.println(result1);
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(15);

        CompletableFuture<Void> future = CompletableFuture
                .supplyAsync(() -> {
                    System.out.println("fly " + Instant.now().toString());
                    System.out.println("before schedule, " + Instant.now().toString());
                    return executor.scheduleAtFixedRate(new TaskA(), 0, 100, TimeUnit.MILLISECONDS);
                }, executor)
                .thenAcceptAsync(taskA -> {
                    try {
                        TimeUnit.MILLISECONDS.sleep(0);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    System.out.println("after sleep, " + Instant.now().toString());
                    taskA.cancel(false);
                    System.out.println("after cancel, " + Instant.now().toString());
                }, executor)
                .thenRun(() -> new NextAction().execute());
        future.get();

//        System.out.println("before schedule, " + Instant.now().toString());
//        ScheduledFuture<?> taskA = executor.scheduleAtFixedRate(new TaskA(), 0, 100, TimeUnit.MILLISECONDS);
//        executor.schedule(() -> {
//            taskA.cancel(false);
//            System.out.println("after cancel, " + Instant.now().toString());
//            new NextAction().execute();
//        }, 0, TimeUnit.MILLISECONDS);

        executor.shutdown();
    }

    public static class NextAction {
        public void execute() {
            System.out.println("module.sendEvent(RunningGameEvent.BURST);" + Instant.now().toString());
        }
    }

    public static class TaskA implements Runnable {
        private long nowFlyTime = 0;

        @SneakyThrows
        @Override
        public void run() {
            long multiple = getMultiple(nowFlyTime);
            for (int i = 0; i < 2; i++) {
                TimeUnit.MILLISECONDS.sleep(3);
                System.out.println(Instant.now().toString() + ", TaskA: " + multiple);
            }

            nowFlyTime = nowFlyTime + 100;
        }

        private long getMultiple(long nowFlyTime) {
            if (nowFlyTime == 0) {
                return 1000L;
            }
            double pow = (Math.pow(10D, nowFlyTime / 27581D));
            return BigDecimal.valueOf(pow).setScale(2, RoundingMode.DOWN)
                    .multiply(BigDecimal.valueOf(1000L))
                    .longValue() + 10L;
        }
    }
}
