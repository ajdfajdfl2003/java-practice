import org.apache.commons.collections4.queue.CircularFifoQueue;
import practice.MyCircularFifoQueue;

import java.util.Queue;

public class CircularFifoQueueDemo {
    static Queue<String> queue = new CircularFifoQueue<String>(18);

    public static void main(String[] args) {
        MyCircularFifoQueue myQueue = new MyCircularFifoQueue(queue);

        long startTime = System.nanoTime();

        for (int i = 0; i < 10000; i++) {
            myQueue.write(i);
            myQueue.read();
        }

        long endTime = System.nanoTime();
        System.out.printf("CircularFifoQueue execute usec = %d\n", (endTime - startTime) / 1_000L);
    }
}
