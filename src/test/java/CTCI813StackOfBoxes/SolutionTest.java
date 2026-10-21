package CTCI813StackOfBoxes;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    private final Solution solution = new Solution();

    /** Força bruta: testa todos os subconjuntos. */
    private static int brute(List<Box> boxes) {
        int best = 0;
        int n = boxes.size();
        for (int mask = 0; mask < (1 << n); mask++) {
            List<Box> chosen = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                if ((mask & (1 << i)) != 0) {
                    chosen.add(boxes.get(i));
                }
            }
            chosen.sort((a, b) -> b.width() - a.width());
            boolean ok = true;
            int height = 0;
            for (int i = 0; i < chosen.size(); i++) {
                if (i > 0 && !chosen.get(i - 1).canBeUnder(chosen.get(i))) {
                    ok = false;
                    break;
                }
                height += chosen.get(i).height();
            }
            if (ok) {
                best = Math.max(best, height);
            }
        }
        return best;
    }

    @Test
    void examples() {
        assertEquals(0, solution.createStack(List.of()));
        assertEquals(5, solution.createStack(List.of(new Box(1, 5, 1))));
        // (3,3,3) sobre (4,4,4) sobre (5,5,5) = 12; (6,1,6) não cabe com ninguém (altura 1)
        assertEquals(12, solution.createStack(List.of(new Box(3, 3, 3), new Box(6, 1, 6), new Box(5, 5, 5), new Box(4, 4, 4))));
        // empates em uma dimensão não podem ser empilhados
        assertEquals(10, solution.createStack(List.of(new Box(5, 5, 5), new Box(5, 10, 4))));
    }

    @Test
    void randomBoxesMatchBruteForce() {
        Random random = new Random(13);
        for (int t = 0; t < 200; t++) {
            List<Box> boxes = new ArrayList<>();
            for (int i = 0; i < random.nextInt(10) + 1; i++) {
                boxes.add(new Box(random.nextInt(8) + 1, random.nextInt(8) + 1, random.nextInt(8) + 1));
            }
            assertEquals(brute(boxes), solution.createStack(boxes), boxes.toString());
        }
    }

    @Test
    @Timeout(3)
    void manyBoxes() {
        List<Box> boxes = new ArrayList<>();
        for (int i = 1; i <= 2000; i++) {
            boxes.add(new Box(i, i, i));
        }
        assertEquals(2000 * 2001 / 2, solution.createStack(boxes));
    }
}
