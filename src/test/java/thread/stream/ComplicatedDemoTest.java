package thread.stream;

import org.junit.Test;

public class ComplicatedDemoTest {
    static Player player = new Player();
    static BettingClerk bettingClerk = new BettingClerk();

    @Test
    public void null_pointer_exception() {
        player.bet(1123L);
        bettingClerk.receiveBet(1123L);
        System.out.println(player.getBetSequences());
        new Thread(() -> {
            try {
                player.getBetSequences().stream()
                        .filter(seq -> bettingClerk.getBet(seq).isNotAutoCashOutBet())
                        .forEach(ComplicatedDemoTest::cashOut);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(() -> {
            try {
                player.getBetSequences().stream()
                        .filter(seq -> bettingClerk.getBet(seq).isNotAutoCashOutBet())
                        .forEach(ComplicatedDemoTest::cashOut);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }).start();
        player.getBetSequences().stream()
                .filter(seq -> bettingClerk.getBet(seq).isNotAutoCashOutBet())
                .forEach(ComplicatedDemoTest::cashOut);
    }

    static void cashOut(Long seq) {
        bettingClerk.removeIfPresent(seq);
    }
}
