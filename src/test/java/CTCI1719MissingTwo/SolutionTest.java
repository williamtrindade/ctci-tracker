package CTCI1719MissingTwo;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    private final Solution solution = new Solution();

    private static int[] without(int n, Random random, int... missing) {
        List<Integer> list = new ArrayList<>();
        outer:
        for (int i = 1; i <= n; i++) {
            for (int m : missing) {
                if (i == m) {
                    continue outer;
                }
            }
            list.add(i);
        }
        Collections.shuffle(list, random);
        return list.stream().mapToInt(Integer::intValue).toArray();
    }

    @Test
    void oneMissing() {
        Random random = new Random(1);
        for (int n = 1; n <= 60; n++) {
            for (int m = 1; m <= n; m++) {
                assertEquals(m, solution.missingOne(without(n, random, m)));
            }
        }
    }

    @Test
    void twoMissing() {
        Random random = new Random(2);
        for (int n = 2; n <= 40; n++) {
            for (int a = 1; a <= n; a++) {
                for (int b = a + 1; b <= n; b++) {
                    assertArrayEquals(new int[]{a, b}, solution.missingTwo(without(n, random, a, b)), "n=" + n);
                }
            }
        }
    }

    @Test
    void largeNWithoutOverflow() {
        Random random = new Random(3);
        int n = 200_000;
        assertEquals(123_456, solution.missingOne(without(n, random, 123_456)));
        assertArrayEquals(new int[]{1, 200_000}, solution.missingTwo(without(n, random, 1, 200_000)));
    }
}
