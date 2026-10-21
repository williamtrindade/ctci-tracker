package CTCI85RecursiveMultiply;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    private final Solution solution = new Solution();

    @Test
    void examples() {
        assertEquals(0, solution.minProduct(0, 5));
        assertEquals(0, solution.minProduct(5, 0));
        assertEquals(7, solution.minProduct(1, 7));
        assertEquals(56, solution.minProduct(7, 8));
        assertEquals(56, solution.minProduct(8, 7));
        assertEquals(1_000_000, solution.minProduct(1000, 1000));
    }

    @Test
    @Timeout(2)
    void randomProducts() {
        Random random = new Random(9);
        for (int t = 0; t < 100_000; t++) {
            int a = random.nextInt(46_000);
            int b = random.nextInt(46_000);
            assertEquals(a * b, solution.minProduct(a, b));
        }
    }

    @Test
    @Timeout(2)
    void hugeFactorsMustBeFast() {
        assertEquals(2_000_000_000, solution.minProduct(2, 1_000_000_000));
        assertEquals(2_147_395_600, solution.minProduct(46_340, 46_340));
        for (int i = 0; i < 1_000_000; i++) {
            solution.minProduct(1_000_000, 2_000);
        }
    }
}
