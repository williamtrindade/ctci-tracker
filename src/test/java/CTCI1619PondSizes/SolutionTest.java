package CTCI1619PondSizes;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    private final Solution solution = new Solution();

    private List<Integer> sorted(List<Integer> list) {
        List<Integer> copy = new ArrayList<>(list);
        Collections.sort(copy);
        return copy;
    }

    @Test
    void bookExample() {
        int[][] land = {
                {0, 2, 1, 0},
                {0, 1, 0, 1},
                {1, 1, 0, 1},
                {0, 1, 0, 1}
        };
        assertEquals(List.of(1, 2, 4), sorted(solution.computePondSizes(land)));
    }

    @Test
    void diagonalConnections() {
        int[][] land = {
                {0, 1, 1},
                {1, 0, 1},
                {1, 1, 0}
        };
        assertEquals(List.of(3), solution.computePondSizes(land));
    }

    @Test
    void noWaterAndAllWater() {
        assertEquals(List.of(), solution.computePondSizes(new int[][]{{1, 2}, {3, 4}}));
        assertEquals(List.of(4), solution.computePondSizes(new int[][]{{0, 0}, {0, 0}}));
    }

    @Test
    void doesNotModifyInput() {
        int[][] land = {{0, 1}, {1, 0}};
        solution.computePondSizes(land);
        assertEquals(0, land[0][0]);
        assertEquals(0, land[1][1]);
    }

    @Test
    @Timeout(5)
    void largeLake() {
        int[][] land = new int[800][800];
        assertEquals(List.of(640_000), solution.computePondSizes(land));
    }
}
