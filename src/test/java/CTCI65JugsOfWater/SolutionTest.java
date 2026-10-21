package CTCI65JugsOfWater;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SolutionTest {

    private final Solution solution = new Solution();

    private static List<String> legalMoves(int[] s, int capA, int capB) {
        int a = s[0];
        int b = s[1];
        int ab = Math.min(a, capB - b);
        int ba = Math.min(b, capA - a);
        List<String> moves = new ArrayList<>();
        for (int[] n : new int[][]{{capA, b}, {a, capB}, {0, b}, {a, 0}, {a - ab, b + ab}, {a + ba, b - ba}}) {
            moves.add(n[0] + "," + n[1]);
        }
        return moves;
    }

    private void assertValid(List<int[]> steps, int capA, int capB, int target) {
        assertNotNull(steps);
        assertArrayEquals(new int[]{0, 0}, steps.get(0), "Deve começar com os jarros vazios");
        for (int i = 1; i < steps.size(); i++) {
            int[] prev = steps.get(i - 1);
            int[] cur = steps.get(i);
            assertTrue(legalMoves(prev, capA, capB).contains(cur[0] + "," + cur[1]),
                    "Movimento inválido: " + prev[0] + "," + prev[1] + " -> " + cur[0] + "," + cur[1]);
        }
        int[] last = steps.get(steps.size() - 1);
        assertTrue(last[0] == target || last[1] == target, "O último estado deve ter " + target + " litros");
    }

    @Test
    void bookQuestionFiveAndThreeToFour() {
        List<int[]> steps = solution.solve(5, 3, 4);
        assertValid(steps, 5, 3, 4);
        assertEquals(7, steps.size(), "A menor solução tem 6 operações (7 estados)");
    }

    @Test
    void otherTargets() {
        for (int target = 1; target <= 5; target++) {
            assertValid(solution.solve(5, 3, target), 5, 3, target);
        }
        assertValid(solution.solve(7, 4, 6), 7, 4, 6);
    }

    @Test
    void zeroTargetIsTheStart() {
        List<int[]> steps = solution.solve(5, 3, 0);
        assertEquals(1, steps.size());
    }

    @Test
    void impossible() {
        assertNull(solution.solve(6, 4, 3));  // mdc(6, 4) = 2 não divide 3
        assertNull(solution.solve(5, 3, 6));  // maior que os dois jarros
    }
}
