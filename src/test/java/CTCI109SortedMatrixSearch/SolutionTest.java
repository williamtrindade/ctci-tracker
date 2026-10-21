package CTCI109SortedMatrixSearch;

import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

class SolutionTest {

    private final Solution solution = new Solution();

    private void assertFinds(int[][] m, int x) {
        boolean present = false;
        for (int[] row : m) {
            for (int v : row) {
                present |= v == x;
            }
        }
        int[] result = solution.findElement(m, x);
        if (present) {
            assertNotNull(result, "Deveria encontrar " + x);
            assertEquals(x, m[result[0]][result[1]]);
        } else {
            assertNull(result, x + " não está na matriz");
        }
    }

    @Test
    void bookStyleMatrix() {
        int[][] m = {
                {15, 20, 40, 85},
                {20, 35, 80, 95},
                {30, 55, 95, 105},
                {40, 80, 100, 120}
        };
        for (int x = 0; x <= 130; x++) {
            assertFinds(m, x);
        }
    }

    @Test
    void emptyAndSingle() {
        assertNull(solution.findElement(new int[0][0], 1));
        assertFinds(new int[][]{{5}}, 5);
        assertFinds(new int[][]{{5}}, 6);
    }

    @Test
    void randomSortedMatrices() {
        Random random = new Random(5);
        for (int t = 0; t < 100; t++) {
            int rows = random.nextInt(8) + 1;
            int cols = random.nextInt(8) + 1;
            int[][] m = new int[rows][cols];
            for (int r = 0; r < rows; r++) {
                for (int c = 0; c < cols; c++) {
                    int up = r > 0 ? m[r - 1][c] : 0;
                    int left = c > 0 ? m[r][c - 1] : 0;
                    m[r][c] = Math.max(up, left) + random.nextInt(3);
                }
            }
            for (int x = -1; x <= m[rows - 1][cols - 1] + 1; x++) {
                assertFinds(m, x);
            }
        }
    }
}
