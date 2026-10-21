package CTCI68TheEggDropProblem;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SolutionTest {

    private final Solution solution = new Solution();

    @Test
    void findsEveryBreakingFloorWithAtMost14Drops() {
        int worst = 0;
        for (int n = 1; n <= 100; n++) {
            Building building = new Building(100, n);
            assertEquals(n, solution.findBreakingFloor(building), "N = " + n);
            assertTrue(building.getBrokenEggs() <= 2);
            worst = Math.max(worst, building.getDrops());
        }
        assertTrue(worst <= 14, "Pior caso deve ser no máximo 14 lançamentos, foi " + worst);
    }

    @Test
    void minDrops() {
        assertEquals(14, solution.minDrops(2, 100));
        assertEquals(100, solution.minDrops(1, 100));
        assertEquals(8, solution.minDrops(2, 36));
        assertEquals(9, solution.minDrops(3, 100));
        assertEquals(1, solution.minDrops(2, 1));
        assertEquals(0, solution.minDrops(2, 0));
        assertEquals(7, solution.minDrops(10, 100)); // busca binária: ceil(log2(101))
    }
}
