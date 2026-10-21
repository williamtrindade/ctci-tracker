package CTCI178CircusTower;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SolutionTest {

    private final Solution solution = new Solution();

    /** Força bruta: maior cadeia por subconjuntos. */
    private static int brute(List<HtWt> items) {
        int n = items.size();
        int best = 0;
        for (int mask = 1; mask < (1 << n); mask++) {
            List<HtWt> chosen = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                if ((mask & (1 << i)) != 0) {
                    chosen.add(items.get(i));
                }
            }
            chosen.sort((a, b) -> a.height() - b.height());
            boolean ok = true;
            for (int i = 1; i < chosen.size() && ok; i++) {
                ok = chosen.get(i - 1).isBefore(chosen.get(i));
            }
            if (ok) {
                best = Math.max(best, chosen.size());
            }
        }
        return best;
    }

    private void assertValidTower(List<HtWt> items, List<HtWt> tower) {
        Map<HtWt, Integer> available = new HashMap<>();
        for (HtWt p : items) {
            available.merge(p, 1, Integer::sum);
        }
        for (int i = 0; i < tower.size(); i++) {
            assertTrue(available.merge(tower.get(i), -1, Integer::sum) >= 0, "Pessoa que não está na entrada: " + tower.get(i));
            if (i > 0) {
                assertTrue(tower.get(i - 1).isBefore(tower.get(i)), "Torre inválida: " + tower);
            }
        }
    }

    @Test
    void bookExample() {
        List<HtWt> items = List.of(new HtWt(65, 100), new HtWt(70, 150), new HtWt(56, 90), new HtWt(75, 190),
                new HtWt(60, 95), new HtWt(68, 110));
        List<HtWt> tower = solution.longestIncreasingSeq(items);
        assertEquals(List.of(new HtWt(56, 90), new HtWt(60, 95), new HtWt(65, 100), new HtWt(68, 110), new HtWt(70, 150),
                new HtWt(75, 190)), tower);
    }

    @Test
    void sameHeightCannotStack() {
        List<HtWt> items = List.of(new HtWt(60, 100), new HtWt(60, 110), new HtWt(65, 90));
        List<HtWt> tower = solution.longestIncreasingSeq(items);
        assertEquals(1, tower.size());
        assertValidTower(items, tower);
    }

    @Test
    void randomPeople() {
        Random random = new Random(178);
        for (int t = 0; t < 200; t++) {
            List<HtWt> items = new ArrayList<>();
            for (int i = 0; i < random.nextInt(10) + 1; i++) {
                items.add(new HtWt(150 + random.nextInt(10), 50 + random.nextInt(10)));
            }
            List<HtWt> tower = solution.longestIncreasingSeq(items);
            assertValidTower(items, tower);
            assertEquals(brute(items), tower.size(), items.toString());
        }
    }
}
