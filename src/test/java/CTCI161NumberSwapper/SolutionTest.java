package CTCI161NumberSwapper;

import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class SolutionTest {

    private final Solution solution = new Solution();

    @Test
    void swaps() {
        assertArrayEquals(new int[]{5, 9}, solution.swap(9, 5));
        assertArrayEquals(new int[]{-3, 0}, solution.swap(0, -3));
        assertArrayEquals(new int[]{7, 7}, solution.swap(7, 7));
    }

    @Test
    void overflowCases() {
        assertArrayEquals(new int[]{-1, Integer.MAX_VALUE}, solution.swap(Integer.MAX_VALUE, -1));
        assertArrayEquals(new int[]{Integer.MAX_VALUE, Integer.MIN_VALUE}, solution.swap(Integer.MIN_VALUE, Integer.MAX_VALUE));
    }

    @Test
    void randomValues() {
        Random random = new Random(1);
        for (int t = 0; t < 1000; t++) {
            int a = random.nextInt();
            int b = random.nextInt();
            assertArrayEquals(new int[]{b, a}, solution.swap(a, b));
        }
    }
}
