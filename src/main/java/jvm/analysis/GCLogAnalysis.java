package jvm.analysis;

import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.LongAdder;

public class GCLogAnalysis {
    private static Random random = new Random();

    public static void main(String[] args) {
        // start time
        long startMillis = System.currentTimeMillis();
        // keep running milliseconds, according to how long you want.
        long timeoutMillis = TimeUnit.SECONDS.toMillis(1);
        // end time
        long endMillis = startMillis + timeoutMillis;
        LongAdder counter = new LongAdder();
        System.out.println("正在執行...");
        // cache few, and break into old generation
        int cacheSize = 2000;
        Object[] cachedGarbage = new Object[cacheSize];
        // keep loop if in time
        while (System.currentTimeMillis() < endMillis) {
            // generate garbage object
            Object garbage = generateGarbage(100 * 1024);
            counter.increment();
            int randomIndex = random.nextInt(2 * cacheSize);
            if (randomIndex < cacheSize) {
                cachedGarbage[randomIndex] = garbage;
            }
        }
        System.out.println("執行結束！ 共生成物件次數：" + counter.longValue());
    }

    private static Object generateGarbage(int max) {
        int randomSize = random.nextInt(max);
        int type = randomSize % 4;
        Object result = null;
        switch (type) {
            case 0:
                result = new int[randomSize];
                break;
            case 1:
                result = new byte[randomSize];
                break;
            case 2:
                result = new double[randomSize];
                break;
            default:
                StringBuilder builder = new StringBuilder();
                String randomString = "randomString-Anything";
                while (builder.length() < randomSize) {
                    builder.append(randomString);
                    builder.append(max);
                    builder.append(randomSize);
                }
                result = builder.toString();
                break;
        }
        return result;
    }
}
