package practice;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Queue;

public class MyCircularFifoQueue {
    private Queue queue;

    public MyCircularFifoQueue(Queue queue) {
        this.queue = queue;
    }

    public void write(int element) {
        this.queue.offer(element);
    }

    public void read() {
        System.out.print("Read circular queue: " + new Gson().toJson(new ArrayList(this.queue)) + "\n");
    }
}
