package CTCI113ChessTest;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SolutionTest {

    private final Solution solution = new Solution();

    @Test
    void extremeCasesOffBoard() {
        for (PieceType type : PieceType.values()) {
            assertFalse(solution.canMoveTo(type, 0, 0, -1, 0), type.name());
            assertFalse(solution.canMoveTo(type, 7, 7, 8, 7), type.name());
            assertFalse(solution.canMoveTo(type, 3, 3, 3, Integer.MAX_VALUE), type.name());
            assertFalse(solution.canMoveTo(type, -1, 0, 0, 0), type.name());
        }
    }

    @Test
    void cannotStayInPlace() {
        for (PieceType type : PieceType.values()) {
            assertFalse(solution.canMoveTo(type, 4, 4, 4, 4), type.name());
        }
    }

    @Test
    void king() {
        assertTrue(solution.canMoveTo(PieceType.KING, 4, 4, 5, 5));
        assertTrue(solution.canMoveTo(PieceType.KING, 0, 0, 0, 1));
        assertFalse(solution.canMoveTo(PieceType.KING, 4, 4, 6, 4));
    }

    @Test
    void rookBishopQueen() {
        assertTrue(solution.canMoveTo(PieceType.ROOK, 0, 0, 0, 7));
        assertTrue(solution.canMoveTo(PieceType.ROOK, 0, 0, 7, 0));
        assertFalse(solution.canMoveTo(PieceType.ROOK, 0, 0, 1, 1));
        assertTrue(solution.canMoveTo(PieceType.BISHOP, 0, 0, 7, 7));
        assertTrue(solution.canMoveTo(PieceType.BISHOP, 7, 0, 0, 7));
        assertFalse(solution.canMoveTo(PieceType.BISHOP, 0, 0, 0, 7));
        assertTrue(solution.canMoveTo(PieceType.QUEEN, 3, 3, 3, 0));
        assertTrue(solution.canMoveTo(PieceType.QUEEN, 3, 3, 6, 6));
        assertFalse(solution.canMoveTo(PieceType.QUEEN, 3, 3, 4, 5));
    }

    @Test
    void knight() {
        int count = 0;
        for (int x = 0; x < 8; x++) {
            for (int y = 0; y < 8; y++) {
                if (solution.canMoveTo(PieceType.KNIGHT, 4, 4, x, y)) {
                    count++;
                }
            }
        }
        assertEquals(8, count, "Cavalo no centro tem 8 destinos");
        int corner = 0;
        for (int x = 0; x < 8; x++) {
            for (int y = 0; y < 8; y++) {
                if (solution.canMoveTo(PieceType.KNIGHT, 0, 0, x, y)) {
                    corner++;
                }
            }
        }
        assertEquals(2, corner, "Cavalo no canto tem 2 destinos");
    }

    @Test
    void queenFromCenterCount() {
        int count = 0;
        for (int x = 0; x < 8; x++) {
            for (int y = 0; y < 8; y++) {
                if (solution.canMoveTo(PieceType.QUEEN, 3, 3, x, y)) {
                    count++;
                }
            }
        }
        assertEquals(27, count);
    }
}
