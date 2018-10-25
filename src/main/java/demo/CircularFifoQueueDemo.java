package demo;

import com.google.common.collect.EvictingQueue;
import org.apache.commons.collections4.queue.CircularFifoQueue;
import practice.MyQueue;

import java.util.Queue;

public class CircularFifoQueueDemo {
    static Queue<String> circularFifoQueue = new CircularFifoQueue<String>(18);
    static Queue<String> evictingQueue = EvictingQueue.create(18);

    public static void main(String[] args) {
        doCircularFifoQueue();

        doEvictingQueue();
    }

    private static void doEvictingQueue() {
        MyQueue myQueue = new MyQueue(evictingQueue);

        long startTime = System.nanoTime();

        for (int i = 0; i < 100; i++) {
            myQueue.write(i);
            myQueue.read();
        }

        long endTime = System.nanoTime();
        System.out.printf("EvictingQueue execute usec = %d\n", (endTime - startTime) / 1_000L);
    }

    private static void doCircularFifoQueue() {
        MyQueue myQueue = new MyQueue(circularFifoQueue);

        long startTime = System.nanoTime();

        for (int i = 0; i < 100; i++) {
            myQueue.write(i);
            myQueue.read();
        }

        long endTime = System.nanoTime();
        System.out.printf("CircularFifoQueue execute usec = %d\n", (endTime - startTime) / 1_000L);
    }
}
