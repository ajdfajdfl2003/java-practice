package cache;

import lombok.Data;

import java.time.Instant;

@Data
public class Setting {
    private String currency;
    private int type;
    private long timestamp;

    public Setting(String currency, int type) {
        this.currency = currency;
        this.type = type;
        this.timestamp = Instant.now().toEpochMilli();
    }
}
