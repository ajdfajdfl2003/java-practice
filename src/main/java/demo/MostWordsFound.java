package demo;

import java.util.Arrays;

public class MostWordsFound {
    public int mostWordsFound(String[] sentences) {
        return Arrays.stream(sentences)
                .map(String::trim)
                .mapToInt(s -> (int) Arrays.stream(s.split("\\s+")).count())
                .max().orElse(0);
    }
}
