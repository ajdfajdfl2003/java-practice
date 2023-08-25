package thread.stream;

import lombok.Data;

@Data
public class PlayerBet {
    long autoCashOutMultiple = 0;

    public boolean isNotAutoCashOutBet() {
        return autoCashOutMultiple == 0;
    }
}
