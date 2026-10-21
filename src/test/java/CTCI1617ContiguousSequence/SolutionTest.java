package CTCI1617ContiguousSequence;

import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    private final Solution solution = new Solution();

    private static int brute(int[] a) {
        int best = 0;
        for (int i = 0; i < a.length; i++) {
            int sum = 0;
            for (int j = i; j < a.length; j++) {
                sum += a[j];
                best = Math.max(best, sum);
            }
        }
        return best;
    }

    @Test
    void bookExample() {
        assertEquals(5, solution.getMaxSum(new int[]{2, -8, 3, -2, 4, -10}));
    }

    @Test
    void edgeCases() {
        assertEquals(0, solution.getMaxSum(new int[]{-3, -1, -2}));
        assertEquals(0, solution.getMaxSum(new int[]{}));
        assertEquals(10, solution.getMaxSum(new int[]{1, 2, 3, 4}));
        assertEquals(7, solution.getMaxSum(new int[]{5, -1, 3}));
    }

    @Test
    void randomArrays() {
        Random random = new Random(17);
        for (int t = 0; t < 1000; t++) {
            int[] a = random.ints(random.nextInt(30), -20, 20).toArray();
            assertEquals(brute(a), solution.getMaxSum(a));
        }
    }
}
