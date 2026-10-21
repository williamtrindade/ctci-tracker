package CTCI1720ContinuousMedian;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    private static double median(List<Integer> values) {
        List<Integer> sorted = new ArrayList<>(values);
        Collections.sort(sorted);
        int n = sorted.size();
        if (n % 2 == 1) {
            return sorted.get(n / 2);
        }
        return ((double) sorted.get(n / 2 - 1) + sorted.get(n / 2)) / 2;
    }

    @Test
    void example() {
        Solution.MedianTracker tracker = new Solution.MedianTracker();
        assertEquals(0, tracker.getMedian());
        tracker.addNewNumber(5);
        assertEquals(5, tracker.getMedian());
        tracker.addNewNumber(15);
        assertEquals(10, tracker.getMedian());
        tracker.addNewNumber(1);
        assertEquals(5, tracker.getMedian());
        tracker.addNewNumber(3);
        assertEquals(4, tracker.getMedian());
    }

    @Test
    void randomStream() {
        Random random = new Random(1720);
        Solution.MedianTracker tracker = new Solution.MedianTracker();
        List<Integer> values = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            int v = random.nextInt(200) - 100;
            tracker.addNewNumber(v);
            values.add(v);
            assertEquals(median(values), tracker.getMedian(), 1e-9);
        }
    }

    @Test
    @Timeout(3)
    void manyNumbers() {
        Solution.MedianTracker tracker = new Solution.MedianTracker();
        for (int i = 1; i <= 1_000_000; i++) {
            tracker.addNewNumber(i);
        }
        assertEquals(500_000.5, tracker.getMedian(), 1e-9);
    }
}
