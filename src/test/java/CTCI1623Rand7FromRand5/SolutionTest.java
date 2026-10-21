package CTCI1623Rand7FromRand5;

import org.junit.jupiter.api.Test;

import java.util.Random;
import java.util.function.IntSupplier;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SolutionTest {

    private final Solution solution = new Solution();

    @Test
    void uniformDistribution() {
        Random random = new Random(23);
        IntSupplier rand5 = () -> random.nextInt(5); // a única fonte de aleatoriedade permitida
        int[] counts = new int[7];
        int samples = 700_000;
        for (int i = 0; i < samples; i++) {
            int v = solution.rand7(rand5);
            assertTrue(v >= 0 && v <= 6, "Fora do intervalo: " + v);
            counts[v]++;
        }
        for (int v = 0; v < 7; v++) {
            assertEquals(samples / 7.0, counts[v], samples / 7.0 * 0.02, "Frequência de " + v);
        }
    }
}
