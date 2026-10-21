package CTCI172Shuffle;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SolutionTest {

    private final Solution solution = new Solution();

    @Test
    void keepsTheSameCards() {
        int[] deck = new int[52];
        for (int i = 0; i < 52; i++) {
            deck[i] = i;
        }
        solution.shuffle(deck, new Random(1));
        int[] sorted = deck.clone();
        Arrays.sort(sorted);
        int[] expected = new int[52];
        for (int i = 0; i < 52; i++) {
            expected[i] = i;
        }
        assertArrayEquals(expected, sorted);
    }

    @Test
    void allPermutationsAreEquallyLikely() {
        Random random = new Random(2);
        Map<String, Integer> counts = new HashMap<>();
        int samples = 240_000;
        for (int i = 0; i < samples; i++) {
            int[] deck = {1, 2, 3, 4};
            solution.shuffle(deck, random);
            counts.merge(Arrays.toString(deck), 1, Integer::sum);
        }
        assertEquals(24, counts.size(), "As 24 permutações de 4 cartas devem aparecer");
        double expected = samples / 24.0;
        counts.forEach((perm, c) ->
                assertTrue(Math.abs(c - expected) < expected * 0.06, perm + " apareceu " + c + " vezes"));
    }
}
