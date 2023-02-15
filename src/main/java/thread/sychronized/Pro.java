package thread.sychronized;

import lombok.extern.log4j.Log4j2;

import java.util.concurrent.locks.ReentrantLock;

@Log4j2
public class Pro {
    ReentrantLock lock = new ReentrantLock(true);
    int count;

    synchronized void doA() {
        log.info("doA start");
//        try {
//            TimeUnit.MILLISECONDS.sleep(100L);
        count++;
        doB();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        log.info("doA done");
    }

    synchronized void doB() {
        log.info("doB start");
        count--;
        doA();
        log.info("doB done");
    }

    public int getCount() {
        return count;
    }
}
