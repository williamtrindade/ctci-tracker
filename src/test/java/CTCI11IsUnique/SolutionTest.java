package CTCI11IsUnique;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SolutionTest {

    private final Solution solution = new Solution();

    @Test
    void emptyStringIsUnique() {
        assertTrue(solution.isUnique(""));
    }

    @Test
    void singleCharIsUnique() {
        assertTrue(solution.isUnique("a"));
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "abc",
            "abcdefghijklmnopqrstuvwxyz",
            "aA",            // maiúscula e minúscula são caracteres diferentes
            "a b",           // espaço conta como caractere
            "0123456789",
            "!@#$%^&*()"
    })
    void returnsTrueWhenAllCharsAreUnique(String input) {
        assertTrue(solution.isUnique(input), () -> "Esperado true para: \"" + input + "\"");
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "aa",
            "hello",
            "abca",          // repetição no início e no fim
            "abcdefghijklmnopqrstuvwxyza",
            "a  b",          // espaço repetido
            "112"
    })
    void returnsFalseWhenThereIsARepeatedChar(String input) {
        assertFalse(solution.isUnique(input), () -> "Esperado false para: \"" + input + "\"");
    }

    @Test
    void stringLongerThanAsciiSetMustHaveRepetition() {
        // Com 128 caracteres ASCII, qualquer string ASCII com mais de 128 chars tem repetição
        assertFalse(solution.isUnique("x".repeat(129)));
    }
}
