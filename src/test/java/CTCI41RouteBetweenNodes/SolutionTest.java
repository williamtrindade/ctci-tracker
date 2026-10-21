package CTCI41RouteBetweenNodes;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@Timeout(5)
class SolutionTest {

    private final Solution solution = new Solution();

    //  0 -> 1 -> 2 -> 3
    //  ^         |
    //  +---------+       4 -> 5     6 (isolado)
    private final Map<Integer, List<Integer>> graph = Map.of(
            0, List.of(1),
            1, List.of(2),
            2, List.of(0, 3),
            4, List.of(5)
    );

    @Test
    void findsRoutes() {
        assertTrue(solution.routeExists(graph, 0, 3));
        assertTrue(solution.routeExists(graph, 2, 1));
        assertTrue(solution.routeExists(graph, 4, 5));
    }

    @Test
    void respectsDirection() {
        assertFalse(solution.routeExists(graph, 3, 0));
        assertFalse(solution.routeExists(graph, 5, 4));
    }

    @Test
    void noRouteBetweenComponents() {
        assertFalse(solution.routeExists(graph, 0, 5));
        assertFalse(solution.routeExists(graph, 6, 0));
    }

    @Test
    void sameNode() {
        assertTrue(solution.routeExists(graph, 6, 6));
    }

    @Test
    void longChainWithCycles() {
        Map<Integer, List<Integer>> g = new HashMap<>();
        for (int i = 0; i < 10_000; i++) {
            g.put(i, List.of(i + 1, Math.max(0, i - 5)));
        }
        assertTrue(solution.routeExists(g, 0, 10_000));
        assertFalse(solution.routeExists(g, 0, 20_000));
    }
}
