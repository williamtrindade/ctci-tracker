package CTCI1723MaxBlackSquare;

import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SolutionTest {

    private final Solution solution = new Solution();

    private static boolean bordersBlack(int[][] m, int r, int c, int size) {
        for (int k = 0; k < size; k++) {
            if (m[r][c + k] != 1 || m[r + size - 1][c + k] != 1 || m[r + k][c] != 1 || m[r + k][c + size - 1] != 1) {
                return false;
            }
        }
        return true;
    }

    private static int bruteSize(int[][] m) {
        int n = m.length;
        for (int size = n; size >= 1; size--) {
            for (int r = 0; r + size <= n; r++) {
                for (int c = 0; c + size <= n; c++) {
                    if (bordersBlack(m, r, c, size)) {
                        return size;
                    }
                }
            }
        }
        return 0;
    }

    private void check(int[][] m) {
        Subsquare s = solution.findSquare(m);
        int expected = bruteSize(m);
        if (expected == 0) {
            assertNull(s);
            return;
        }
        assertNotNull(s);
        assertEquals(expected, s.size());
        assertTrue(bordersBlack(m, s.row(), s.column(), s.size()), "Bordas não são todas pretas: " + s);
    }

    @Test
    void example() {
        int[][] m = {
                {1, 0, 1, 1, 1},
                {0, 1, 1, 0, 1},
                {1, 1, 0, 0, 1},
                {0, 1, 1, 1, 1},
                {1, 0, 0, 1, 0}
        };
        check(m);
    }

    @Test
    void edgeCases() {
        check(new int[][]{{0, 0}, {0, 0}});
        check(new int[][]{{1}});
        check(new int[][]{{1, 1}, {1, 1}});
        check(new int[][]{{1, 1, 1}, {1, 0, 1}, {1, 1, 1}}); // interior branco é permitido
    }

    @Test
    void randomMatrices() {
        Random random = new Random(1723);
        for (int t = 0; t < 300; t++) {
            int n = random.nextInt(9) + 1;
            int[][] m = new int[n][n];
            for (int r = 0; r < n; r++) {
                for (int c = 0; c < n; c++) {
                    m[r][c] = random.nextInt(4) == 0 ? 0 : 1;
                }
            }
            check(m);
        }
    }
}
