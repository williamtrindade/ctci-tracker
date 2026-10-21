package CTCI88PermutationsWithDups;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    private final Solution solution = new Solution();

    @Test
    void withDuplicates() {
        List<String> perms = solution.printPerms("aab");
        assertEquals(3, perms.size());
        assertEquals(Set.of("aab", "aba", "baa"), new HashSet<>(perms));
    }

    @Test
    void allDistinct() {
        assertEquals(24, new HashSet<>(solution.printPerms("abcd")).size());
        assertEquals(24, solution.printPerms("abcd").size());
    }

    @Test
    void allEqual() {
        assertEquals(List.of("aaaa"), solution.printPerms("aaaa"));
        assertEquals(List.of(""), solution.printPerms(""));
    }

    @Test
    void multinomialCount() {
        // 10! / (3! * 3! * 4!) = 4200
        List<String> perms = solution.printPerms("aaabbbcccc");
        assertEquals(4200, perms.size());
        assertEquals(4200, new HashSet<>(perms).size());
    }

    @Test
    @Timeout(2)
    void doesNotGenerateDuplicatesFirst() {
        // 14!/13! = 14 permutações (gerar todas as 14! e deduplicar seria lento demais)
        assertEquals(14, solution.printPerms("aaaaaaaaaaaaab").size());
    }
}
