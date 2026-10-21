package CTCI1724MaxSubmatrix;

import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SolutionTest {

    private final Solution solution = new Solution();

    private static int sum(int[][] m, int r1, int c1, int r2, int c2) {
        int s = 0;
        for (int r = r1; r <= r2; r++) {
            for (int c = c1; c <= c2; c++) {
                s += m[r][c];
            }
        }
        return s;
    }

    private static int brute(int[][] m) {
        int best = Integer.MIN_VALUE;
        for (int r1 = 0; r1 < m.length; r1++) {
            for (int r2 = r1; r2 < m.length; r2++) {
                for (int c1 = 0; c1 < m[0].length; c1++) {
                    for (int c2 = c1; c2 < m[0].length; c2++) {
                        best = Math.max(best, sum(m, r1, c1, r2, c2));
                    }
                }
            }
        }
        return best;
    }

    private void check(int[][] m) {
        SubMatrix s = solution.getMaxMatrix(m);
        assertEquals(brute(m), s.sum());
        assertTrue(s.rowStart() <= s.rowEnd() && s.colStart() <= s.colEnd());
        assertEquals(s.sum(), sum(m, s.rowStart(), s.colStart(), s.rowEnd(), s.colEnd()), "A soma informada deve bater");
    }

    @Test
    void example() {
        int[][] m = {
                {9, -8, 1, 3, -2},
                {-3, 7, 6, -2, 4},
                {6, -4, -4, 8, -7},
                {12, -5, 3, 9, -5},
                {-1, 2, -3, 1, 2}
        };
        check(m);
    }

    @Test
    void allNegativeAndSingle() {
        check(new int[][]{{-5, -2}, {-3, -9}});
        check(new int[][]{{7}});
        assertNull(solution.getMaxMatrix(new int[0][0]));
    }

    @Test
    void randomMatrices() {
        Random random = new Random(1724);
        for (int t = 0; t < 200; t++) {
            int n = random.nextInt(7) + 1;
            int[][] m = new int[n][n];
            for (int r = 0; r < n; r++) {
                for (int c = 0; c < n; c++) {
                    m[r][c] = random.nextInt(21) - 10;
                }
            }
            check(m);
        }
    }
}
