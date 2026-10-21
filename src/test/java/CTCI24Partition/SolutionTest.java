package CTCI24Partition;

import common.ListNode;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SolutionTest {

    private final Solution solution = new Solution();

    private void assertPartitioned(int[] input, int x) {
        List<Integer> result = ListNode.toList(solution.partition(ListNode.of(input), x));
        // mesmos valores
        List<Integer> expectedSorted = new ArrayList<>();
        for (int v : input) {
            expectedSorted.add(v);
        }
        List<Integer> actualSorted = new ArrayList<>(result);
        Collections.sort(expectedSorted);
        Collections.sort(actualSorted);
        assertEquals(expectedSorted, actualSorted, "A lista deve conter os mesmos valores");
        // todos os < x antes dos >= x
        boolean seenRight = false;
        for (int v : result) {
            if (v >= x) {
                seenRight = true;
            } else {
                assertTrue(!seenRight, () -> "Valor " + v + " < " + x + " apareceu depois de um valor >= x: " + result);
            }
        }
    }

    @Test
    void bookExample() {
        assertPartitioned(new int[]{3, 5, 8, 5, 10, 2, 1}, 5);
    }

    @Test
    void allSmallerOrAllBigger() {
        assertPartitioned(new int[]{1, 2, 3}, 10);
        assertPartitioned(new int[]{5, 6, 7}, 1);
    }

    @Test
    void singleNodeAndEmpty() {
        assertPartitioned(new int[]{4}, 4);
        assertNull(solution.partition(null, 3));
    }

    @Test
    void randomLists() {
        Random random = new Random(42);
        for (int t = 0; t < 50; t++) {
            int[] values = random.ints(random.nextInt(20) + 1, 0, 10).toArray();
            assertPartitioned(values, random.nextInt(10));
        }
    }
}
