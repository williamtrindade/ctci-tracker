package CTCI86TowersOfHanoi;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    private final Solution solution = new Solution();

    private void check(int n) {
        int[] moves = new int[1];
        Tower t1 = new Tower("t1", moves);
        Tower t2 = new Tower("t2", moves);
        Tower t3 = new Tower("t3", moves);
        List<Integer> expected = new ArrayList<>();
        for (int disk = n; disk >= 1; disk--) {
            t1.add(disk);
            expected.add(disk);
        }
        solution.moveDisks(n, t1, t3, t2);
        assertEquals(0, t1.size());
        assertEquals(0, t2.size());
        assertEquals(expected, t3.disks());
        assertEquals((1 << n) - 1, moves[0], "Número mínimo de movimentos é 2^n - 1");
    }

    @Test
    void movesAllDisks() {
        for (int n = 0; n <= 15; n++) {
            check(n);
        }
    }
}
