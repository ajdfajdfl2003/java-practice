package thread.stream;

import java.time.Instant;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class BettingClerk {
    private final Map<Long, PlayerBet> playerBetBySeq = new ConcurrentHashMap<>();

    public void receiveBet(long seq) {
        playerBetBySeq.put(seq, new PlayerBet(new GameConfirmBet(seq)));
    }

    public PlayerBet getBet(long seq) {
        System.out.println("[getBet] thread: " + Thread.currentThread().getName() + ", time: " + Instant.now());
        return playerBetBySeq.get(seq);
    }

    public void removeIfPresent(Long seq) {
        System.out.println("[removeIfPresent] thread: " + Thread.currentThread().getName() + ", time: " + Instant.now());
        playerBetBySeq.remove(seq);
        System.out.println("[removeIfPresent] thread: " + Thread.currentThread().getName() + ", in bet: " + playerBetBySeq);
    }
}
