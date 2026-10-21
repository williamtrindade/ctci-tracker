package CTCI164TicTacWin;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    private final Solution solution = new Solution();

    /** 'R' = RED, 'B' = BLUE, '.' = EMPTY */
    private static Piece[][] board(String... rows) {
        Piece[][] b = new Piece[rows.length][rows.length];
        for (int r = 0; r < rows.length; r++) {
            for (int c = 0; c < rows.length; c++) {
                char ch = rows[r].charAt(c);
                b[r][c] = ch == 'R' ? Piece.RED : ch == 'B' ? Piece.BLUE : Piece.EMPTY;
            }
        }
        return b;
    }

    @Test
    void rowsColumnsAndDiagonals() {
        assertEquals(Piece.RED, solution.hasWon(board("RRR", "B.B", "...")));
        assertEquals(Piece.BLUE, solution.hasWon(board("RB.", "RB.", ".BR")));
        assertEquals(Piece.RED, solution.hasWon(board("RB.", "BR.", "..R")));
        assertEquals(Piece.BLUE, solution.hasWon(board("R.B", "RB.", "B..")));
    }

    @Test
    void noWinner() {
        assertEquals(Piece.EMPTY, solution.hasWon(board("...", "...", "...")));
        assertEquals(Piece.EMPTY, solution.hasWon(board("RBR", "RBB", "BRR")));
        assertEquals(Piece.EMPTY, solution.hasWon(board("RR.", "BB.", "...")));
    }

    @Test
    void biggerBoards() {
        assertEquals(Piece.BLUE, solution.hasWon(board("R..B", "R.B.", ".B..", "B..R")));
        assertEquals(Piece.EMPTY, solution.hasWon(board("RRR.", "BBB.", "....", "....")));
        assertEquals(Piece.RED, solution.hasWon(board("..R..", "..R..", "..R..", "..R..", "..R..")));
    }
}
