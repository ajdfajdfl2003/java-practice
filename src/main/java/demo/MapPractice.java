package demo;

import java.util.HashMap;
import java.util.Map;

public class MapPractice {
    public static void main(String[] args) throws InterruptedException {
        Map<Integer, Integer> demo = new HashMap<>();

        for (int i = 0; i < 10; i++) {
            demo.put(i, i + 100);
        }

        Thread t1 = new Thread(() -> {
            demo.values().forEach(value -> {
                try {
                    System.out.println("t1 value: " + value);
                    Thread.sleep(800);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        });

        Thread t2 = new Thread(() -> {
            demo.remove(7);
            System.out.println("t2 remove value: " + 7);
        });

        t1.start();

        Thread.sleep(5000);
        t2.start();
    }
}
