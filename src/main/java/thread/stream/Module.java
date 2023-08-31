package thread.stream;

import java.util.stream.Stream;

public class Module {
    private final Player player;
    private final BettingClerk bettingClerk;

    public Module(Player player, BettingClerk bettingClerk) {
        this.player = player;
        this.bettingClerk = bettingClerk;
    }

    public synchronized void leave() {
        player.getBetSequences().stream()
                .filter(seq -> bettingClerk.getBet(seq).isPresent())
                .flatMap(gameSeq -> bettingClerk.getBet(gameSeq).map(Stream::of).orElseGet(Stream::empty))
                .filter(PlayerBet::isNotAutoCashOutBet)
                .map(PlayerBet::getConfirmBet)
                .map(GameConfirmBet::getGameSeq)
                .forEach(this::cashOut);
        player.refresh();
    }

    public void cashOut(Long seq) {
        bettingClerk.removeIfPresent(seq);
    }
}
