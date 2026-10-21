package CTCI132ReturnFromFinally;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    private final Solution solution = new Solution();

    @Test
    void finallyRunsAfterReturnInTry() {
        List<String> log = new ArrayList<>();
        assertEquals(1, solution.returnFromTry(log));
        assertEquals(List.of("try", "finally"), log);
    }

    @Test
    void finallyRunsAfterReturnInCatch() {
        List<String> log = new ArrayList<>();
        assertEquals(2, solution.returnFromCatch(log));
        assertEquals(List.of("try", "catch", "finally"), log);
    }

    @Test
    void returnInFinallyWins() {
        assertEquals(2, solution.finallyOverridesReturn());
    }

    @Test
    void returnedValueIsEvaluatedBeforeFinally() {
        assertEquals(1, solution.finallyCannotChangeReturnedPrimitive());
        assertEquals(List.of("try", "finally"), solution.finallyCanMutateReturnedObject());
    }
}
