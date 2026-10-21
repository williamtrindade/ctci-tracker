package CTCI47BuildOrder;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SolutionTest {

    private final Solution solution = new Solution();

    private void assertValidOrder(String[] projects, String[][] deps) {
        List<String> order = solution.findBuildOrder(projects, deps);
        assertNotNull(order, "Existe uma ordem válida");
        assertEquals(projects.length, order.size());
        assertEquals(Set.of(projects), new HashSet<>(order));
        for (String[] d : deps) {
            assertTrue(order.indexOf(d[0]) < order.indexOf(d[1]),
                    () -> d[0] + " deve vir antes de " + d[1] + " em " + order);
        }
    }

    @Test
    void bookExample() {
        String[] projects = {"a", "b", "c", "d", "e", "f"};
        String[][] deps = {{"a", "d"}, {"f", "b"}, {"b", "d"}, {"f", "a"}, {"d", "c"}};
        assertValidOrder(projects, deps);
    }

    @Test
    void biggerGraph() {
        String[] projects = {"a", "b", "c", "d", "e", "f", "g"};
        String[][] deps = {{"f", "c"}, {"f", "b"}, {"f", "a"}, {"c", "a"}, {"b", "a"}, {"a", "e"}, {"b", "e"}, {"d", "g"}};
        assertValidOrder(projects, deps);
    }

    @Test
    void noDependencies() {
        assertValidOrder(new String[]{"x", "y", "z"}, new String[0][]);
    }

    @Test
    void cycleReturnsNull() {
        String[] projects = {"a", "b", "c", "d"};
        String[][] deps = {{"a", "b"}, {"b", "c"}, {"c", "a"}, {"a", "d"}};
        assertNull(solution.findBuildOrder(projects, deps));
    }

    @Test
    void selfDependencyIsACycle() {
        assertNull(solution.findBuildOrder(new String[]{"a"}, new String[][]{{"a", "a"}}));
    }
}
