package CTCI1716TheMasseuse;

import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    private final Solution solution = new Solution();

    private static int brute(int[] a) {
        int best = 0;
        for (int mask = 0; mask < (1 << a.length); mask++) {
            if ((mask & (mask >> 1)) != 0) {
                continue; // adjacentes
            }
            int sum = 0;
            for (int i = 0; i < a.length; i++) {
                if ((mask & (1 << i)) != 0) {
                    sum += a[i];
                }
            }
            best = Math.max(best, sum);
        }
        return best;
    }

    @Test
    void bookExample() {
        assertEquals(180, solution.maxMinutes(new int[]{30, 15, 60, 75, 45, 15, 15, 45}));
    }

    @Test
    void edgeCases() {
        assertEquals(0, solution.maxMinutes(new int[]{}));
        assertEquals(30, solution.maxMinutes(new int[]{30}));
        assertEquals(45, solution.maxMinutes(new int[]{30, 45}));
        assertEquals(330, solution.maxMinutes(new int[]{75, 105, 120, 75, 90, 135})); // 75 + 120 + 135
    }

    @Test
    void randomRequests() {
        Random random = new Random(1716);
        for (int t = 0; t < 500; t++) {
            int[] a = random.ints(random.nextInt(15), 1, 10).map(x -> x * 15).toArray();
            assertEquals(brute(a), solution.maxMinutes(a));
        }
    }
}
