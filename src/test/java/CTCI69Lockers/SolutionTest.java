package CTCI69Lockers;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    private final Solution solution = new Solution();

    private static List<Integer> simulate(int n) {
        boolean[] open = new boolean[n + 1];
        for (int pass = 1; pass <= n; pass++) {
            for (int locker = pass; locker <= n; locker += pass) {
                open[locker] = !open[locker];
            }
        }
        List<Integer> result = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (open[i]) {
                result.add(i);
            }
        }
        return result;
    }

    @Test
    void bookQuestion() {
        assertEquals(10, solution.countOpenLockers(100));
        assertEquals(List.of(1, 4, 9, 16, 25, 36, 49, 64, 81, 100), solution.openLockers(100));
    }

    @Test
    void matchesSimulation() {
        for (int n = 1; n <= 300; n++) {
            List<Integer> expected = simulate(n);
            assertEquals(expected, solution.openLockers(n), "n = " + n);
            assertEquals(expected.size(), solution.countOpenLockers(n), "n = " + n);
        }
    }
}
