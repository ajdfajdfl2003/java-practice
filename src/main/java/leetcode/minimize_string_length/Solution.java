package leetcode.minimize_string_length;

import java.util.stream.Collectors;

public class Solution {
    public int minimizedStringLength(String s) {
        return s.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.toSet()).size();
    }
}
