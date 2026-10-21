package CTCI1714SmallestK;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class SolutionTest {

    private final Solution solution = new Solution();

    private void check(int[] array, int k) {
        int[] copy = array.clone();
        int[] result = solution.smallestK(array, k);
        assertArrayEquals(copy, array, "O array original não deve mudar");
        int[] sorted = array.clone();
        Arrays.sort(sorted);
        int[] expected = Arrays.copyOf(sorted, k);
        int[] actual = result.clone();
        Arrays.sort(actual);
        assertArrayEquals(expected, actual);
    }

    @Test
    void examples() {
        check(new int[]{5, 1, 9, 3, 7}, 2);
        check(new int[]{5, 1, 9, 3, 7}, 5);
        check(new int[]{5, 1, 9, 3, 7}, 0);
        check(new int[]{2, 2, 2, 1, 1}, 3);
    }

    @Test
    void randomArrays() {
        Random random = new Random(1714);
        for (int t = 0; t < 500; t++) {
            int[] a = random.ints(random.nextInt(50) + 1, -100, 100).toArray();
            check(a, random.nextInt(a.length + 1));
        }
    }
}
