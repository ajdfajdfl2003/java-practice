package cache;

import java.util.HashMap;
import java.util.Map;

public class DB {
    Map<String, Setting> settings = new HashMap<>();

    {
        settings.put("TB_0", new Setting("TB", 0));
        settings.put("TB_1", new Setting("TB", 1));
        settings.put("RB_0", new Setting("RB", 0));
        settings.put("RB_1", new Setting("RB", 1));
        settings.put("RB_2", new Setting("RB", 2));
    }

    public Setting get(String key) {
        return settings.get(key);
    }
}
