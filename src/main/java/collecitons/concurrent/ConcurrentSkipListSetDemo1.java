package collecitons.concurrent;

import lombok.Value;

import java.time.Duration;
import java.time.Instant;
import java.util.Comparator;
import java.util.Set;
import java.util.concurrent.ConcurrentSkipListSet;

public class ConcurrentSkipListSetDemo1 {
    @Value
    static class Result {
        long win;
        String seq;
    }

    // TODO: set是TreeSet对象时，程序会出错。
    //private static Set<String> set = new TreeSet<String>();
//    private static Set<Result> set = new ConcurrentSkipListSet<>(Comparator.comparingLong(Result::getWin).reversed());
    private static Set<Long> set = new ConcurrentSkipListSet<>(Comparator.reverseOrder());
//    private static List<Result> set = new CopyOnWriteArrayList<>();

    public static void main(String[] args) {

        // 同时启动两个线程对set进行操作！
        new MyThread("a").start();
        new MyThread("b").start();
    }

    private static void printAll() {
        Long value = null;
        for (Long result : set) {
            value = result;
            System.out.print(Thread.currentThread().getName() + ": " + value + ", ");
        }
        System.out.println();
    }

    private static class MyThread extends Thread {
        MyThread(String name) {
            super(name);
        }

        @Override
        public void run() {
            int i = 0;
            Instant start = Instant.now();
            System.out.println("Thread start " + Thread.currentThread().getName() + ", time: " + start);
            while (i++ < 10000) {
                set.add((long) (Math.random() * 100000L));
                System.out.println(Thread.currentThread().getName() + ", size: " + set.size());
            }

//            printAll();
            System.out.println("Thread start " + Thread.currentThread().getName() + ", cost: " + Duration.between(start, Instant.now()).toMillis());
        }
    }
}
