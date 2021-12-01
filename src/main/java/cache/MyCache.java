package cache;


import com.github.benmanes.caffeine.cache.Caffeine;
import com.github.benmanes.caffeine.cache.LoadingCache;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class MyCache {
    DB db = new DB();
    LoadingCache<String, Setting> cache = Caffeine.newBuilder()
            .refreshAfterWrite(5, TimeUnit.SECONDS)
//            .expireAfterWrite(30, TimeUnit.SECONDS)
            .build(this::loadDB);

    private Setting loadDB(String key) {
        return db.get(key);
    }

    public Setting get(String currency, int type) {
        return cache.get(currency + "_" + type);
    }

    public List<Setting> getAll() {
        return null;
    }
}
