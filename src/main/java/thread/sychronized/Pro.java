package thread.sychronized;

import lombok.extern.log4j.Log4j2;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

@Log4j2
public class Pro {
    ReentrantLock lock = new ReentrantLock(true);
    int count;

    void doA() {
        synchronized (this) {
            log.info("doA start");
            count++;
            try {
                TimeUnit.MILLISECONDS.sleep(100L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            log.info("doA done");
        }
    }

    void doB() {
        synchronized (this) {
            log.info("doB start");
            count--;
            log.info("doB done");
        }
    }

    public int getCount() {
        return count;
    }
}
