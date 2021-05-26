package thread.locks;

import org.junit.Test;

import java.time.Instant;
import java.util.stream.IntStream;

public class LockCounterTest {
    @Test
    public void testLockCounter() {
        System.out.println(Instant.now().toString());
        int loopNum = 1_000_000;
        final NonFairLockCounter nonFairCounter = new NonFairLockCounter();
        IntStream.range(0, loopNum).parallel()
                .forEach(i -> nonFairCounter.addAndGet());
        System.out.println(nonFairCounter.getSum());
        System.out.println(Instant.now().toString());
        System.out.println("=====================");
        System.out.println(Instant.now().toString());
        final FairLockCounter fairCounter = new FairLockCounter();
        IntStream.range(0, loopNum).parallel()
                .forEach(i -> fairCounter.addAndGet());
        System.out.println(fairCounter.getSum());
        System.out.println(Instant.now().toString());
    }
}