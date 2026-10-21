package CTCI87PermutationsWithoutDups;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SolutionTest {

    private final Solution solution = new Solution();

    private static String sorted(String s) {
        char[] c = s.toCharArray();
        Arrays.sort(c);
        return new String(c);
    }

    @Test
    void abc() {
        assertEquals(Set.of("abc", "acb", "bac", "bca", "cab", "cba"), new HashSet<>(solution.getPerms("abc")));
        assertEquals(6, solution.getPerms("abc").size());
    }

    @Test
    void emptyAndSingle() {
        assertEquals(List.of(""), solution.getPerms(""));
        assertEquals(List.of("x"), solution.getPerms("x"));
    }

    @Test
    void factorialCounts() {
        String s = "abcdefg";
        List<String> perms = solution.getPerms(s);
        assertEquals(5040, perms.size());
        assertEquals(5040, new HashSet<>(perms).size());
        for (String p : perms) {
            assertTrue(sorted(p).equals(sorted(s)));
        }
    }
}
