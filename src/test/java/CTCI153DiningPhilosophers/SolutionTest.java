package CTCI153DiningPhilosophers;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    @Test
    @Timeout(20)
    void everybodyEatsWithoutDeadlock() throws Exception {
        for (int n : new int[]{2, 5, 10}) {
            MealLog log = new MealLog();
            new Solution.DiningTable(n, log).dine(5000);
            assertEquals(n * 5000, log.totalMeals(), "n = " + n);
            assertEquals(0, log.violations(), "Alguém comeu sem segurar os dois hashis");
        }
    }
}
