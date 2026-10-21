package CTCI104SortedSearchNoSize;

import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SolutionTest {

    private final Solution solution = new Solution();

    @Test
    void findsElements() {
        int[] values = {1, 3, 4, 5, 7, 10, 14, 15, 16, 19, 20, 25};
        for (int i = 0; i < values.length; i++) {
            assertEquals(i, solution.search(new Listy(values), values[i]));
        }
        assertEquals(-1, solution.search(new Listy(values), 2));
        assertEquals(-1, solution.search(new Listy(values), 26));
        assertEquals(-1, solution.search(new Listy(new int[0]), 1));
    }

    @Test
    void duplicatesReturnAnyIndex() {
        int[] values = {1, 2, 2, 2, 2, 3};
        int index = solution.search(new Listy(values), 2);
        assertTrue(index >= 1 && index <= 4);
    }

    @Test
    void usesLogarithmicNumberOfAccesses() {
        Random random = new Random(2);
        int n = 1_000_000;
        int[] values = new int[n];
        int current = 1;
        for (int i = 0; i < n; i++) {
            current += random.nextInt(3) + 1; // estritamente crescente
            values[i] = current;
        }
        for (int t = 0; t < 100; t++) {
            int i = random.nextInt(n);
            Listy listy = new Listy(values);
            assertEquals(i, solution.search(listy, values[i]));
            assertTrue(listy.getAccesses() <= 100, "Acessos demais: " + listy.getAccesses());
        }
    }
}
