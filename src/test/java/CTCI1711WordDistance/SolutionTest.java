package CTCI1711WordDistance;

import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    private final Solution solution = new Solution();

    private final String[] text = "the quick brown fox jumps over the lazy dog and the fox runs".split(" ");

    private static int brute(String[] words, String a, String b) {
        int best = -1;
        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < words.length; j++) {
                if (words[i].equals(a) && words[j].equals(b) && (best < 0 || Math.abs(i - j) < best)) {
                    best = Math.abs(i - j);
                }
            }
        }
        return best;
    }

    @Test
    void singleQuery() {
        assertEquals(1, solution.findClosest(text, "the", "fox"));
        assertEquals(1, solution.findClosest(text, "fox", "the"));
        assertEquals(3, solution.findClosest(text, "quick", "jumps"));
        assertEquals(-1, solution.findClosest(text, "cat", "dog"));
    }

    @Test
    void repeatedQueries() {
        Solution.WordDistanceIndex index = new Solution.WordDistanceIndex(text);
        assertEquals(1, index.distance("the", "fox"));
        assertEquals(2, index.distance("dog", "the"));
        assertEquals(-1, index.distance("the", "cat"));
    }

    @Test
    void randomTexts() {
        Random random = new Random(1711);
        String[] vocab = {"a", "b", "c", "d", "e"};
        for (int t = 0; t < 300; t++) {
            String[] words = new String[random.nextInt(30) + 1];
            for (int i = 0; i < words.length; i++) {
                words[i] = vocab[random.nextInt(vocab.length)];
            }
            Solution.WordDistanceIndex index = new Solution.WordDistanceIndex(words);
            String a = vocab[random.nextInt(vocab.length)];
            String b = vocab[random.nextInt(vocab.length)];
            if (a.equals(b)) {
                continue;
            }
            int expected = brute(words, a, b);
            assertEquals(expected, solution.findClosest(words, a, b));
            assertEquals(expected, index.distance(a, b));
        }
    }
}
