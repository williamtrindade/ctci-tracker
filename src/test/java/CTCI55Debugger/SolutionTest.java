package CTCI55Debugger;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SolutionTest {

    private final Solution solution = new Solution();

    @Test
    void expressionMatchesTheBookCode() {
        for (int n = -1000; n <= 5000; n++) {
            assertEquals((n & (n - 1)) == 0, solution.expression(n), "n = " + n);
        }
        assertTrue(solution.expression(0));
        assertTrue(solution.expression(Integer.MIN_VALUE));
    }

    @Test
    void powersOfTwo() {
        for (int i = 0; i < 31; i++) {
            assertTrue(solution.isPowerOfTwo(1 << i), "2^" + i);
        }
    }

    @Test
    void notPowersOfTwo() {
        assertFalse(solution.isPowerOfTwo(0));
        assertFalse(solution.isPowerOfTwo(3));
        assertFalse(solution.isPowerOfTwo(6));
        assertFalse(solution.isPowerOfTwo(1023));
        assertFalse(solution.isPowerOfTwo(-4));
        assertFalse(solution.isPowerOfTwo(Integer.MIN_VALUE));
    }
}
