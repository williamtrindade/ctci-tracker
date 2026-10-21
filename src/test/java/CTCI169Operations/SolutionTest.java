package CTCI169Operations;

import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class SolutionTest {

    private final Solution solution = new Solution();

    @Test
    void subtract() {
        assertEquals(3, solution.subtract(10, 7));
        assertEquals(-3, solution.subtract(7, 10));
        assertEquals(17, solution.subtract(10, -7));
        assertEquals(0, solution.subtract(-5, -5));
    }

    @Test
    void multiply() {
        assertEquals(42, solution.multiply(6, 7));
        assertEquals(-42, solution.multiply(-6, 7));
        assertEquals(-42, solution.multiply(6, -7));
        assertEquals(42, solution.multiply(-6, -7));
        assertEquals(0, solution.multiply(0, 123));
    }

    @Test
    void divide() {
        assertEquals(3, solution.divide(10, 3));
        assertEquals(-3, solution.divide(-10, 3));
        assertEquals(-3, solution.divide(10, -3));
        assertEquals(3, solution.divide(-10, -3));
        assertEquals(0, solution.divide(2, 5));
        assertThrows(ArithmeticException.class, () -> solution.divide(1, 0));
    }

    @Test
    void randomValues() {
        Random random = new Random(9);
        for (int t = 0; t < 2000; t++) {
            int a = random.nextInt(20_001) - 10_000;
            int b = random.nextInt(20_001) - 10_000;
            assertEquals(a - b, solution.subtract(a, b));
            assertEquals(a * b, solution.multiply(a, b));
            if (b != 0) {
                assertEquals(a / b, solution.divide(a, b), a + " / " + b);
            }
        }
    }
}
