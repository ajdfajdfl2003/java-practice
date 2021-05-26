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
            // 沒有鎖，碰運氣去拿到想要的值
            final int sum = fairCounter.getSum();
            if (sum % 100000 == 99999) {
                System.out.println("FairLockCounter:" + sum);
            }
        })).start();

        final FairReadWriteLockCounter fairReadWriteCounter = new FairReadWriteLockCounter();
        new Thread(() -> IntStream.range(0, loopNum).forEach(i ->
                fairReadWriteCounter.addAndGet())).start();
        new Thread(() -> IntStream.range(0, loopNum).forEach(i -> {
            // 只要我拿到讀鎖，我就能保證能拿到我想要的值是對的
            // 也就是會先卡住寫，等我讀完以後，再放行給寫鎖做事
            final int sum = fairReadWriteCounter.getSum();
            if (sum % 100000 == 99999) {
                System.out.println("FairReadWriteLockCounter: " + sum);
            }
        })).start();
        TimeUnit.SECONDS.sleep(10);
        System.out.println("FairLockCounter final answer: " + fairCounter.getSum());
        System.out.println("FairReadWriteCounter final answer: " + fairReadWriteCounter.getSum());
    }
}