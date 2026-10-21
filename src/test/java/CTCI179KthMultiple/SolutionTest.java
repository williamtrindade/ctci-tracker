package CTCI179KthMultiple;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    private final Solution solution = new Solution();

    @Test
    void firstNumbers() {
        long[] expected = {1, 3, 5, 7, 9, 15, 21, 25, 27, 35, 45, 49, 63, 75, 81};
        for (int k = 0; k < expected.length; k++) {
            assertEquals(expected[k], solution.getKthMagicNumber(k), "k = " + k);
        }
    }

    @Test
    void matchesBruteForce() {
        List<Long> all = new ArrayList<>();
        long limit = 1_000_000_000L;
        for (long a = 1; a <= limit; a *= 3) {
            for (long b = a; b <= limit; b *= 5) {
                for (long c = b; c <= limit; c *= 7) {
                    all.add(c);
                }
            }
        }
        Collections.sort(all);
        for (int k = 0; k < 400; k++) {
            assertEquals(all.get(k), solution.getKthMagicNumber(k), "k = " + k);
        }
    }

    @Test
    @Timeout(2)
    void largeK() {
        long previous = 0;
        for (int k = 0; k < 2000; k += 100) {
            long v = solution.getKthMagicNumber(k);
            assertEquals(true, v > previous);
            previous = v;
        }
    }
}
