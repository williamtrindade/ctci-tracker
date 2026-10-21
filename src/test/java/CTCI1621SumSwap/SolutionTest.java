package CTCI1621SumSwap;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SolutionTest {

    private final Solution solution = new Solution();

    private static boolean exists(int[] a, int[] b) {
        long sa = Arrays.stream(a).asLongStream().sum();
        long sb = Arrays.stream(b).asLongStream().sum();
        for (int x : a) {
            for (int y : b) {
                if (sa - x + y == sb - y + x) {
                    return true;
                }
            }
        }
        return false;
    }

    private void check(int[] a, int[] b) {
        int[] result = solution.findSwapValues(a, b);
        if (!exists(a, b)) {
            assertNull(result);
            return;
        }
        assertNotNull(result);
        assertTrue(Arrays.stream(a).anyMatch(v -> v == result[0]), "O primeiro valor deve ser de A");
        assertTrue(Arrays.stream(b).anyMatch(v -> v == result[1]), "O segundo valor deve ser de B");
        long sa = Arrays.stream(a).asLongStream().sum();
        long sb = Arrays.stream(b).asLongStream().sum();
        assertEquals(sa - result[0] + result[1], sb - result[1] + result[0]);
    }

    @Test
    void bookExample() {
        check(new int[]{4, 1, 2, 1, 1, 2}, new int[]{3, 6, 3, 3});
    }

    @Test
    void noSolution() {
        assertNull(solution.findSwapValues(new int[]{1, 2}, new int[]{4}));       // diferença ímpar
        assertNull(solution.findSwapValues(new int[]{2, 2}, new int[]{4, 4, 4, 4})); // diferença par, mas sem valores
    }

    @Test
    void randomArrays() {
        Random random = new Random(21);
        for (int t = 0; t < 500; t++) {
            check(random.ints(random.nextInt(8) + 1, -5, 10).toArray(), random.ints(random.nextInt(8) + 1, -5, 10).toArray());
        }
    }
}
