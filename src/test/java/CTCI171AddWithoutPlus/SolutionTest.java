package CTCI171AddWithoutPlus;

import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    private final Solution solution = new Solution();

    @Test
    void examples() {
        assertEquals(1337, solution.add(759, 578));
        assertEquals(0, solution.add(0, 0));
        assertEquals(-5, solution.add(-2, -3));
        assertEquals(1, solution.add(-2, 3));
        assertEquals(Integer.MIN_VALUE, solution.add(Integer.MAX_VALUE, 1)); // overflow como em Java
    }

    @Test
    void randomValues() {
        Random random = new Random(171);
        for (int t = 0; t < 10_000; t++) {
            int a = random.nextInt();
            int b = random.nextInt();
            assertEquals(a + b, solution.add(a, b));
        }
    }
}
