package practice;

import com.google.common.util.concurrent.RateLimiter;
import lombok.extern.log4j.Log4j2;

import java.time.Instant;
import java.util.Map;
import java.util.concurrent.*;

@Log4j2
public class RateLimit {
    public static final Map<String, RateLimiter> rateLimiterMap = new ConcurrentHashMap<>();

    public static void main(String[] args) throws InterruptedException {
        final int nThreads = 3;
        final ExecutorService executorService = Executors.newFixedThreadPool(nThreads);
        CountDownLatch latch = new CountDownLatch(nThreads);
        executorService.execute(new QueryTask("angus", latch));
        TimeUnit.MILLISECONDS.sleep(1500L);
        executorService.execute(new QueryTask("angus", latch));
        TimeUnit.MILLISECONDS.sleep(1500L);
        executorService.execute(new QueryTask("angus", latch));
        latch.await();
        executorService.shutdown();
    }

    static class QueryTask implements Runnable {
        private final double permitsPerSecond = 0.5D;
        private final String name;
        private final CountDownLatch latch;

        public QueryTask(String name, CountDownLatch latch) {
            this.name = name;
            this.latch = latch;
            if (!rateLimiterMap.containsKey(name)) {
                rateLimiterMap.put(name, RateLimiter.create(permitsPerSecond));
            }
        }

        @Override
        public void run() {
            try {
                log.info(Thread.currentThread().getName() + ", Starting at: " + Instant.now().toString());
                if (rateLimiterMap.get(name).tryAcquire()) {
                    TimeUnit.MILLISECONDS.sleep(2000L);
                    log.info(Thread.currentThread().getName() + ", do things done at: " + Instant.now().toString());
                } else {
                    log.info(Thread.currentThread().getName() + ", something went wrong at: " + Instant.now().toString());
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                latch.countDown();
            }
        }
    }
}
