package demo;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

public class SlotBetService {
    public List<Long> getSlotGameBetList(long[] credits, long[] denoms, long min, long max) {
        return LongStream.of(credits)
                .boxed()
                .flatMap(credit -> LongStream.of(denoms)
                        .map(denom -> credit * denom)
                        .filter(bet -> bet >= min && bet <= max)
                        .boxed())
                .distinct()
                .sorted()
                .collect(Collectors.toList());
    }
}
