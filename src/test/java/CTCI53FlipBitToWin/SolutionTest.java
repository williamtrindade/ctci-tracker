package CTCI53FlipBitToWin;

import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    private final Solution solution = new Solution();

    private static int longestRun(int x) {
        int best = 0;
        int current = 0;
        for (int i = 0; i < 32; i++) {
            if (((x >>> i) & 1) == 1) {
                best = Math.max(best, ++current);
            } else {
                current = 0;
            }
        }
        return best;
    }

    private static int brute(int a) {
        int best = longestRun(a);
        for (int i = 0; i < 32; i++) {
            best = Math.max(best, longestRun(a | (1 << i)));
        }
        return best;
    }

    @Test
    void bookExample() {
        assertEquals(8, solution.flipBit(1775));
    }

    @Test
    void edgeCases() {
        assertEquals(1, solution.flipBit(0));
        assertEquals(32, solution.flipBit(-1));
        assertEquals(32, solution.flipBit(0x7FFFFFFF));
        assertEquals(2, solution.flipBit(1));
        assertEquals(3, solution.flipBit(0b101));
        assertEquals(4, solution.flipBit(0b1011));
    }

    @Test
    void randomNumbersMatchBruteForce() {
        Random random = new Random(55);
        for (int t = 0; t < 2000; t++) {
            int a = random.nextInt();
            assertEquals(brute(a), solution.flipBit(a), () -> "a = " + Integer.toBinaryString(a));
        }
    }
}
