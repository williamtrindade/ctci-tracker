package CTCI108FindDuplicates;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SolutionTest {

    private final Solution solution = new Solution();

    @Test
    void reportsEachRepetitionInOrder() {
        assertEquals(List.of(2, 1, 1), solution.checkDuplicates(new int[]{1, 2, 3, 2, 1, 4, 1}));
        assertTrue(solution.checkDuplicates(new int[]{5, 4, 3, 2, 1}).isEmpty());
        assertTrue(solution.checkDuplicates(new int[0]).isEmpty());
    }

    @Test
    void extremes() {
        assertEquals(List.of(32_000, 1), solution.checkDuplicates(new int[]{1, 32_000, 32_000, 1}));
    }

    @Test
    void randomArray() {
        Random random = new Random(1);
        int[] array = random.ints(50_000, 1, 32_001).toArray();
        Set<Integer> seen = new HashSet<>();
        List<Integer> expected = new ArrayList<>();
        for (int x : array) {
            if (!seen.add(x)) {
                expected.add(x);
            }
        }
        assertEquals(expected, solution.checkDuplicates(array));
    }
}
