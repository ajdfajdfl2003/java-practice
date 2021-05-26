package thread.locks;

import org.junit.Test;

import java.time.Instant;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

public class LockCounterTest {
    private final int loopNum = 1_000_000;

    @Test
    public void testLockCounter() {
        System.out.println("==========NonFairLockCounter==========");
        System.out.println(Instant.now().toString());
        final NonFairLockCounter nonFairCounter = new NonFairLockCounter();
        IntStream.range(0, loopNum).parallel()
                .forEach(i -> nonFairCounter.addAndGet());
        System.out.println(nonFairCounter.getSum());
        System.out.println(Instant.now().toString());

        System.out.println("==========FairLockCounter==========");
        System.out.println(Instant.now().toString());
        final FairLockCounter fairCounter = new FairLockCounter();
        IntStream.range(0, loopNum).parallel()
                .forEach(i -> fairCounter.addAndGet());
        System.out.println(fairCounter.getSum());
        System.out.println(Instant.now().toString());
    }

    @Test
    public void testReadWrite() throws InterruptedException {
        final FairLockCounter fairCounter = new FairLockCounter();
        new Thread(() -> IntStream.range(0, loopNum).forEach(i ->
                fairCounter.addAndGet())).start();
        new Thread(() -> IntStream.range(0, loopNum).forEach(i -> {
            if (fairCounter.getSum() % 100000 == 99999) {
                System.out.println("FairLockCounter:" + fairCounter.getSum());
            }
        })).start();
        final FairReadWriteLockCounter fairReadWriteCounter = new FairReadWriteLockCounter();
        new Thread(() -> IntStream.range(0, loopNum).forEach(i ->
                fairReadWriteCounter.addAndGet())).start();
        new Thread(() -> IntStream.range(0, loopNum).forEach(i -> {
            if (fairReadWriteCounter.getSum() % 100000 == 99999) {
                System.out.println("FairReadWriteLockCounter: " + fairReadWriteCounter.getSum());
            }
        })).start();
        TimeUnit.SECONDS.sleep(10);
        System.out.println("FairLockCounter final answer: " + fairCounter.getSum());
        System.out.println("FairReadWriteCounter final answer: " + fairReadWriteCounter.getSum());
    }
}