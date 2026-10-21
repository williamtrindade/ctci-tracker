package CTCI812EightQueens;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SolutionTest {

    private final Solution solution = new Solution();

    private static boolean valid(int[] columns) {
        for (int r1 = 0; r1 < columns.length; r1++) {
            for (int r2 = r1 + 1; r2 < columns.length; r2++) {
                if (columns[r1] == columns[r2] || Math.abs(columns[r1] - columns[r2]) == r2 - r1) {
                    return false;
                }
            }
        }
        return true;
    }

    private void check(int n, int expectedCount) {
        List<int[]> solutions = solution.placeQueens(n);
        assertEquals(expectedCount, solutions.size(), "n = " + n);
        Set<String> distinct = new HashSet<>();
        for (int[] s : solutions) {
            assertEquals(n, s.length);
            assertTrue(valid(s), Arrays.toString(s));
            distinct.add(Arrays.toString(s));
        }
        assertEquals(expectedCount, distinct.size());
    }

    @Test
    void eightQueens() {
        check(8, 92);
    }

    @Test
    void otherSizes() {
        check(1, 1);
        check(2, 0);
        check(3, 0);
        check(4, 2);
        check(5, 10);
        check(6, 4);
    }
}
