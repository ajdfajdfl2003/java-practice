package demo;

import org.junit.Test;

import java.util.Arrays;

public class TwoSumTest {

    @Test
    public void numbers_are_3_2_4() {
        System.out.println(Arrays.toString(TwoSum.twoSum(new int[]{1, 4, 7, 23, 9}, 10)));
    }
}