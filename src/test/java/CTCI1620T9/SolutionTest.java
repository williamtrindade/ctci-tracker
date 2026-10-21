package CTCI1620T9;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SolutionTest {

    private final Solution solution = new Solution();
    private final Set<String> dictionary = Set.of("tree", "used", "tref", "trees", "apple", "home", "good", "gone",
            "hood", "hoof", "in", "go", "a", "b");

    private List<String> sorted(List<String> list) {
        List<String> copy = new ArrayList<>(list);
        Collections.sort(copy);
        return copy;
    }

    @Test
    void bookExample() {
        assertEquals(List.of("tree", "tref", "used"), sorted(solution.getValidT9Words("8733", dictionary)));
    }

    @Test
    void moreWords() {
        assertEquals(List.of("gone", "good", "home", "hood", "hoof"), sorted(solution.getValidT9Words("4663", dictionary)));
        assertEquals(List.of("a", "b"), sorted(solution.getValidT9Words("2", dictionary)));
        assertEquals(List.of("go", "in"), sorted(solution.getValidT9Words("46", dictionary)));
    }

    @Test
    void noMatches() {
        assertTrue(solution.getValidT9Words("1", dictionary).isEmpty());
        assertTrue(solution.getValidT9Words("99999", dictionary).isEmpty());
    }
}
