package thread;

import java.util.concurrent.TimeUnit;

public class ANewThread {
    public static void main(String[] args) throws InterruptedException {
        //first way:
        final Runnable runnable = () -> {
            try {
                TimeUnit.SECONDS.sleep(5L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Current thread: " + Thread.currentThread().getName());
        };
        final Thread thread = new Thread(runnable);
        thread.setName("test_thread_1");
        thread.setDaemon(true);
        thread.start(); // 使用 新線程 去執行
//        thread.run(); // 使用主 thread 去執行

        TimeUnit.SECONDS.sleep(1L);
        //second way:
        new ExtendThread("test_thread_2", true).start(); // 使用 新線程 去執行
//        new ExtendThread("test_thread_2", true).run(); // 使用主 thread 去執行

//        TimeUnit.SECONDS.sleep(6);
    }
}
