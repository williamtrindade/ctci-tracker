package CTCI12CheckPermutation;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SolutionTest {

    private final Solution solution = new Solution();

    @ParameterizedTest
    @CsvSource({
            "abc, cba",
            "god, dog",
            "aabbcc, ccbaab",
            "abc, bac"
    })
    void returnsTrueWhenStringsArePermutations(String s1, String s2) {
        assertTrue(solution.checkPermutation(s1, s2), () -> "Esperado true para permutações: \"" + s1 + "\" e \"" + s2 + "\"");
    }

    @ParameterizedTest
    @CsvSource({
            "abc, abcd",
            "abc, def",
            "aab, abb",
            "abc, abcc"
    })
    void returnsFalseWhenStringsAreNotPermutations(String s1, String s2) {
        assertFalse(solution.checkPermutation(s1, s2), () -> "Esperado false para não-permutações: \"" + s1 + "\" e \"" + s2 + "\"");
    }

    @Test
    void emptyStringsArePermutationsOfEachOther() {
        assertTrue(solution.checkPermutation("", ""));
    }

    @Test
    void comparisonIsCaseSensitive() {
        // O livro assume comparação case sensitive: "God" não é permutação de "dog"
        assertFalse(solution.checkPermutation("God", "dog"));
    }

    @Test
    void whitespaceIsSignificant() {
        // O livro assume que espaços contam: "god   " é diferente de "dog"
        assertFalse(solution.checkPermutation("god   ", "dog"));
        assertTrue(solution.checkPermutation("a b", "ba "));
    }
}
