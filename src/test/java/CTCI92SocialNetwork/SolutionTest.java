package CTCI92SocialNetwork;

import org.junit.jupiter.api.Test;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SolutionTest {

    private final Solution solution = new Solution();

    private static void addFriendship(Map<Integer, List<Integer>> g, int a, int b) {
        g.computeIfAbsent(a, k -> new ArrayList<>()).add(b);
        g.computeIfAbsent(b, k -> new ArrayList<>()).add(a);
    }

    private static int shortestDistance(Map<Integer, List<Integer>> g, int s, int t) {
        Map<Integer, Integer> dist = new HashMap<>();
        Queue<Integer> q = new ArrayDeque<>();
        dist.put(s, 0);
        q.add(s);
        while (!q.isEmpty()) {
            int u = q.poll();
            if (u == t) {
                return dist.get(u);
            }
            for (int v : g.getOrDefault(u, List.of())) {
                if (!dist.containsKey(v)) {
                    dist.put(v, dist.get(u) + 1);
                    q.add(v);
                }
            }
        }
        return -1;
    }

    private static void assertShortestPath(Map<Integer, List<Integer>> g, int s, int t, List<Integer> path) {
        int expected = shortestDistance(g, s, t);
        if (expected < 0) {
            assertNull(path);
            return;
        }
        assertEquals(s, path.get(0));
        assertEquals(t, path.get(path.size() - 1));
        assertEquals(expected, path.size() - 1, "O caminho deve ser o mais curto: " + path);
        for (int i = 1; i < path.size(); i++) {
            assertTrue(g.get(path.get(i - 1)).contains(path.get(i)), "Não são amigos: " + path.get(i - 1) + ", " + path.get(i));
        }
    }

    @Test
    void bookExample() {
        // Me(0) -> Bob(1) -> Susan(2) -> Jason(3) -> You(4), com um atalho mais longo
        Map<Integer, List<Integer>> g = new HashMap<>();
        addFriendship(g, 0, 1);
        addFriendship(g, 1, 2);
        addFriendship(g, 2, 3);
        addFriendship(g, 3, 4);
        addFriendship(g, 0, 5);
        addFriendship(g, 5, 6);
        addFriendship(g, 6, 7);
        addFriendship(g, 7, 8);
        addFriendship(g, 8, 4);
        assertEquals(List.of(0, 1, 2, 3, 4), solution.findPathBiBFS(g, 0, 4));
    }

    @Test
    void sameAndAdjacentPeople() {
        Map<Integer, List<Integer>> g = new HashMap<>();
        addFriendship(g, 1, 2);
        assertEquals(List.of(1), solution.findPathBiBFS(g, 1, 1));
        assertEquals(List.of(1, 2), solution.findPathBiBFS(g, 1, 2));
    }

    @Test
    void disconnected() {
        Map<Integer, List<Integer>> g = new HashMap<>();
        addFriendship(g, 1, 2);
        addFriendship(g, 3, 4);
        assertNull(solution.findPathBiBFS(g, 1, 4));
        assertNull(solution.findPathBiBFS(g, 1, 99));
    }

    @Test
    void randomNetworks() {
        Random random = new Random(5);
        for (int t = 0; t < 50; t++) {
            Map<Integer, List<Integer>> g = new HashMap<>();
            int n = 200;
            for (int i = 0; i < 300; i++) {
                int a = random.nextInt(n);
                int b = random.nextInt(n);
                if (a != b) {
                    addFriendship(g, a, b);
                }
            }
            int s = random.nextInt(n);
            int d = random.nextInt(n);
            assertShortestPath(g, s, d, solution.findPathBiBFS(g, s, d));
        }
    }
}
