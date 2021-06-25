package thread.locks;

import org.junit.Test;

public class NonReentrantCounterTest {
    @Test
    public void nonReentrant() throws InterruptedException {
        final NonReentrantCounter nonReentrantCounter = new NonReentrantCounter();
        nonReentrantCounter.print();
    }
}