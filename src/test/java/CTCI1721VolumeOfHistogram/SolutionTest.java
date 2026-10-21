package CTCI1721VolumeOfHistogram;

import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    private final Solution solution = new Solution();

    /** Simula "nível a nível": em cada altura h, conta as casas vazias entre duas barras >= h. */
    private static int brute(int[] histo) {
        int max = 0;
        for (int h : histo) {
            max = Math.max(max, h);
        }
        int volume = 0;
        for (int level = 1; level <= max; level++) {
            int first = -1;
            int last = -1;
            for (int i = 0; i < histo.length; i++) {
                if (histo[i] >= level) {
                    if (first < 0) {
                        first = i;
                    }
                    last = i;
                }
            }
            for (int i = first; first >= 0 && i <= last; i++) {
                if (histo[i] < level) {
                    volume++;
                }
            }
        }
        return volume;
    }

    @Test
    void bookExample() {
        assertEquals(26, solution.computeHistogramVolume(new int[]{0, 0, 4, 0, 0, 6, 0, 0, 3, 0, 5, 0, 1, 0, 0, 0}));
    }

    @Test
    void edgeCases() {
        assertEquals(0, solution.computeHistogramVolume(new int[]{}));
        assertEquals(0, solution.computeHistogramVolume(new int[]{1, 2, 3}));
        assertEquals(0, solution.computeHistogramVolume(new int[]{3, 2, 1}));
        assertEquals(1, solution.computeHistogramVolume(new int[]{1, 0, 1}));
        assertEquals(6, solution.computeHistogramVolume(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));
    }

    @Test
    void randomHistograms() {
        Random random = new Random(1721);
        for (int t = 0; t < 1000; t++) {
            int[] h = random.ints(random.nextInt(25), 0, 8).toArray();
            assertEquals(brute(h), solution.computeHistogramVolume(h));
        }
    }
}
