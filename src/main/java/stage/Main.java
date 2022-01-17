package stage;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class Main {
    public static void main(String[] args) throws InterruptedException {
        log.info("test start");
//        final CountDownLatch countDownLatch = new CountDownLatch(1);
        new Module().nextStage(2000);
//        countDownLatch.await();
    }
}
