package CTCI173RandomSet;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SolutionTest {

    private final Solution solution = new Solution();

    @Test
    void picksDistinctElementsAndKeepsInput() {
        int[] original = {10, 20, 30, 40, 50, 60, 70, 80};
        int[] copy = original.clone();
        Random random = new Random(1);
        for (int t = 0; t < 1000; t++) {
            int[] subset = solution.pickMRandomly(original, 3, random);
            assertEquals(3, subset.length);
            Set<Integer> distinct = new HashSet<>();
            for (int v : subset) {
                distinct.add(v);
                assertTrue(v % 10 == 0 && v >= 10 && v <= 80);
            }
            assertEquals(3, distinct.size(), "Posições distintas (os valores do teste são distintos)");
        }
        assertArrayEquals(copy, original, "O array original não deve mudar");
    }

    @Test
    void eachElementHasEqualProbability() {
        int n = 10;
        int m = 3;
        int[] original = new int[n];
        for (int i = 0; i < n; i++) {
            original[i] = i;
        }
        Random random = new Random(3);
        int[] counts = new int[n];
        int samples = 200_000;
        for (int t = 0; t < samples; t++) {
            for (int v : solution.pickMRandomly(original, m, random)) {
                counts[v]++;
            }
        }
        double expected = samples * (double) m / n;
        for (int i = 0; i < n; i++) {
            assertEquals(expected, counts[i], expected * 0.03, "Elemento " + i);
        }
    }

    @Test
    void mEqualsN() {
        int[] subset = solution.pickMRandomly(new int[]{1, 2, 3}, 3, new Random(1));
        assertEquals(Set.of(1, 2, 3), Set.of(subset[0], subset[1], subset[2]));
    }
}
