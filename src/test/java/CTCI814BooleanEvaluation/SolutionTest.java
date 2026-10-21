package CTCI814BooleanEvaluation;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    private final Solution solution = new Solution();

    @Test
    void bookExamples() {
        assertEquals(2, solution.countEval("1^0|0|1", false));
        assertEquals(10, solution.countEval("0&0&0&1^1|0", true));
    }

    @Test
    void singleValues() {
        assertEquals(1, solution.countEval("1", true));
        assertEquals(0, solution.countEval("1", false));
        assertEquals(1, solution.countEval("0", false));
    }

    @Test
    void totalEqualsCatalanNumber() {
        // Com k operadores existem Catalan(k) formas de parentizar: true + false = Catalan(k)
        String s = "1^0|0|1&1^0"; // 5 operadores -> Catalan(5) = 42
        assertEquals(42, solution.countEval(s, true) + solution.countEval(s, false));
        assertEquals(1, solution.countEval("1&1", true));
        assertEquals(1, solution.countEval("1^1", false));
        assertEquals(2, solution.countEval("1|0|1", true));
    }

    @Test
    @Timeout(3)
    void longExpression() {
        // 11 operadores -> Catalan(11) = 58786 parentizações no total
        String s = "1^0|1&0^1|1&0^0|1&1^0|1";
        assertEquals(58786, solution.countEval(s, true) + solution.countEval(s, false));
    }
}
