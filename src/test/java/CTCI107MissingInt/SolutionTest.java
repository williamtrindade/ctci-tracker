package CTCI107MissingInt;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SolutionTest {

    private final Solution solution = new Solution();

    private static int[] allExcept(int range, Set<Integer> missing, Random random) {
        List<Integer> values = new ArrayList<>();
        for (int i = 0; i < range; i++) {
            if (!missing.contains(i)) {
                values.add(i);
            }
        }
        Collections.shuffle(values, random);
        return values.stream().mapToInt(Integer::intValue).toArray();
    }

    @Test
    void singleMissingNumber() {
        Random random = new Random(1);
        for (int missing : new int[]{0, 7, 8, 500, 99_999}) {
            int[] numbers = allExcept(100_000, Set.of(missing), random);
            assertEquals(missing, solution.findOpenNumber(numbers, 100_000));
            assertEquals(missing, solution.findOpenNumberTwoPass(numbers, 100_000, 1000));
        }
    }

    @Test
    void anyMissingNumberIsAccepted() {
        Random random = new Random(2);
        Set<Integer> missing = new HashSet<>(List.of(3, 50_000, 77_777));
        int[] numbers = allExcept(100_000, missing, random);
        assertTrue(missing.contains(solution.findOpenNumber(numbers, 100_000)));
        assertTrue(missing.contains(solution.findOpenNumberTwoPass(numbers, 100_000, 333)));
    }

    @Test
    void withRepeatedValues() {
        int[] numbers = {0, 0, 1, 1, 2, 4, 4, 4};
        assertEquals(3, solution.findOpenNumber(numbers, 6));
    }

    @Test
    void rangeNotMultipleOfBlockSize() {
        Random random = new Random(3);
        int[] numbers = allExcept(1003, Set.of(1002), random);
        assertEquals(1002, solution.findOpenNumberTwoPass(numbers, 1003, 100));
        assertEquals(1002, solution.findOpenNumber(numbers, 1003));
    }
}
