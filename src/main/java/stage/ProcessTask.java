package stage;

import lombok.extern.log4j.Log4j2;

import java.util.concurrent.TimeUnit;

@Log4j2
public class ProcessTask implements Runnable {
    //public class ProcessTask extends Thread {
//    @Override
//    public synchronized void start() {
//        super.start();
//    }

    @Override
    public void run() {
        log.info("[BStage Process] start");
        try {
            TimeUnit.SECONDS.sleep(5);
            log.info("[BStage Process] done");
        } catch (InterruptedException e) {
            log.error(e);
        }
    }
}
