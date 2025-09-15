package leetcode.minimize_string_length;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SolutionTest {
    @Test
    public void case_3() {
        assertThat(new Solution().minimizedStringLength("baadccab"))
                .isEqualTo(4);
    }

    @Test
    public void case_2() {
        assertThat(new Solution().minimizedStringLength("cbbd"))
                .isEqualTo(3);
    }

    @Test
    public void case_1() {
        assertThat(new Solution().minimizedStringLength("aaabc"))
                .isEqualTo(3);
    }
}