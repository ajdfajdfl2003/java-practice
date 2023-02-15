package demo;

import java.util.Arrays;
import java.util.stream.Collectors;

public class MostWordsFound {
    public int mostWordsFound(String[] sentences) {
        return Arrays.stream(sentences)
                .map(String::trim)
                .map(s -> (int) Arrays.stream(s.split("\\s+")).count())
                .max(Integer::compareTo).orElse(0);
    }
}
