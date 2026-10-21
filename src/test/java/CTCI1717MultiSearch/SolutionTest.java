package CTCI1717MultiSearch;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    private final Solution solution = new Solution();

    private static List<Integer> brute(String big, String small) {
        List<Integer> result = new ArrayList<>();
        for (int i = big.indexOf(small); i >= 0; i = big.indexOf(small, i + 1)) {
            result.add(i);
        }
        return result;
    }

    @Test
    void example() {
        String big = "mississippi";
        String[] smalls = {"is", "ppi", "hi", "sis", "i", "ssippi"};
        Map<String, List<Integer>> result = solution.searchAll(big, smalls);
        assertEquals(List.of(1, 4), result.get("is"));
        assertEquals(List.of(8), result.get("ppi"));
        assertEquals(List.of(), result.get("hi"));
        assertEquals(List.of(3), result.get("sis"));
        assertEquals(List.of(1, 4, 7, 10), result.get("i"));
        assertEquals(List.of(5), result.get("ssippi"));
    }

    @Test
    void overlappingAndPrefixes() {
        Map<String, List<Integer>> result = solution.searchAll("aaaa", new String[]{"a", "aa", "aaa", "b"});
        assertEquals(List.of(0, 1, 2, 3), result.get("a"));
        assertEquals(List.of(0, 1, 2), result.get("aa"));
        assertEquals(List.of(0, 1), result.get("aaa"));
        assertEquals(List.of(), result.get("b"));
    }

    @Test
    @Timeout(5)
    void randomStrings() {
        Random random = new Random(1717);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 20_000; i++) {
            sb.append((char) ('a' + random.nextInt(3)));
        }
        String big = sb.toString();
        String[] smalls = new String[200];
        for (int i = 0; i < smalls.length; i++) {
            int start = random.nextInt(big.length() - 10);
            smalls[i] = big.substring(start, start + 1 + random.nextInt(8));
        }
        Map<String, List<Integer>> result = solution.searchAll(big, smalls);
        for (String s : smalls) {
            assertEquals(brute(big, s), result.get(s), s);
        }
    }
}
