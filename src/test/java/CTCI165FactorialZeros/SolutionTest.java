package CTCI165FactorialZeros;

import org.junit.jupiter.api.Test;

import java.math.BigInteger;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    private final Solution solution = new Solution();

    private static int bruteForce(int n) {
        BigInteger f = BigInteger.ONE;
        for (int i = 2; i <= n; i++) {
            f = f.multiply(BigInteger.valueOf(i));
        }
        String s = f.toString();
        int zeros = 0;
        for (int i = s.length() - 1; i >= 0 && s.charAt(i) == '0'; i--) {
            zeros++;
        }
        return zeros;
    }

    @Test
    void smallValuesMatchBruteForce() {
        for (int n = 0; n <= 300; n++) {
            assertEquals(bruteForce(n), solution.countFactZeros(n), "n = " + n);
        }
    }

    @Test
    void largeValues() {
        assertEquals(249, solution.countFactZeros(1000));
        assertEquals(536870902, solution.countFactZeros(Integer.MAX_VALUE));
        assertEquals(-1, solution.countFactZeros(-5));
    }
}
