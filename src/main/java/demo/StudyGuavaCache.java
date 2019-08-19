package demo;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

public class StudyGuavaCache {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        playMaxSize();
        playExpireAfterWrite();
        playExpireAfterAccess();
        playLoadingCache();
    }

    private static void playLoadingCache() throws ExecutionException {
        CacheLoader<String, String> loader = new CacheLoader<String, String>() {
            public String load(String key) throws Exception {
                Thread.sleep(1000); //休眠1s，模拟加载数据
                System.out.println(key + " is loaded from a cacheLoader!");
                return key + "'s value";
            }
        };

        LoadingCache<String, String> loadingCache = CacheBuilder.newBuilder()
                                                                .maximumSize(3)
                                                                .build(loader);//在构建时指定自动加载器
        System.out.println(loadingCache.get("key1"));
        System.out.println(loadingCache.get("key2"));
        System.out.println(loadingCache.get("key2"));
        System.out.println(loadingCache.get("key3"));
        System.out.println("==== playLoadingCache End ====");
    }

    private static void playExpireAfterAccess() throws InterruptedException {
        Cache<String, String> cache = CacheBuilder.newBuilder()
                                                  .maximumSize(2)
                                                  .expireAfterAccess(3, TimeUnit.SECONDS)
                                                  .build();
        cache.put("key1", "value1");
        int time = 1;
        while (time < 6) {
            Thread.sleep(time * 1000);
            System.out.println("睡眠" + time++ + "秒后取到key1的值为：" + cache.getIfPresent("key1"));
        }
        System.out.println("==== playExpireAfterAccess End ====");
    }

    private static void playExpireAfterWrite() throws InterruptedException {
        Cache<String, String> cache = CacheBuilder.newBuilder()
                                                  .maximumSize(2)
                                                  .expireAfterWrite(3, TimeUnit.SECONDS)
                                                  .build();
        cache.put("key1", "value1");
        int time = 1;
        while (time < 6) {
            System.out.println("第" + time++ + "次取到key1的值为：" + cache.getIfPresent("key1"));
            Thread.sleep(1000);
        }
        System.out.println("==== playExpireAfterWrite End ====");
    }

    private static void playMaxSize() {
        Cache<String, String> cache = CacheBuilder.newBuilder()
                                                  .maximumSize(2)
                                                  .build();
        System.out.println("put value1 into key1");
        cache.put("key1", "value1");
        System.out.println("第一个值：" + cache.getIfPresent("key1"));

        System.out.println("put value2 into key2");
        cache.put("key2", "value2");
        System.out.println("第一个值：" + cache.getIfPresent("key1"));
        System.out.println("第二个值：" + cache.getIfPresent("key2"));

        System.out.println("put value3 into key3");
        cache.put("key3", "value3");
        System.out.println("第一个值：" + cache.getIfPresent("key1"));
        System.out.println("第二个值：" + cache.getIfPresent("key2"));
        System.out.println("第三个值：" + cache.getIfPresent("key3"));
        System.out.println("==== playMaxSize End ====");
    }
}
