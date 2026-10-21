package CTCI83MagicIndex;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SolutionTest {

    private final Solution solution = new Solution();

    private static boolean hasMagic(int[] a) {
        for (int i = 0; i < a.length; i++) {
            if (a[i] == i) {
                return true;
            }
        }
        return false;
    }

    private static void assertMagic(int[] a, int result) {
        if (hasMagic(a)) {
            assertTrue(result >= 0 && result < a.length && a[result] == result,
                    () -> "Índice " + result + " não é mágico em " + Arrays.toString(a));
        } else {
            assertEquals(-1, result, () -> "Não há índice mágico em " + Arrays.toString(a));
        }
    }

    @Test
    void distinctValues() {
        int[] a = {-40, -20, -1, 1, 2, 3, 5, 7, 9, 12, 13};
        assertEquals(7, solution.magicFast(a));
        assertEquals(-1, solution.magicFast(new int[]{1, 2, 3, 4}));
        assertEquals(-1, solution.magicFast(new int[0]));
        assertEquals(0, solution.magicFast(new int[]{0}));
    }

    @Test
    void duplicatedValues() {
        int[] a = {-10, -5, 2, 2, 2, 3, 4, 7, 9, 12, 13};
        assertMagic(a, solution.magicFastWithDuplicates(a)); // índices mágicos: 2 e 7
        assertEquals(-1, solution.magicFastWithDuplicates(new int[]{5, 5, 5, 5, 5}));
        assertEquals(4, solution.magicFastWithDuplicates(new int[]{-1, -1, -1, -1, 4}));
    }

    @Test
    void randomDistinctArrays() {
        Random random = new Random(3);
        for (int t = 0; t < 500; t++) {
            int[] a = random.ints(random.nextInt(30), -20, 40).distinct().sorted().toArray();
            assertMagic(a, solution.magicFast(a));
        }
    }

    @Test
    void randomArraysWithDuplicates() {
        Random random = new Random(4);
        for (int t = 0; t < 500; t++) {
            int[] a = random.ints(random.nextInt(30), -5, 25).sorted().toArray();
            assertMagic(a, solution.magicFastWithDuplicates(a));
        }
    }
}
