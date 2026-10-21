package CTCI89Parens;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SolutionTest {

    private final Solution solution = new Solution();

    private static boolean isValid(String s) {
        int balance = 0;
        for (char c : s.toCharArray()) {
            balance += c == '(' ? 1 : -1;
            if (balance < 0) {
                return false;
            }
        }
        return balance == 0;
    }

    @Test
    void bookExample() {
        assertEquals(Set.of("((()))", "(()())", "(())()", "()(())", "()()()"), new HashSet<>(solution.generateParens(3)));
    }

    @Test
    void zeroAndOne() {
        assertEquals(List.of(""), solution.generateParens(0));
        assertEquals(List.of("()"), solution.generateParens(1));
    }

    @Test
    void catalanNumbers() {
        int[] catalan = {1, 1, 2, 5, 14, 42, 132, 429, 1430, 4862, 16796};
        for (int n = 0; n <= 10; n++) {
            List<String> result = solution.generateParens(n);
            assertEquals(catalan[n], result.size(), "n = " + n);
            assertEquals(catalan[n], new HashSet<>(result).size(), "sem duplicatas, n = " + n);
            for (String s : result) {
                assertEquals(2 * n, s.length());
                assertTrue(isValid(s), s);
            }
        }
    }
}
