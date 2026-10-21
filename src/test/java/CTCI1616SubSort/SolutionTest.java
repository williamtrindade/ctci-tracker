package CTCI1616SubSort;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class SolutionTest {

    private final Solution solution = new Solution();

    private static int[] brute(int[] array) {
        int[] sorted = array.clone();
        Arrays.sort(sorted);
        int m = 0;
        while (m < array.length && array[m] == sorted[m]) {
            m++;
        }
        if (m == array.length) {
            return null;
        }
        int n = array.length - 1;
        while (array[n] == sorted[n]) {
            n--;
        }
        return new int[]{m, n};
    }

    @Test
    void bookExample() {
        assertArrayEquals(new int[]{3, 9}, solution.findUnsortedSequence(new int[]{1, 2, 4, 7, 10, 11, 7, 12, 6, 7, 16, 18, 19}));
    }

    @Test
    void alreadySorted() {
        assertNull(solution.findUnsortedSequence(new int[]{1, 2, 2, 3}));
        assertNull(solution.findUnsortedSequence(new int[]{5}));
        assertNull(solution.findUnsortedSequence(new int[]{}));
    }

    @Test
    void wholeArrayAndDuplicates() {
        assertArrayEquals(new int[]{0, 3}, solution.findUnsortedSequence(new int[]{4, 3, 2, 1}));
        assertArrayEquals(new int[]{1, 2}, solution.findUnsortedSequence(new int[]{1, 3, 2, 3}));
        assertArrayEquals(new int[]{0, 4}, solution.findUnsortedSequence(new int[]{2, 2, 2, 2, 1}));
    }

    @Test
    void randomArrays() {
        Random random = new Random(16);
        for (int t = 0; t < 2000; t++) {
            int[] array = random.ints(random.nextInt(15) + 1, 0, 8).toArray();
            assertArrayEquals(brute(array), solution.findUnsortedSequence(array), Arrays.toString(array));
        }
    }
}
