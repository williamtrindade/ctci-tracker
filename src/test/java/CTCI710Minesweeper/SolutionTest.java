package CTCI710Minesweeper;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SolutionTest {

    private static char[][] rows(String... lines) {
        char[][] out = new char[lines.length][];
        for (int i = 0; i < lines.length; i++) {
            out[i] = lines[i].toCharArray();
        }
        return out;
    }

    // Tabuleiro 4x5 com bombas em (1,4) e (3,0):
    //  . . . . .
    //  . . . . *
    //  . . . . .
    //  * . . . .
    private Solution.MinesweeperGame game() {
        return new Solution.MinesweeperGame(4, 5, new int[][]{{1, 4}, {3, 0}});
    }

    @Test
    void initialDisplayIsHidden() {
        assertArrayEquals(rows("?????", "?????", "?????", "?????"), game().display());
    }

    @Test
    void clickingANumberRevealsOnlyThatCell() {
        Solution.MinesweeperGame g = game();
        assertEquals(GameState.RUNNING, g.play(0, 3));
        assertArrayEquals(rows("???1?", "?????", "?????", "?????"), g.display());
    }

    @Test
    void clickingABlankExpandsUntilNumbers() {
        Solution.MinesweeperGame g = game();
        assertEquals(GameState.RUNNING, g.play(0, 0));
        assertArrayEquals(rows(
                "   1?",
                "   1?",
                "11 11",
                "?1   "), g.display());
    }

    @Test
    void winWhenAllSafeCellsExposed() {
        Solution.MinesweeperGame g = game();
        assertEquals(GameState.RUNNING, g.play(0, 0)); // revela tudo menos (0,4) e as bombas
        assertEquals(GameState.WON, g.play(0, 4));
    }

    @Test
    void clickingABombLoses() {
        Solution.MinesweeperGame g = game();
        assertEquals(GameState.LOST, g.play(1, 4));
        assertEquals('*', g.display()[1][4]);
        assertEquals(GameState.LOST, g.play(0, 0), "Depois de perder, as jogadas são ignoradas");
        assertEquals('?', g.display()[0][0]);
    }

    @Test
    void flagsBlockClicks() {
        Solution.MinesweeperGame g = game();
        g.toggleFlag(1, 4);
        assertEquals('F', g.display()[1][4]);
        assertEquals(GameState.RUNNING, g.play(1, 4));
        g.toggleFlag(1, 4);
        assertEquals('?', g.display()[1][4]);
        assertEquals(GameState.LOST, g.play(1, 4));
    }

    @Test
    void randomBombsAreDistinct() {
        int[][] bombs = Solution.MinesweeperGame.randomBombs(10, 10, 30, new Random(3));
        assertEquals(30, bombs.length);
        Set<String> distinct = new HashSet<>();
        for (int[] b : bombs) {
            assertTrue(b[0] >= 0 && b[0] < 10 && b[1] >= 0 && b[1] < 10);
            distinct.add(b[0] + "," + b[1]);
        }
        assertEquals(30, distinct.size());
    }
}
