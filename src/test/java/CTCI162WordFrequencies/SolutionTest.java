package CTCI162WordFrequencies;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    private final String[] book = {"The", "quick", "brown", "fox", "jumps", "over", "the", "lazy", "dog", " THE ",
            "Fox", "", "  "};

    @Test
    void countsCaseInsensitive() {
        Solution.WordFrequencies f = new Solution.WordFrequencies(book);
        assertEquals(3, f.getFrequency("the"));
        assertEquals(3, f.getFrequency("THE"));
        assertEquals(2, f.getFrequency(" fox "));
        assertEquals(1, f.getFrequency("dog"));
    }

    @Test
    void missingAndInvalidWords() {
        Solution.WordFrequencies f = new Solution.WordFrequencies(book);
        assertEquals(0, f.getFrequency("cat"));
        assertEquals(-1, f.getFrequency(null));
        assertEquals(-1, f.getFrequency(""));
    }

    @Test
    void manyQueriesAreFast() {
        String[] big = new String[200_000];
        for (int i = 0; i < big.length; i++) {
            big[i] = "w" + (i % 1000);
        }
        Solution.WordFrequencies f = new Solution.WordFrequencies(big);
        for (int i = 0; i < 100_000; i++) {
            assertEquals(200, f.getFrequency("w" + (i % 1000)));
        }
    }
}
