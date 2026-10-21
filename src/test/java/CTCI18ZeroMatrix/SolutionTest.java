package CTCI18ZeroMatrix;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class SolutionTest {

    private final Solution solution = new Solution();

    @Test
    void matrixWithoutZerosIsUnchanged() {
        int[][] m = {{1, 2}, {3, 4}};
        solution.setZeros(m);
        assertArrayEquals(new int[][]{{1, 2}, {3, 4}}, m);
    }

    @Test
    void singleZeroInTheMiddle() {
        int[][] m = {
                {1, 2, 3},
                {4, 0, 6},
                {7, 8, 9}
        };
        solution.setZeros(m);
        assertArrayEquals(new int[][]{
                {1, 0, 3},
                {0, 0, 0},
                {7, 0, 9}
        }, m);
    }

    @Test
    void rectangularMatrixWithZeroOnTheBorder() {
        int[][] m = {
                {0, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12}
        };
        solution.setZeros(m);
        assertArrayEquals(new int[][]{
                {0, 0, 0, 0},
                {0, 6, 7, 8},
                {0, 10, 11, 12}
        }, m);
    }

    @Test
    void onlyOriginalZerosPropagate() {
        int[][] m = {
                {1, 1, 1, 1, 1},
                {1, 0, 1, 1, 1},
                {1, 1, 1, 1, 1},
                {1, 1, 1, 0, 1}
        };
        solution.setZeros(m);
        assertArrayEquals(new int[][]{
                {1, 0, 1, 0, 1},
                {0, 0, 0, 0, 0},
                {1, 0, 1, 0, 1},
                {0, 0, 0, 0, 0}
        }, m);
    }

    @Test
    void zeroInLastCell() {
        int[][] m = {
                {1, 2},
                {3, 4},
                {5, 0}
        };
        solution.setZeros(m);
        assertArrayEquals(new int[][]{
                {1, 0},
                {3, 0},
                {0, 0}
        }, m);
    }

    @Test
    void singleRowAndSingleColumn() {
        int[][] row = {{1, 0, 3}};
        solution.setZeros(row);
        assertArrayEquals(new int[][]{{0, 0, 0}}, row);

        int[][] col = {{1}, {0}, {3}};
        solution.setZeros(col);
        assertArrayEquals(new int[][]{{0}, {0}, {0}}, col);
    }
}
