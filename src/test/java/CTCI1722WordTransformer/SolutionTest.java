package CTCI1722WordTransformer;

import org.junit.jupiter.api.Test;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SolutionTest {

    private final Solution solution = new Solution();

    private static boolean oneLetterApart(String a, String b) {
        if (a.length() != b.length()) {
            return false;
        }
        int diff = 0;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) {
                diff++;
            }
        }
        return diff == 1;
    }

    private static int shortest(String start, String stop, Set<String> words) {
        Map<String, Integer> dist = new HashMap<>();
        Queue<String> q = new ArrayDeque<>();
        dist.put(start, 0);
        q.add(start);
        while (!q.isEmpty()) {
            String w = q.poll();
            if (w.equals(stop)) {
                return dist.get(w);
            }
            for (String n : words) {
                if (!dist.containsKey(n) && oneLetterApart(w, n)) {
                    dist.put(n, dist.get(w) + 1);
                    q.add(n);
                }
            }
        }
        return -1;
    }

    private void check(String start, String stop, Set<String> words) {
        List<String> path = solution.transform(start, stop, words);
        int expected = shortest(start, stop, words);
        if (expected < 0) {
            assertTrue(path.isEmpty(), "Não existe caminho");
            return;
        }
        assertEquals(start, path.get(0));
        assertEquals(stop, path.get(path.size() - 1));
        assertEquals(expected, path.size() - 1, "Deve ser o caminho mais curto: " + path);
        for (int i = 1; i < path.size(); i++) {
            assertTrue(words.contains(path.get(i)), path.get(i) + " não está no dicionário");
            assertTrue(oneLetterApart(path.get(i - 1), path.get(i)), path.get(i - 1) + " -> " + path.get(i));
        }
    }

    private final Set<String> dictionary = Set.of("DAMP", "LAMP", "LIMP", "LIME", "LIKE", "DAME", "DIME", "LAME", "CAMP",
            "COMP", "CORP", "COLD", "CORD", "CARD", "WARD", "WORD", "WARM", "WORM", "WORE", "CORE");

    @Test
    void bookExample() {
        List<String> path = solution.transform("DAMP", "LIKE", dictionary);
        assertEquals(5, path.size());
        check("DAMP", "LIKE", dictionary);
    }

    @Test
    void otherPaths() {
        check("COLD", "WARM", dictionary);
        check("CAMP", "LIKE", dictionary);
        check("WORD", "CORE", dictionary);
    }

    @Test
    void noPathAndSameWord() {
        assertTrue(solution.transform("DAMP", "ABCD", Set.of("DAMP", "ABCD")).isEmpty());
        assertEquals(List.of("DAMP"), solution.transform("DAMP", "DAMP", dictionary));
    }
}
