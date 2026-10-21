package CTCI1715LongestWord;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SolutionTest {

    private final Solution solution = new Solution();

    /** A palavra pode ser formada por 2+ palavras do conjunto? */
    private static boolean composite(String w, Set<String> dict) {
        int n = w.length();
        int[] pieces = new int[n + 1]; // pieces[i] = máximo de pedaços para formar w[0..i), -1 = impossível
        Arrays.fill(pieces, -1);
        pieces[0] = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                if (pieces[j] >= 0 && dict.contains(w.substring(j, i))) {
                    pieces[i] = Math.max(pieces[i], pieces[j] + 1);
                }
            }
        }
        return pieces[n] >= 2;
    }

    private void check(String[] words) {
        Set<String> dict = new HashSet<>(Arrays.asList(words));
        int best = 0;
        for (String w : words) {
            if (composite(w, dict)) {
                best = Math.max(best, w.length());
            }
        }
        String result = solution.printLongestWord(words);
        assertEquals(best, result.length(), "Tamanho da maior palavra composta");
        if (best > 0) {
            assertTrue(dict.contains(result) && composite(result, dict), result);
        }
    }

    @Test
    void bookExample() {
        assertEquals("dogwalker", solution.printLongestWord(new String[]{"cat", "banana", "dog", "nana", "walk", "walker",
                "dogwalker"}));
    }

    @Test
    void repeatedWordsAndNoAnswer() {
        assertEquals("catcatcat", solution.printLongestWord(new String[]{"cat", "catcatcat", "dog"}));
        assertEquals("", solution.printLongestWord(new String[]{"cat", "dog", "bird"}));
        check(new String[]{"a", "b", "ab", "abc", "bc", "abcd"});
    }

    @Test
    @Timeout(5)
    void manyWords() {
        String[] words = new String[2000];
        for (int i = 0; i < words.length; i++) {
            words[i] = "w" + i;
        }
        words[1999] = "w1w2w3w4w5w6w7w8w9w10";
        check(words);
        assertEquals("w1w2w3w4w5w6w7w8w9w10", solution.printLongestWord(words));
    }
}
