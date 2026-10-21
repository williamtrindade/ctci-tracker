package CTCI56Conversion;

import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    private final Solution solution = new Solution();

    @Test
    void bookExample() {
        assertEquals(2, solution.bitSwapRequired(29, 15));
    }

    @Test
    void edgeCases() {
        assertEquals(0, solution.bitSwapRequired(12345, 12345));
        assertEquals(32, solution.bitSwapRequired(-1, 0));
        assertEquals(1, solution.bitSwapRequired(Integer.MIN_VALUE, 0));
        assertEquals(31, solution.bitSwapRequired(Integer.MAX_VALUE, 0));
    }

    @Test
    void randomNumbers() {
        Random random = new Random(8);
        for (int t = 0; t < 1000; t++) {
            int a = random.nextInt();
            int b = random.nextInt();
            assertEquals(Integer.bitCount(a ^ b), solution.bitSwapRequired(a, b));
        }
    }
}
