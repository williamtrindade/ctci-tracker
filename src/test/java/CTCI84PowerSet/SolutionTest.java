package CTCI84PowerSet;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    private final Solution solution = new Solution();

    private static Set<Set<Integer>> normalize(List<List<Integer>> subsets) {
        Set<Set<Integer>> result = new HashSet<>();
        for (List<Integer> s : subsets) {
            result.add(new HashSet<>(s));
        }
        return result;
    }

    @Test
    void threeElements() {
        List<List<Integer>> subsets = solution.getSubsets(List.of(1, 2, 3));
        assertEquals(8, subsets.size());
        assertEquals(Set.of(Set.of(), Set.of(1), Set.of(2), Set.of(3), Set.of(1, 2), Set.of(1, 3), Set.of(2, 3),
                Set.of(1, 2, 3)), normalize(subsets));
    }

    @Test
    void emptySet() {
        assertEquals(Set.of(Set.of()), normalize(solution.getSubsets(List.of())));
        assertEquals(1, solution.getSubsets(List.of()).size());
    }

    @Test
    void sizesArePowersOfTwo() {
        for (int n = 0; n <= 12; n++) {
            List<Integer> set = new java.util.ArrayList<>();
            for (int i = 0; i < n; i++) {
                set.add(i * 7);
            }
            List<List<Integer>> subsets = solution.getSubsets(set);
            assertEquals(1 << n, subsets.size());
            assertEquals(1 << n, normalize(subsets).size(), "Subconjuntos devem ser distintos");
        }
    }
}
