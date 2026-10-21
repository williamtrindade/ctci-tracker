package CTCI16StringCompression;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    private final Solution solution = new Solution();

    @ParameterizedTest(name = "\"{0}\" -> \"{1}\"")
    @CsvSource(value = {
            "aabcccccaaa, a2b1c5a3",   // exemplo do livro
            "abc, abc",                 // compressão ficaria maior
            "'', ''",
            "a, a",
            "aa, aa",                   // "a2" tem o mesmo tamanho: retorna o original
            "aabb, aabb",               // "a2b2" tem o mesmo tamanho: retorna o original
            "aaa, a3",
            "aaabbb, a3b3",
            "aaAAAA, a2A4",             // case sensitive
            "aaaaaaaaaaaa, a12",        // contagem com mais de um dígito
            "abbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbc, a1b100c1"
    })
    void compress(String input, String expected) {
        assertEquals(expected, solution.compress(input));
    }
}
