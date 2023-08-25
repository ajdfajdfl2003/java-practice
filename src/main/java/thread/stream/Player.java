package thread.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class Player {
    private final ConcurrentHashMap<Integer, Long> seqOfPosition = new ConcurrentHashMap<>();

    public void bet(Long seq) {
        seqOfPosition.put(0, seq);
    }

    public List<Long> getBetSequences() {
        return new ArrayList<>(seqOfPosition.values());
    }
}
