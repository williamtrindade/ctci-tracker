package CTCI1710MajorityElement;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    private final Solution solution = new Solution();

    private static int brute(int[] a) {
        Map<Integer, Integer> count = new HashMap<>();
        for (int x : a) {
            if (count.merge(x, 1, Integer::sum) > a.length / 2) {
                return x;
            }
        }
        return -1;
    }

    @Test
    void bookExample() {
        assertEquals(5, solution.findMajorityElement(new int[]{1, 2, 5, 9, 5, 9, 5, 5, 5}));
    }

    @Test
    void noMajority() {
        assertEquals(-1, solution.findMajorityElement(new int[]{1, 2, 3}));
        assertEquals(-1, solution.findMajorityElement(new int[]{3, 3, 1, 1}));  // exatamente metade não basta
        assertEquals(-1, solution.findMajorityElement(new int[]{}));
    }

    @Test
    void randomArrays() {
        Random random = new Random(1710);
        for (int t = 0; t < 2000; t++) {
            int[] a = random.ints(random.nextInt(20) + 1, 1, 4).toArray();
            assertEquals(brute(a), solution.findMajorityElement(a));
        }
    }
}
