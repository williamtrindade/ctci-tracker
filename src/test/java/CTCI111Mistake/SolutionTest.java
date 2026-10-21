package CTCI111Mistake;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    private final Solution solution = new Solution();

    @Test
    void countdownFrom100To0() {
        List<String> lines = solution.countdown();
        assertEquals(101, lines.size());
        assertEquals("100", lines.get(0));
        assertEquals("1", lines.get(99));
        assertEquals("0", lines.get(100));
    }

    @Test
    void formatSpecifierForUnsigned() {
        assertEquals("%u", solution.correctFormatSpecifier());
    }

    @Test
    @Timeout(5)
    void originalLoopNeverTerminates() {
        assertEquals(1000L, solution.buggyLoopIterations(1000));
        assertEquals(10_000_000L, solution.buggyLoopIterations(10_000_000));
    }
}
