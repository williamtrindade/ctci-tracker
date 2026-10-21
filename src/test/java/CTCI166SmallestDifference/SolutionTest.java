package CTCI166SmallestDifference;

import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    private final Solution solution = new Solution();

    private static long brute(int[] a, int[] b) {
        long best = Long.MAX_VALUE;
        for (int x : a) {
            for (int y : b) {
                best = Math.min(best, Math.abs((long) x - y));
            }
        }
        return best;
    }

    @Test
    void bookExample() {
        assertEquals(3, solution.findSmallestDifference(new int[]{1, 3, 15, 11, 2}, new int[]{23, 127, 235, 19, 8}));
    }

    @Test
    void edgeCases() {
        assertEquals(0, solution.findSmallestDifference(new int[]{5}, new int[]{5}));
        assertEquals(Long.MAX_VALUE, solution.findSmallestDifference(new int[]{}, new int[]{1}));
        assertEquals(4294967295L, solution.findSmallestDifference(new int[]{Integer.MIN_VALUE}, new int[]{Integer.MAX_VALUE}));
    }

    @Test
    void randomArrays() {
        Random random = new Random(16);
        for (int t = 0; t < 300; t++) {
            int[] a = random.ints(random.nextInt(30) + 1, -1000, 1000).toArray();
            int[] b = random.ints(random.nextInt(30) + 1, -1000, 1000).toArray();
            long expected = brute(a, b);
            assertEquals(expected, solution.findSmallestDifference(a, b));
        }
    }
}
