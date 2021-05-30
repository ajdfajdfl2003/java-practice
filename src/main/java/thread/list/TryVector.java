package thread.list;

import java.util.Vector;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

public class TryVector {
    private static final int loopNum = 100;

    public static void main(String[] args) throws InterruptedException {
        final Vector<String> objects = new Vector<>();
        new Thread(() -> IntStream.range(0, loopNum)
                .forEach(i -> {
                    try {
                        TimeUnit.MILLISECONDS.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    objects.add(i, String.valueOf(i));
                })).start();

        new Thread(() -> IntStream.range(0, loopNum)
                .forEach(i -> {
                    try {
                        TimeUnit.MILLISECONDS.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(objects);
                })).start();

        TimeUnit.SECONDS.sleep(11);
    }
}
