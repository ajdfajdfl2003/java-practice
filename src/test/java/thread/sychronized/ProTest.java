package thread.sychronized;

import org.junit.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

public class ProTest {

    private final int loopNum = 100;

    @Test
    public void name() throws InterruptedException {
        final Pro pro = new Pro();
        final ExecutorService executorService = Executors.newFixedThreadPool(2);
        executorService.submit(() -> IntStream.range(0, loopNum).parallel()
                .forEach(i -> pro.doA()));
        executorService.submit(() -> IntStream.range(0, loopNum).parallel()
                .forEach(i -> pro.doB()));
        executorService.shutdown();
        TimeUnit.SECONDS.sleep(11);
        System.out.println("all count: " + pro.getCount());
    }
}