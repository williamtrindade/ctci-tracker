package CTCI17RotateMatrix;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SolutionTest {

    private final Solution solution = new Solution();

    @Test
    void rotates1x1() {
        int[][] m = {{7}};
        assertTrue(solution.rotate(m));
        assertArrayEquals(new int[][]{{7}}, m);
    }

    @Test
    void rotates2x2Clockwise() {
        int[][] m = {
                {1, 2},
                {3, 4}
        };
        assertTrue(solution.rotate(m));
        assertArrayEquals(new int[][]{
                {3, 1},
                {4, 2}
        }, m);
    }

    @Test
    void rotates3x3Clockwise() {
        int[][] m = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        assertTrue(solution.rotate(m));
        assertArrayEquals(new int[][]{
                {7, 4, 1},
                {8, 5, 2},
                {9, 6, 3}
        }, m);
    }

    @Test
    void rotates4x4Clockwise() {
        int[][] m = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}
        };
        assertTrue(solution.rotate(m));
        assertArrayEquals(new int[][]{
                {13, 9, 5, 1},
                {14, 10, 6, 2},
                {15, 11, 7, 3},
                {16, 12, 8, 4}
        }, m);
    }

    @Test
    void fourRotationsReturnToOriginal() {
        int n = 5;
        int[][] m = new int[n][n];
        int[][] original = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                m[i][j] = original[i][j] = i * n + j;
            }
        }
        for (int k = 0; k < 4; k++) {
            assertTrue(solution.rotate(m));
        }
        assertArrayEquals(original, m);
    }

    @Test
    void emptyMatrixReturnsFalse() {
        assertFalse(solution.rotate(new int[0][0]));
    }

    @Test
    void nonSquareMatrixReturnsFalseAndIsUnchanged() {
        int[][] m = {{1, 2, 3}, {4, 5, 6}};
        assertFalse(solution.rotate(m));
        assertArrayEquals(new int[][]{{1, 2, 3}, {4, 5, 6}}, m);
    }
}
