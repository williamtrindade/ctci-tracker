package CTCI63Dominos;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SolutionTest {

    private final Solution solution = new Solution();

    private static boolean[][] fullBoard(int rows, int cols) {
        boolean[][] b = new boolean[rows][cols];
        for (boolean[] row : b) {
            java.util.Arrays.fill(row, true);
        }
        return b;
    }

    @Test
    void fullChessboardCanBeTiled() {
        assertTrue(solution.canBeTiled(fullBoard(8, 8)));
    }

    @Test
    void bookQuestionDiagonallyOppositeCornersRemoved() {
        boolean[][] b = fullBoard(8, 8);
        b[0][0] = false;
        b[7][7] = false;
        assertFalse(solution.canBeTiled(b));
    }

    @Test
    void adjacentCornersRemovedCanBeTiled() {
        boolean[][] b = fullBoard(8, 8);
        b[0][0] = false;
        b[0][7] = false; // cores diferentes
        assertTrue(solution.canBeTiled(b));
    }

    @Test
    void oddNumberOfSquares() {
        assertFalse(solution.canBeTiled(fullBoard(3, 3)));
    }

    @Test
    void sameColorCountsButStillImpossible() {
        // 1x4 sem os dois quadrados do meio: um branco e um preto, mas não adjacentes
        boolean[][] b = {{true, false, false, true}};
        assertFalse(solution.canBeTiled(b));
    }

    @Test
    void irregularShapes() {
        // formato em L (4 casas): coberto por um dominó vertical e um horizontal
        boolean[][] l = {
                {true, false},
                {true, false},
                {true, true}
        };
        assertTrue(solution.canBeTiled(l));
        // 5 casas: número ímpar
        boolean[][] l2 = {
                {true, false},
                {true, true},
                {true, true}
        };
        assertFalse(solution.canBeTiled(l2));
        boolean[][] zigzag = {
                {true, true, false},
                {false, true, true}
        };
        assertTrue(solution.canBeTiled(zigzag));
        // anel 3x3 sem o centro
        boolean[][] ring = {
                {true, true, true},
                {true, false, true},
                {true, true, true}
        };
        assertTrue(solution.canBeTiled(ring));
    }

    @Test
    void connectedBalancedButImpossible() {
        // 3 brancas e 3 pretas, conexo, mas (0,1) e (1,0) só podem se emparelhar com (1,1)
        boolean[][] b = {
                {false, true, false},
                {true, true, false},
                {false, true, true},
                {false, true, false}
        };
        assertFalse(solution.canBeTiled(b));
    }

    @Test
    void emptyBoard() {
        assertTrue(solution.canBeTiled(new boolean[0][0]));
    }
}
