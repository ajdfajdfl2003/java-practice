package thread.locks;

import org.junit.Test;

public class ReentrantCounterTest {
    @Test
    public void reentrant() throws InterruptedException {
        final ReentrantCounter nonReentrantCounter = new ReentrantCounter();
        nonReentrantCounter.print();
    }
}