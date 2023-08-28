package thread.stream;

import org.junit.Test;

public class ComplicatedDemoTest {
    static Player player = new Player();
    static BettingClerk bettingClerk = new BettingClerk();
    static Module module = new Module(player, bettingClerk);

    @Test
    public void null_pointer_exception() {
        player.bet(1123L);
        bettingClerk.receiveBet(1123L);
        System.out.println(player.getBetSequences());
        new Thread(() -> {
            module.leave();
        }).start();
        new Thread(() -> {
            module.leave();
        }).start();
        module.leave();
    }

    static void cashOut(Long seq) {
        bettingClerk.removeIfPresent(seq);
    }
}
