package CTCI811Coins;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    private final Solution solution = new Solution();

    @Test
    void smallAmounts() {
        assertEquals(1, solution.makeChange(0));
        assertEquals(1, solution.makeChange(1));
        assertEquals(1, solution.makeChange(4));
        assertEquals(2, solution.makeChange(5));
        assertEquals(4, solution.makeChange(10));
        assertEquals(6, solution.makeChange(15));
        assertEquals(13, solution.makeChange(25));
        assertEquals(242, solution.makeChange(100));
    }

    @Test
    @Timeout(3)
    void largeAmounts() {
        assertEquals(1463, solution.makeChange(200));
        assertEquals(142511, solution.makeChange(1000));
        assertEquals(134235101, solution.makeChange(10_000));
    }
}
