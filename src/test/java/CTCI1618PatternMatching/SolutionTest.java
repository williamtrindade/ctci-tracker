package CTCI1618PatternMatching;

import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SolutionTest {

    private final Solution solution = new Solution();

    /** Força bruta: tenta todos os tamanhos não vazios para a e b. */
    private static boolean brute(String pattern, String value) {
        if (pattern.isEmpty()) {
            return value.isEmpty();
        }
        for (int la = 1; la <= value.length(); la++) {
            for (int lb = 1; lb <= value.length(); lb++) {
                String a = null;
                String b = null;
                int i = 0;
                boolean ok = true;
                for (char c : pattern.toCharArray()) {
                    int len = c == 'a' ? la : lb;
                    if (i + len > value.length()) {
                        ok = false;
                        break;
                    }
                    String piece = value.substring(i, i + len);
                    if (c == 'a') {
                        if (a == null) {
                            a = piece;
                        } else if (!a.equals(piece)) {
                            ok = false;
                            break;
                        }
                    } else {
                        if (b == null) {
                            b = piece;
                        } else if (!b.equals(piece)) {
                            ok = false;
                            break;
                        }
                    }
                    i += len;
                }
                if (ok && i == value.length()) {
                    return true;
                }
            }
        }
        return false;
    }

    @Test
    void bookExamples() {
        String value = "catcatgocatgo";
        assertTrue(solution.doesMatch("aabab", value));
        assertTrue(solution.doesMatch("a", value));
        assertTrue(solution.doesMatch("ab", value));
        assertTrue(solution.doesMatch("b", value));
    }

    @Test
    void nonMatches() {
        assertFalse(solution.doesMatch("aa", "catdog"));
        assertFalse(solution.doesMatch("aba", "catdogdog"));
        assertFalse(solution.doesMatch("aaaa", "catcatcat"));
        assertFalse(solution.doesMatch("ab", "x"));
        assertFalse(solution.doesMatch("a", ""));
    }

    @Test
    void patternStartingWithB() {
        assertTrue(solution.doesMatch("baab", "dogcatcatdog"));
        assertTrue(solution.doesMatch("bba", "gogocat"));
        assertTrue(solution.doesMatch("", ""));
    }

    @Test
    void randomCasesMatchBruteForce() {
        Random random = new Random(18);
        for (int t = 0; t < 3000; t++) {
            StringBuilder pattern = new StringBuilder();
            for (int i = 0; i < random.nextInt(5) + 1; i++) {
                pattern.append(random.nextBoolean() ? 'a' : 'b');
            }
            StringBuilder value = new StringBuilder();
            for (int i = 0; i < random.nextInt(9); i++) {
                value.append(random.nextBoolean() ? 'x' : 'y');
            }
            assertEquals(brute(pattern.toString(), value.toString()),
                    solution.doesMatch(pattern.toString(), value.toString()), pattern + " / " + value);
        }
    }
}
