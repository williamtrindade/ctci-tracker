package CTCI1611DivingBoard;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SolutionTest {

    private final Solution solution = new Solution();

    @Test
    void examples() {
        assertEquals(Set.of(3, 4, 5, 6), solution.allLengths(3, 1, 2));
        assertEquals(Set.of(4, 5), solution.allLengths(1, 4, 5));
        assertEquals(Set.of(6), solution.allLengths(3, 2, 2));
        assertTrue(solution.allLengths(0, 1, 2).isEmpty());
    }

    @Test
    @Timeout(2)
    void manyPlanksMustBeFast() {
        Set<Integer> lengths = solution.allLengths(10_000, 3, 7);
        assertEquals(10_001, lengths.size());
        assertTrue(lengths.contains(30_000));
        assertTrue(lengths.contains(70_000));
    }
}
