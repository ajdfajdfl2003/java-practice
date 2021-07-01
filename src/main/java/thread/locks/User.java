package thread.locks;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class User {
    private Map<String, Object> property = new ConcurrentHashMap<>();

    public Object getProperty(String key) {
        return property.get(key);
    }

    public void setProperty(String key, Object value) {
        this.property.put(key, value);
    }
}
