package CTCI168EnglishInt;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    private final Solution solution = new Solution();

    @ParameterizedTest(name = "{0} -> {1}")
    @CsvSource({
            "0, Zero",
            "7, Seven",
            "13, Thirteen",
            "20, Twenty",
            "42, Forty Two",
            "100, One Hundred",
            "115, One Hundred Fifteen",
            "1234, One Thousand Two Hundred Thirty Four",
            "1000010, One Million Ten",
            "19323984, Nineteen Million Three Hundred Twenty Three Thousand Nine Hundred Eighty Four",
            "-12, Negative Twelve",
            "2000000000, Two Billion",
            "2147483647, Two Billion One Hundred Forty Seven Million Four Hundred Eighty Three Thousand Six Hundred Forty Seven",
            "-2147483648, Negative Two Billion One Hundred Forty Seven Million Four Hundred Eighty Three Thousand Six Hundred Forty Eight"
    })
    void convert(int number, String expected) {
        assertEquals(expected, solution.convert(number));
    }
}
