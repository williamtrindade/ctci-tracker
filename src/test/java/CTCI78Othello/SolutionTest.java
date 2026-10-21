package CTCI78Othello;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SolutionTest {

    @Test
    void initialBoard() {
        Solution.Othello game = new Solution.Othello();
        assertEquals(Color.WHITE, game.getColor(3, 3));
        assertEquals(Color.WHITE, game.getColor(4, 4));
        assertEquals(Color.BLACK, game.getColor(3, 4));
        assertEquals(Color.BLACK, game.getColor(4, 3));
        assertNull(game.getColor(0, 0));
        assertEquals(2, game.getScoreForColor(Color.WHITE));
        assertEquals(2, game.getScoreForColor(Color.BLACK));
        assertTrue(game.hasValidMove(Color.BLACK));
    }

    @Test
    void validMoveCapturesHorizontally() {
        Solution.Othello game = new Solution.Othello();
        // Preta em (3,2): captura a branca (3,3) porque (3,4) é preta
        assertTrue(game.placeColor(3, 2, Color.BLACK));
        assertEquals(Color.BLACK, game.getColor(3, 3));
        assertEquals(4, game.getScoreForColor(Color.BLACK));
        assertEquals(1, game.getScoreForColor(Color.WHITE));
    }

    @Test
    void validMoveCapturesVertically() {
        Solution.Othello game = new Solution.Othello();
        // Branca em (2,4): captura a preta (3,4) porque (4,4) é branca
        assertTrue(game.placeColor(2, 4, Color.WHITE));
        assertEquals(Color.WHITE, game.getColor(3, 4));
        assertEquals(4, game.getScoreForColor(Color.WHITE));
    }

    @Test
    void invalidMovesChangeNothing() {
        Solution.Othello game = new Solution.Othello();
        assertFalse(game.placeColor(3, 3, Color.BLACK)); // ocupada
        assertFalse(game.placeColor(0, 0, Color.BLACK)); // não captura
        assertFalse(game.placeColor(2, 2, Color.BLACK)); // só diagonal (não conta)
        assertFalse(game.placeColor(-1, 3, Color.BLACK)); // fora do tabuleiro
        assertFalse(game.placeColor(3, 2, Color.WHITE)); // vizinha é da mesma cor
        assertEquals(2, game.getScoreForColor(Color.WHITE));
        assertEquals(2, game.getScoreForColor(Color.BLACK));
    }

    @Test
    void afterTwoMovesThereAreSixPieces() {
        Solution.Othello game = new Solution.Othello();
        assertTrue(game.placeColor(3, 2, Color.BLACK));  // linha 3: B B B B
        assertTrue(game.placeColor(2, 2, Color.WHITE) || game.placeColor(4, 2, Color.WHITE));
        int white = game.getScoreForColor(Color.WHITE);
        int black = game.getScoreForColor(Color.BLACK);
        assertEquals(6, white + black);
    }

    @Test
    void noValidMoveWhenColorHasNoPiecesToCapture() {
        Solution.Othello game = new Solution.Othello();
        assertTrue(game.placeColor(3, 2, Color.BLACK)); // brancas: só (4,4)
        assertTrue(game.placeColor(4, 5, Color.BLACK)); // captura (4,4) -> brancas: 0
        assertEquals(0, game.getScoreForColor(Color.WHITE));
        assertFalse(game.hasValidMove(Color.WHITE));
        assertFalse(game.hasValidMove(Color.BLACK));
    }
}
