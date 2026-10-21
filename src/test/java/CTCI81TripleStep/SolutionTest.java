package CTCI81TripleStep;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    private final Solution solution = new Solution();

    @Test
    void smallValues() {
        assertEquals(1, solution.countWays(0));
        assertEquals(1, solution.countWays(1));
        assertEquals(2, solution.countWays(2));
        assertEquals(4, solution.countWays(3));
        assertEquals(7, solution.countWays(4));
        assertEquals(13, solution.countWays(5));
        assertEquals(274, solution.countWays(10));
    }

    @Test
    @Timeout(2)
    void largeValuesMustBeFast() {
        assertEquals(53798080, solution.countWays(30));
        assertEquals(2082876103, solution.countWays(36));
    }
}
