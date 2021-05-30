package thread.atomic;

import org.junit.Test;

import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

public class AtomicCounterTest {
    private final int loopNum = 1_000_000;

    @Test
    public void read_write() throws InterruptedException {
        final AtomicCounter atomicCounter = new AtomicCounter();
        new Thread(() -> IntStream.range(0, loopNum).forEach(i ->
                atomicCounter.addAndGet())).start();
        new Thread(() -> IntStream.range(0, loopNum).forEach(i -> {
            // 沒有鎖，碰運氣去拿到想要的值
            final int sum = atomicCounter.getSum();
            if (sum % 100000 == 99999) {
                System.out.println("AtomicCounter:" + sum);
            }
        })).start();

        TimeUnit.SECONDS.sleep(1);
        System.out.println("AtomicCounter final answer: " + atomicCounter.getSum());
    }
}