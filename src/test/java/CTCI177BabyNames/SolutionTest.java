package CTCI177BabyNames;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SolutionTest {

    private final Solution solution = new Solution();

    /** Confere o resultado sem depender de qual nome foi escolhido para representar cada grupo. */
    private static void assertGroups(Map<String, Integer> result, Map<Set<String>, Integer> expected) {
        assertEquals(expected.size(), result.size(), "Uma entrada por grupo: " + result);
        for (Map.Entry<String, Integer> e : result.entrySet()) {
            Set<String> group = expected.keySet().stream().filter(g -> g.contains(e.getKey())).findFirst().orElse(null);
            assertTrue(group != null, "Nome inesperado: " + e.getKey());
            assertEquals(expected.get(group), e.getValue(), "Frequência do grupo de " + e.getKey());
        }
    }

    @Test
    void bookExample() {
        Map<String, Integer> names = new HashMap<>(Map.of("John", 15, "Jon", 12, "Chris", 13, "Kris", 4, "Christopher", 19));
        String[][] synonyms = {{"Jon", "John"}, {"John", "Johnny"}, {"Chris", "Kris"}, {"Chris", "Christopher"}};
        assertGroups(solution.trulyMostPopular(names, synonyms), Map.of(
                Set.of("John", "Jon", "Johnny"), 27,
                Set.of("Chris", "Kris", "Christopher"), 36));
    }

    @Test
    void transitiveChainsAndLoneNames() {
        Map<String, Integer> names = new HashMap<>(Map.of("A", 1, "B", 2, "C", 3, "D", 4, "E", 5));
        String[][] synonyms = {{"A", "X"}, {"X", "B"}, {"C", "D"}, {"D", "C"}};
        assertGroups(solution.trulyMostPopular(names, synonyms), Map.of(
                Set.of("A", "B", "X"), 3,
                Set.of("C", "D"), 7,
                Set.of("E"), 5));
    }

    @Test
    void noSynonyms() {
        Map<String, Integer> names = Map.of("Ana", 7, "Bia", 3);
        assertEquals(Map.of("Ana", 7, "Bia", 3), solution.trulyMostPopular(names, new String[0][]));
        assertEquals(List.of(), List.copyOf(solution.trulyMostPopular(Map.of(), new String[0][]).keySet()));
    }
}
