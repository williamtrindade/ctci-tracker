package CTCI152ContextSwitch;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import static org.junit.jupiter.api.Assertions.assertTrue;

class SolutionTest {

    @Test
    @Timeout(20)
    void returnsAPlausibleMeasurement() throws Exception {
        double micros = new Solution().measureContextSwitchMicros(20_000);
        assertTrue(micros > 0, "Tempo deve ser positivo");
        assertTrue(micros < 10_000, "Uma troca de contexto não deve levar 10 ms: " + micros + " µs");
    }
}
