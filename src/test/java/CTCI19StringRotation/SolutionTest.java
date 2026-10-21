package CTCI19StringRotation;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SolutionTest {

    private final Solution solution = new Solution();

    @ParameterizedTest
    @CsvSource({
            "waterbottle, erbottlewat",
            "abc, bca",
            "abc, cab",
            "abc, abc",
            "aaab, abaa",
            "a, a"
    })
    void detectsRotations(String s1, String s2) {
        assertTrue(solution.isRotation(s1, s2));
    }

    @ParameterizedTest
    @CsvSource({
            "waterbottle, erbottlewta",
            "abc, acb",
            "abc, abcd",
            "abc, ab",
            "aab, abb"
    })
    void rejectsNonRotations(String s1, String s2) {
        assertFalse(solution.isRotation(s1, s2));
    }

    @Test
    void emptyStringsAreNotConsideredRotations() {
        assertFalse(solution.isRotation("", ""));
    }

    @Test
    void usesIsSubstringAtMostOnce() {
        solution.isRotation("waterbottle", "erbottlewat");
        assertTrue(solution.isSubstringCalls <= 1, "isSubstring deve ser chamado no máximo uma vez");
        Solution other = new Solution();
        other.isRotation("abcdef", "defabc");
        assertEquals(1, other.isSubstringCalls, "isSubstring deve ser chamado exatamente uma vez");
    }
}
