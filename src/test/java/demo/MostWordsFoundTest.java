package demo;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MostWordsFoundTest {
    private final MostWordsFound sut = new MostWordsFound();

    @Test
    public void example1() {
        String[] sentences = new String[]{"alice and bob love leetcode", "i think so too", "this is great thanks very much"};
        assertEquals(6, sut.mostWordsFound(sentences));
    }

    @Test
    public void example2() {
        String[] sentences = new String[]{"please wait", "continue to fight", "continue to win"};
        assertEquals(3, sut.mostWordsFound(sentences));
    }


    @Test
    public void extra1_trailing() {
        String[] sentences = new String[]{"alice and bob love leetcode "};
        assertEquals(5, sut.mostWordsFound(sentences));
    }

    @Test
    public void extra2_leading() {
        String[] sentences = new String[]{" alice and bob love leetcode"};
        assertEquals(5, sut.mostWordsFound(sentences));
    }

    @Test
    public void extra3_double_space() {
        String[] sentences = new String[]{"alice  and bob love leetcode"};
        assertEquals(5, sut.mostWordsFound(sentences));
    }
}