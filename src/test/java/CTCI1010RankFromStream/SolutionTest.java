package CTCI1010RankFromStream;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    @Test
    void bookExample() {
        Solution.RankTracker tracker = new Solution.RankTracker();
        for (int x : new int[]{5, 1, 4, 4, 5, 9, 7, 13, 3}) {
            tracker.track(x);
        }
        assertEquals(0, tracker.getRankOfNumber(1));
        assertEquals(1, tracker.getRankOfNumber(3));
        assertEquals(3, tracker.getRankOfNumber(4));
        assertEquals(5, tracker.getRankOfNumber(5));
        assertEquals(8, tracker.getRankOfNumber(13));
        assertEquals(-1, tracker.getRankOfNumber(6));
    }

    @Test
    void emptyTracker() {
        assertEquals(-1, new Solution.RankTracker().getRankOfNumber(1));
    }

    @Test
    @Timeout(5)
    void randomStreamMatchesBruteForce() {
        Random random = new Random(3);
        Solution.RankTracker tracker = new Solution.RankTracker();
        List<Integer> seen = new ArrayList<>();
        for (int i = 0; i < 100_000; i++) {
            int x = random.nextInt(1_000_000);
            tracker.track(x);
            seen.add(x);
        }
        for (int t = 0; t < 200; t++) {
            int x = seen.get(random.nextInt(seen.size()));
            long expected = seen.stream().filter(v -> v <= x).count() - 1;
            assertEquals(expected, tracker.getRankOfNumber(x));
        }
    }
}
