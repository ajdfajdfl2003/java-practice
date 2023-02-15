package practice;

import lombok.extern.log4j.Log4j2;
import org.junit.Test;

import java.time.Instant;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;

@Log4j2
public class SynchronousQueueDemo {
    static final SynchronousQueue<String> queue = new SynchronousQueue<>();

    @Test
    public void name() throws InterruptedException {

        new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                try {
                    TimeUnit.SECONDS.sleep(2);
                    new Producer("name-" + i).run();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                try {
                    TimeUnit.SECONDS.sleep(3);
                    new Consumer().run();
                    log.info("Consumer take successfully");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        TimeUnit.SECONDS.sleep(20);
    }

    static class Consumer {
        public void run() throws InterruptedException {
            log.info(Instant.now() + ",take: " + queue.take());
        }
    }

    static class Producer {
        private final String name;

        public Producer(String name) {
            this.name = name;
        }

        public void run() throws InterruptedException {
            final boolean offer = queue.offer(name);
            if (offer) {
                log.info(Instant.now() + ", " + name + ", offer");
            } else {

            }
        }
    }
}
