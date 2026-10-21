package CTCI1718ShortestSupersequence;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SolutionTest {

    private final Solution solution = new Solution();

    private static boolean containsAll(int[] big, int start, int end, int[] small) {
        Set<Integer> window = new HashSet<>();
        for (int i = start; i <= end; i++) {
            window.add(big[i]);
        }
        for (int s : small) {
            if (!window.contains(s)) {
                return false;
            }
        }
        return true;
    }

    private static int bruteLength(int[] big, int[] small) {
        int best = -1;
        for (int i = 0; i < big.length; i++) {
            for (int j = i; j < big.length; j++) {
                if (containsAll(big, i, j, small) && (best < 0 || j - i + 1 < best)) {
                    best = j - i + 1;
                }
            }
        }
        return best;
    }

    private void check(int[] big, int[] small) {
        int[] result = solution.shortestSupersequence(big, small);
        int expected = bruteLength(big, small);
        if (expected < 0) {
            assertNull(result);
            return;
        }
        assertNotNull(result);
        assertTrue(containsAll(big, result[0], result[1], small));
        assertEquals(expected, result[1] - result[0] + 1);
    }

    @Test
    void bookExample() {
        int[] big = {7, 5, 9, 0, 2, 1, 3, 5, 7, 9, 1, 1, 5, 8, 8, 9, 7};
        assertArrayEquals(new int[]{7, 10}, solution.shortestSupersequence(big, new int[]{1, 5, 9}));
    }

    @Test
    void notFound() {
        assertNull(solution.shortestSupersequence(new int[]{1, 2, 3}, new int[]{4}));
    }

    @Test
    void randomArrays() {
        Random random = new Random(1718);
        for (int t = 0; t < 500; t++) {
            int[] big = random.ints(random.nextInt(30) + 1, 0, 6).toArray();
            int[] small = random.ints(0, 6).distinct().limit(random.nextInt(3) + 1).toArray();
            check(big, small);
        }
    }
}
