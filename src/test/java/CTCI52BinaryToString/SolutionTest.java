package CTCI52BinaryToString;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    private final Solution solution = new Solution();

    @ParameterizedTest(name = "{0} -> {1}")
    @CsvSource({
            "0.5, .1",
            "0.25, .01",
            "0.75, .11",
            "0.625, .101",
            "0.8125, .1101",
            "0.72, ERROR",   // exemplo do livro
            "0.1, ERROR",
            "0.0, ERROR",
            "1.0, ERROR",
            "-0.5, ERROR"
    })
    void printBinary(double num, String expected) {
        assertEquals(expected, solution.printBinary(num));
    }

    @Test
    void lengthLimitIncludesThePoint() {
        // 2^-31 precisa de 31 dígitos + "." = 32 caracteres -> ok
        assertEquals("." + "0".repeat(30) + "1", solution.printBinary(Math.pow(2, -31)));
        // 2^-32 precisaria de 33 caracteres -> ERROR
        assertEquals("ERROR", solution.printBinary(Math.pow(2, -32)));
    }
}
