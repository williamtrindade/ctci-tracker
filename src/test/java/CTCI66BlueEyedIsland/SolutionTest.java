package CTCI66BlueEyedIsland;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class SolutionTest {

    private final Solution solution = new Solution();

    @Test
    void closedForm() {
        assertEquals(1, solution.daysToLeave(1));
        assertEquals(2, solution.daysToLeave(2));
        assertEquals(37, solution.daysToLeave(37));
        assertThrows(IllegalArgumentException.class, () -> solution.daysToLeave(0));
    }

    @Test
    void simulation() {
        assertEquals(1, solution.simulate(new boolean[]{true, false, false}));
        assertEquals(2, solution.simulate(new boolean[]{true, false, true, false}));
        assertEquals(3, solution.simulate(new boolean[]{true, true, true}));
        boolean[] island = new boolean[100];
        for (int i = 0; i < 100; i += 4) {
            island[i] = true; // 25 pessoas de olhos azuis
        }
        assertEquals(25, solution.simulate(island));
    }
}
