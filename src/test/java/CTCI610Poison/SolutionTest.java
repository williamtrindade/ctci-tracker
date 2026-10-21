package CTCI610Poison;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SolutionTest {

    private final Solution solution = new Solution();

    @Test
    void findsAnyPoisonedBottleInSevenDays() {
        for (int poisoned = 0; poisoned < 1000; poisoned++) {
            PoisonLab lab = new PoisonLab(1000, 10, poisoned);
            assertEquals(poisoned, solution.findPoisonedBottle(lab));
            assertTrue(lab.getDaysElapsed() <= 7, "Deve levar no máximo 7 dias, levou " + lab.getDaysElapsed());
        }
    }
}
