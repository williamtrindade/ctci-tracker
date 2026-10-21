package CTCI103SearchInRotatedArray;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SolutionTest {

    private final Solution solution = new Solution();

    private void assertFound(int[] a, int x) {
        int index = solution.search(a, x);
        boolean present = Arrays.stream(a).anyMatch(v -> v == x);
        if (present) {
            assertTrue(index >= 0 && index < a.length && a[index] == x,
                    () -> "Índice " + index + " incorreto para " + x + " em " + Arrays.toString(a));
        } else {
            assertEquals(-1, index, () -> x + " não está em " + Arrays.toString(a));
        }
    }

    @Test
    void bookExample() {
        assertEquals(8, solution.search(new int[]{15, 16, 19, 20, 25, 1, 3, 4, 5, 7, 10, 14}, 5));
    }

    @Test
    void duplicates() {
        int[] a = {2, 2, 2, 3, 4, 2};
        assertFound(a, 3);
        assertFound(a, 4);
        assertFound(a, 2);
        assertFound(a, 5);
        int[] b = {2, 3, 4, 2, 2, 2, 2, 2, 2, 2};
        assertFound(b, 3);
        assertFound(b, 4);
    }

    @Test
    void randomRotatedArrays() {
        Random random = new Random(10);
        for (int t = 0; t < 500; t++) {
            int[] sorted = random.ints(random.nextInt(25) + 1, 0, 15).sorted().toArray();
            int k = random.nextInt(sorted.length);
            int[] rotated = new int[sorted.length];
            for (int i = 0; i < sorted.length; i++) {
                rotated[i] = sorted[(i + k) % sorted.length];
            }
            for (int x = -1; x <= 16; x++) {
                assertFound(rotated, x);
            }
        }
    }
}
