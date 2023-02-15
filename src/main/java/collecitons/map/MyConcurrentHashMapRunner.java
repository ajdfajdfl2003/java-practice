package collecitons.map;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MyConcurrentHashMapRunner {
    private static final Map<String, String> cache = new ConcurrentHashMap<>();

    public static void main(String[] args) {
        final ExecutorService executorService = Executors.newFixedThreadPool(3);
        executorService.submit(() -> cache.putIfAbsent("ABC", "123"));
        executorService.submit(() -> cache.putIfAbsent("ABC", "ABC"));
        executorService.submit(() -> System.out.println(cache.get("ABC")));
        executorService.shutdown();
    }
}
