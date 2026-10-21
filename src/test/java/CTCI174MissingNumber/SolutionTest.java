package CTCI174MissingNumber;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SolutionTest {

    private final Solution solution = new Solution();

    private static List<BitInteger> withMissing(int n, int missing, Random random) {
        List<BitInteger> list = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            if (i != missing) {
                list.add(new BitInteger(i));
            }
        }
        Collections.shuffle(list, random);
        return list;
    }

    @Test
    void smallArrays() {
        Random random = new Random(1);
        for (int n = 1; n <= 40; n++) {
            for (int missing = 0; missing <= n; missing++) {
                assertEquals(missing, solution.findMissing(withMissing(n, missing, random)), "n=" + n + " missing=" + missing);
            }
        }
    }

    @Test
    void linearNumberOfFetches() {
        Random random = new Random(2);
        int n = 100_000;
        for (int missing : new int[]{0, 1, 77_777, n}) {
            List<BitInteger> list = withMissing(n, missing, random);
            BitInteger.resetFetchCount();
            assertEquals(missing, solution.findMissing(list));
            long fetches = BitInteger.fetchCount();
            assertTrue(fetches <= 2L * n + 64, "Buscas demais: " + fetches + " (esperado O(n), ~2n)");
        }
    }
}
