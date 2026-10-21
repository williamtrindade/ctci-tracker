package CTCI810PaintFill;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SolutionTest {

    private final Solution solution = new Solution();

    @Test
    void fillsConnectedRegion() {
        int[][] screen = {
                {1, 1, 1, 2},
                {1, 2, 1, 2},
                {1, 1, 2, 2},
                {2, 1, 1, 1}
        };
        assertTrue(solution.paintFill(screen, 0, 0, 9));
        assertArrayEquals(new int[][]{
                {9, 9, 9, 2},
                {9, 2, 9, 2},
                {9, 9, 2, 2},
                {2, 9, 9, 9}
        }, screen);
    }

    @Test
    void diagonalsAreNotConnected() {
        int[][] screen = {
                {1, 2},
                {2, 1}
        };
        assertTrue(solution.paintFill(screen, 0, 0, 3));
        assertArrayEquals(new int[][]{{3, 2}, {2, 1}}, screen);
    }

    @Test
    void sameColorReturnsFalse() {
        int[][] screen = {{5, 5}, {5, 5}};
        assertFalse(solution.paintFill(screen, 1, 1, 5));
        assertArrayEquals(new int[][]{{5, 5}, {5, 5}}, screen);
    }

    @Test
    @Timeout(5)
    void largeScreen() {
        int[][] screen = new int[1000][1000];
        assertTrue(solution.paintFill(screen, 500, 500, 7));
        for (int[] row : screen) {
            for (int v : row) {
                if (v != 7) {
                    throw new AssertionError("Pixel não pintado");
                }
            }
        }
    }
}
