package CTCI14PalindromePermutation;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SolutionTest {

    private final Solution solution = new Solution();

    @ParameterizedTest
    @ValueSource(strings = {
            "Tact Coa",        // exemplo do livro: "taco cat"
            "",
            "a",
            "aab",
            "carerac",         // "racecar"
            "Racecar",         // maiúsculas são ignoradas
            "A man a plan a canal Panama",
            "taco cat!",       // pontuação é ignorada
            "aabbccdd"
    })
    void returnsTrueForPermutationsOfPalindromes(String input) {
        assertTrue(solution.isPermutationOfPalindrome(input), () -> "Esperado true para: \"" + input + "\"");
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "ab",
            "abc",
            "Tact Coaz",
            "aabbcd",
            "code"
    })
    void returnsFalseOtherwise(String input) {
        assertFalse(solution.isPermutationOfPalindrome(input), () -> "Esperado false para: \"" + input + "\"");
    }
}
