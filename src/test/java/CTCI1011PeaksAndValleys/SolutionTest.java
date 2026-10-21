package CTCI1011PeaksAndValleys;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SolutionTest {

    private final Solution solution = new Solution();

    /** Alterna: existe uma paridade p tal que a[i] >= a[i-1] quando i % 2 == p, e a[i] <= a[i-1] senão. */
    private static boolean alternates(int[] a) {
        for (int p = 0; p < 2; p++) {
            boolean ok = true;
            for (int i = 1; i < a.length && ok; i++) {
                ok = (i % 2 == p) ? a[i] >= a[i - 1] : a[i] <= a[i - 1];
            }
            if (ok) {
                return true;
            }
        }
        return false;
    }

    private void check(int[] input) {
        int[] array = input.clone();
        solution.sortValleyPeak(array);
        int[] a = array.clone();
        int[] b = input.clone();
        Arrays.sort(a);
        Arrays.sort(b);
        assertArrayEquals(b, a, "Deve conter os mesmos elementos");
        assertTrue(alternates(array), () -> "Não alterna picos e vales: " + Arrays.toString(array));
    }

    @Test
    void bookExamples() {
        check(new int[]{5, 3, 1, 2, 3});
        check(new int[]{5, 8, 6, 2, 3, 4, 6});
        check(new int[]{9, 1, 0, 4, 8, 7});
    }

    @Test
    void edgeCases() {
        check(new int[]{});
        check(new int[]{1});
        check(new int[]{1, 2});
        check(new int[]{2, 2, 2, 2});
        check(new int[]{1, 2, 3, 4, 5, 6});
        check(new int[]{6, 5, 4, 3, 2, 1});
    }

    @Test
    void randomArrays() {
        Random random = new Random(11);
        for (int t = 0; t < 1000; t++) {
            check(random.ints(random.nextInt(30), 0, 10).toArray());
        }
    }
}
