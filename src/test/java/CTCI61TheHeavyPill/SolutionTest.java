package CTCI61TheHeavyPill;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    private final Solution solution = new Solution();

    @Test
    void findsTheHeavyBottleAmongTwenty() {
        for (int heavy = 0; heavy < 20; heavy++) {
            assertEquals(heavy, solution.findHeavyBottle(new Scale(20, heavy), 20), "frasco pesado = " + heavy);
        }
    }

    @Test
    void worksForOtherBottleCounts() {
        for (int n : new int[]{1, 2, 5, 50}) {
            for (int heavy = 0; heavy < n; heavy++) {
                assertEquals(heavy, solution.findHeavyBottle(new Scale(n, heavy), n));
            }
        }
    }
}
