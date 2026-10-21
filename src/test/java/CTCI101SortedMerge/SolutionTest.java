package CTCI101SortedMerge;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class SolutionTest {

    private final Solution solution = new Solution();

    private void check(int[] aValues, int[] b) {
        int[] a = Arrays.copyOf(aValues, aValues.length + b.length);
        solution.merge(a, b, aValues.length, b.length);
        int[] expected = new int[aValues.length + b.length];
        System.arraycopy(aValues, 0, expected, 0, aValues.length);
        System.arraycopy(b, 0, expected, aValues.length, b.length);
        Arrays.sort(expected);
        assertArrayEquals(expected, a);
    }

    @Test
    void examples() {
        check(new int[]{1, 3, 5, 7}, new int[]{2, 4, 6});
        check(new int[]{4, 5, 6}, new int[]{1, 2, 3});
        check(new int[]{1, 2, 3}, new int[]{4, 5, 6});
        check(new int[]{}, new int[]{1, 2});
        check(new int[]{1, 2}, new int[]{});
        check(new int[]{2, 2, 2}, new int[]{2, 2});
    }

    @Test
    void largerBufferKeepsTailUntouched() {
        int[] a = {1, 4, 9, 0, 0, 0, 99};
        solution.merge(a, new int[]{2, 3}, 3, 2);
        assertArrayEquals(new int[]{1, 2, 3, 4, 9, 0, 99}, a);
    }

    @Test
    void randomArrays() {
        Random random = new Random(6);
        for (int t = 0; t < 200; t++) {
            int[] a = random.ints(random.nextInt(20), -50, 50).sorted().toArray();
            int[] b = random.ints(random.nextInt(20), -50, 50).sorted().toArray();
            check(a, b);
        }
    }
}
