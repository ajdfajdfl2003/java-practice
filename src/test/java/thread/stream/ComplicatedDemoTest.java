package thread.stream;

import org.junit.Test;

public class ComplicatedDemoTest {
    static Player player = new Player();
    static BettingClerk bettingClerk = new BettingClerk();
    static Module module = new Module(player, bettingClerk);
    static Storage storage = new Storage();

    @Test
    public void null_pointer_exception() {
        storage.add("key", module);
        player.bet(1123L);
        bettingClerk.receiveBet(1123L);
        System.out.println(player.getBetSequences());
        new Thread(() -> storage.get("key").ifPresent(m -> m.cashOut(1123L))).start();
        new Thread(() -> storage.get("key").ifPresent(Module::leave)).start();
        new Thread(() -> storage.get("key").ifPresent(Module::leave)).start();
        storage.get("key").ifPresent(Module::leave);
    }
}
