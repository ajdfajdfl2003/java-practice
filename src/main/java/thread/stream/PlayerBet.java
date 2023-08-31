package thread.stream;

import lombok.Data;

@Data
public class PlayerBet {
    GameConfirmBet confirmBet;
    long autoCashOutMultiple = 0;

    public PlayerBet(GameConfirmBet confirmBet) {
        this.confirmBet = confirmBet;
    }

    public boolean isNotAutoCashOutBet() {
        return autoCashOutMultiple == 0;
    }
}
