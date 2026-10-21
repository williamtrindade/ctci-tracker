package CTCI176CountOf2s;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    private final Solution solution = new Solution();

    private static int count2s(int x) {
        int count = 0;
        while (x > 0) {
            if (x % 10 == 2) {
                count++;
            }
            x /= 10;
        }
        return count;
    }

    @Test
    void bookExample() {
        assertEquals(9, solution.numberOf2sInRange(25));
    }

    @Test
    void matchesBruteForce() {
        int total = 0;
        for (int n = 0; n <= 30_000; n++) {
            total += count2s(n);
            assertEquals(total, solution.numberOf2sInRange(n), "n = " + n);
        }
    }

    @Test
    @Timeout(2)
    void largeValues() {
        assertEquals(600_000, solution.numberOf2sInRange(999_999));
        assertEquals(1_800_000_000, solution.numberOf2sInRange(1_999_999_999)); // 9 posições x 2 * 10^8
    }
}
