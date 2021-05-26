package thread.sychronized;

import org.junit.Test;

import java.time.Instant;
import java.util.stream.IntStream;

public class LockCounterTest {
    @Test
    public void testLockCounter() {
        System.out.println(Instant.now().toString());
        int loopNum = 1_000_000;
        final LockCounter counter = new LockCounter();
        IntStream.range(0, loopNum).parallel()
                .forEach(i -> counter.addAndGet());
        System.out.println(counter.getSum());
        System.out.println(Instant.now().toString());
    }
}