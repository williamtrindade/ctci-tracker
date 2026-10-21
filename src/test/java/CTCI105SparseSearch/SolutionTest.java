package CTCI105SparseSearch;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    private final Solution solution = new Solution();

    private final String[] book = {"at", "", "", "", "ball", "", "", "car", "", "", "dad", "", ""};

    @Test
    void bookExample() {
        assertEquals(4, solution.search(book, "ball"));
    }

    @Test
    void allWords() {
        assertEquals(0, solution.search(book, "at"));
        assertEquals(7, solution.search(book, "car"));
        assertEquals(10, solution.search(book, "dad"));
    }

    @Test
    void notFound() {
        assertEquals(-1, solution.search(book, "bat"));
        assertEquals(-1, solution.search(book, "zebra"));
        assertEquals(-1, solution.search(book, "a"));
        assertEquals(-1, solution.search(book, ""));
        assertEquals(-1, solution.search(new String[]{"", "", ""}, "x"));
    }

    @Test
    void denseArray() {
        String[] words = {"a", "b", "c", "d", "e", "f"};
        for (int i = 0; i < words.length; i++) {
            assertEquals(i, solution.search(words, words[i]));
        }
    }
}
