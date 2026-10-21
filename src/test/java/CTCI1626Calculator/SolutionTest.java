package CTCI1626Calculator;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    private final Solution solution = new Solution();

    @ParameterizedTest(name = "{0} = {1}")
    @CsvSource({
            "2*3+5/6*3+15, 23.5",   // exemplo do livro
            "42, 42",
            "1+2+3, 6",
            "10-2-3, 5",            // associatividade à esquerda
            "2-3*4, -10",
            "8/4/2, 1",
            "5/2, 2.5",
            "100+20*3-40/8, 155",
            "3*4-5*6+7, -11",
            "1-1+1-1+1, 1"
    })
    void compute(String expression, double expected) {
        assertEquals(expected, solution.compute(expression), 1e-9);
    }
}
