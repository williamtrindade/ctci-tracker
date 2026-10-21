package CTCI15OneAway;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    private final Solution solution = new Solution();

    @ParameterizedTest(name = "\"{0}\" x \"{1}\" -> {2}")
    @CsvSource(value = {
            // exemplos do livro
            "pale, ple, true",
            "pales, pale, true",
            "pale, bale, true",
            "pale, bake, false",
            // zero edições
            "pale, pale, true",
            "'', '', true",
            // inserção / remoção nas pontas
            "a, '', true",
            "'', a, true",
            "ab, '', false",
            "ple, pale, true",
            "pale, pales, true",
            "apple, aple, true",
            "xpale, pale, true",
            // mais de uma edição
            "abc, acb, false",
            "pale, pal, true",
            "pale, pl, false",
            "abcd, abxyd, false",
            "teacher, bleacher, false"
    })
    void oneEditAway(String first, String second, boolean expected) {
        assertEquals(expected, solution.oneEditAway(first, second));
    }
}
