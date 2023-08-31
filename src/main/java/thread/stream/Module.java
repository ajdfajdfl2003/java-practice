package thread.stream;

public class Module {
    private final Player player;
    private final BettingClerk bettingClerk;

    public Module(Player player, BettingClerk bettingClerk) {
        this.player = player;
        this.bettingClerk = bettingClerk;
    }

    public synchronized void leave() {
        player.getBetSequences().stream()
                .filter(seq -> bettingClerk.getBet(seq).isNotAutoCashOutBet())
                .forEach(this::cashOut);
        player.refresh();
    }

    public synchronized void cashOut(Long seq) {
        bettingClerk.removeIfPresent(seq);
    }
}
