package demo;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SlotBetServiceTest {

    @Test
    public void case_2() {
        long[] credits = {3, 4, 6, 8};
        long[] denoms = {5, 15, 25};
        long min = 30;
        long max = 200;

        assertThat(new SlotBetService().getSlotGameBetList(credits, denoms, min, max))
                .containsExactly(30L, 40L, 45L, 60L, 75L, 90L, 100L, 120L, 150L, 200L);
    }

    @Test
    public void case_1() {
        long[] credits = {1, 2, 5};
        long[] denoms = {10, 20};
        long min = 15;
        long max = 50;

        assertThat(new SlotBetService().getSlotGameBetList(credits, denoms, min, max))
                .containsExactly(20L, 40L, 50L);
    }
}
