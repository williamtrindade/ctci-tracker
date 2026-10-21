package CTCI167NumberMax;

import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    private final Solution solution = new Solution();

    @Test
    void examples() {
        assertEquals(5, solution.getMax(5, 3));
        assertEquals(5, solution.getMax(3, 5));
        assertEquals(-1, solution.getMax(-1, -9));
        assertEquals(0, solution.getMax(0, 0));
    }

    @Test
    void overflowCases() {
        assertEquals(Integer.MAX_VALUE, solution.getMax(Integer.MAX_VALUE, -15));
        assertEquals(Integer.MAX_VALUE, solution.getMax(-15, Integer.MAX_VALUE));
        assertEquals(1, solution.getMax(Integer.MIN_VALUE, 1));
        assertEquals(Integer.MAX_VALUE, solution.getMax(Integer.MIN_VALUE, Integer.MAX_VALUE));
    }

    @Test
    void randomValues() {
        Random random = new Random(7);
        for (int t = 0; t < 10_000; t++) {
            int a = random.nextInt();
            int b = random.nextInt();
            assertEquals(Math.max(a, b), solution.getMax(a, b));
        }
    }
}
