package CTCI1624PairsWithSum;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    private final Solution solution = new Solution();

    private static List<String> normalize(List<int[]> pairs) {
        List<String> out = new ArrayList<>();
        for (int[] p : pairs) {
            out.add(p[0] + "," + p[1]);
        }
        out.sort(null);
        return out;
    }

    /** Número máximo de pares: para v < sum - v, min(cont(v), cont(sum - v)); para v == sum - v, cont(v) / 2. */
    private static List<String> expected(int[] array, int sum) {
        Map<Integer, Integer> count = new HashMap<>();
        for (int x : array) {
            count.merge(x, 1, Integer::sum);
        }
        List<String> out = new ArrayList<>();
        for (int v : count.keySet()) {
            int c = sum - v;
            int pairs = 0;
            if (v < c) {
                pairs = Math.min(count.get(v), count.getOrDefault(c, 0));
            } else if (v == c) {
                pairs = count.get(v) / 2;
            }
            for (int i = 0; i < pairs; i++) {
                out.add(v + "," + c);
            }
        }
        out.sort(null);
        return out;
    }

    @Test
    void example() {
        int[] array = {-2, -1, 0, 3, 5, 6, 7, 9, 13, 14};
        assertEquals(List.of("-1,13", "-2,14", "3,9", "5,7"), normalize(solution.printPairSums(array, 12)));
    }

    @Test
    void duplicates() {
        assertEquals(List.of("1,1", "1,1"), normalize(solution.printPairSums(new int[]{1, 1, 1, 1, 1}, 2)));
        assertEquals(List.of("1,3", "1,3"), normalize(solution.printPairSums(new int[]{1, 3, 1, 3, 1}, 4)));
    }

    @Test
    void randomArrays() {
        Random random = new Random(24);
        for (int t = 0; t < 500; t++) {
            int[] array = random.ints(random.nextInt(30), -10, 10).toArray();
            int sum = random.nextInt(21) - 10;
            assertEquals(expected(array, sum), normalize(solution.printPairSums(array, sum)));
        }
    }
}
