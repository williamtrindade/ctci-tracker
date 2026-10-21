package CTCI1622LangtonsAnt;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    private final Solution solution = new Solution();

    @Test
    void zeroMoves() {
        AntState s = solution.simulate(0);
        assertEquals(Set.of(), s.blackCells());
        assertEquals(new Position(0, 0), s.ant());
        assertEquals(Orientation.RIGHT, s.orientation());
    }

    @Test
    void firstMoves() {
        AntState s1 = solution.simulate(1);
        assertEquals(Set.of(new Position(0, 0)), s1.blackCells());
        assertEquals(new Position(1, 0), s1.ant());
        assertEquals(Orientation.DOWN, s1.orientation());

        AntState s4 = solution.simulate(4);
        assertEquals(Set.of(new Position(0, 0), new Position(1, 0), new Position(1, -1), new Position(0, -1)), s4.blackCells());
        assertEquals(new Position(0, 0), s4.ant());
        assertEquals(Orientation.RIGHT, s4.orientation());

        // 5º passo: (0,0) é preta -> vira branca, gira à esquerda (UP) e anda
        AntState s5 = solution.simulate(5);
        assertEquals(Set.of(new Position(1, 0), new Position(1, -1), new Position(0, -1)), s5.blackCells());
        assertEquals(new Position(-1, 0), s5.ant());
        assertEquals(Orientation.UP, s5.orientation());
    }

    @Test
    @Timeout(5)
    void eachStepFollowsTheRules() {
        // Compara simulate(k + 1) com um passo aplicado manualmente sobre simulate(k)
        for (int k = 0; k < 300; k += 7) {
            AntState before = solution.simulate(k);
            AntState after = solution.simulate(k + 1);
            Set<Position> blacks = new HashSet<>(before.blackCells());
            Orientation o;
            if (blacks.contains(before.ant())) {
                blacks.remove(before.ant());
                o = before.orientation().turnCounterClockwise();
            } else {
                blacks.add(before.ant());
                o = before.orientation().turnClockwise();
            }
            Position p = before.ant();
            Position next = switch (o) {
                case UP -> new Position(p.row() - 1, p.col());
                case DOWN -> new Position(p.row() + 1, p.col());
                case LEFT -> new Position(p.row(), p.col() - 1);
                case RIGHT -> new Position(p.row(), p.col() + 1);
            };
            assertEquals(blacks, after.blackCells(), "k = " + k);
            assertEquals(next, after.ant(), "k = " + k);
            assertEquals(o, after.orientation(), "k = " + k);
        }
    }

    @Test
    @Timeout(5)
    void manyMovesAreFast() {
        AntState s = solution.simulate(1_000_000);
        assertEquals(s.blackCells().size(), new HashSet<>(s.blackCells()).size());
    }
}
