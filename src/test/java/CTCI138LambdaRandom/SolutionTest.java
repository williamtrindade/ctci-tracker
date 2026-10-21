package CTCI138LambdaRandom;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SolutionTest {

    private final Solution solution = new Solution();

    @Test
    void resultIsASubsequence() {
        Random random = new Random(1);
        List<Integer> list = List.of(1, 2, 3, 4, 5, 6, 7);
        for (int t = 0; t < 1000; t++) {
            List<Integer> subset = solution.getRandomSubset(list, random);
            int last = 0;
            for (int x : subset) {
                assertTrue(x > last, "Ordem deve ser preservada e sem repetição: " + subset);
                last = x;
            }
        }
    }

    @Test
    void allSubsetsAreEquallyLikely() {
        Random random = new Random(2024);
        List<Integer> list = List.of(1, 2, 3);
        Map<List<Integer>, Integer> counts = new HashMap<>();
        int samples = 160_000;
        for (int i = 0; i < samples; i++) {
            counts.merge(solution.getRandomSubset(list, random), 1, Integer::sum);
        }
        assertEquals(8, counts.size(), "Os 8 subconjuntos devem aparecer (incluindo o vazio)");
        double expected = samples / 8.0;
        counts.forEach((subset, count) ->
                assertTrue(Math.abs(count - expected) < expected * 0.05, subset + " apareceu " + count + " vezes"));
    }
}
