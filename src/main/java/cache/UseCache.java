package cache;

import com.google.gson.Gson;

public class UseCache {
    public static void main(String[] args) {
        final MyCache myCache = new MyCache();

        System.out.println(new Gson().toJson(myCache.get("TB", 0)));
        System.out.println(new Gson().toJson(myCache.getAll()));
    }
}
