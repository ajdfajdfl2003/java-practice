package thread.stream;

import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

public class Storage {
    private final ConcurrentHashMap<String, Module> properties = new ConcurrentHashMap<>();

    public void add(String key, Module module) {
        properties.put(key, module);
    }

    public Optional<Module> get(String key) {
        return Optional.of(properties.get(key));
    }
}
