package CTCI102GroupAnagrams;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SolutionTest {

    private final Solution solution = new Solution();

    private static String key(String s) {
        char[] c = s.toCharArray();
        Arrays.sort(c);
        return new String(c);
    }

    private void assertGrouped(String[] input) {
        String[] array = input.clone();
        solution.sort(array);
        String[] a = array.clone();
        String[] b = input.clone();
        Arrays.sort(a);
        Arrays.sort(b);
        assertArrayEquals(b, a, "Deve conter as mesmas strings");
        Set<String> closedGroups = new HashSet<>();
        for (int i = 0; i < array.length; i++) {
            String k = key(array[i]);
            if (i > 0 && !key(array[i - 1]).equals(k)) {
                closedGroups.add(key(array[i - 1]));
            }
            String finalK = k;
            assertTrue(!closedGroups.contains(finalK), () -> "Anagramas separados: " + Arrays.toString(array));
        }
    }

    @Test
    void groupsAnagrams() {
        assertGrouped(new String[]{"acre", "dog", "race", "god", "care", "cat", "act", "tac", "x"});
    }

    @Test
    void edgeCases() {
        assertGrouped(new String[]{});
        assertGrouped(new String[]{"a"});
        assertGrouped(new String[]{"ab", "ba", "ab"});
        assertGrouped(new String[]{"", "", "a"});
    }
}
