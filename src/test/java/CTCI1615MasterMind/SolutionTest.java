package CTCI1615MasterMind;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class SolutionTest {

    private final Solution solution = new Solution();

    @ParameterizedTest(name = "guess={0} solution={1} -> {2} hits, {3} pseudo")
    @CsvSource({
            "GGRR, RGBY, 1, 1",   // exemplo do livro
            "YRGB, RGGB, 2, 1",
            "RGBY, RGBY, 4, 0",
            "YBGR, RGBY, 0, 4",
            "RRRR, RGBY, 1, 0",   // posição de hit não vira pseudo-hit
            "BBBB, RGGR, 0, 0",
            "RGGB, GRBG, 0, 4",
            "RYYB, YRBY, 0, 4"
    })
    void estimate(String guess, String sol, int hits, int pseudo) {
        assertEquals(new Result(hits, pseudo), solution.estimate(guess, sol));
    }

    @Test
    void differentLengths() {
        assertNull(solution.estimate("RGB", "RGBY"));
    }
}
