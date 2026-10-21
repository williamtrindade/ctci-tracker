package CTCI95Cache;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SolutionTest {

    private final List<String> calls = new ArrayList<>();
    private final Function<String, String> expensiveSearch = q -> {
        calls.add(q);
        return "results for " + q;
    };

    @Test
    void cachesResults() {
        Solution.QueryCache cache = new Solution.QueryCache(2, expensiveSearch);
        assertEquals("results for java", cache.getResults("java"));
        assertEquals("results for java", cache.getResults("java"));
        assertEquals(List.of("java"), calls);
    }

    @Test
    void evictsLeastRecentlyUsed() {
        Solution.QueryCache cache = new Solution.QueryCache(2, expensiveSearch);
        cache.getResults("a");
        cache.getResults("b");
        cache.getResults("a");      // "a" fica mais recente
        cache.getResults("c");      // remove "b"
        assertTrue(cache.contains("a"));
        assertFalse(cache.contains("b"));
        assertTrue(cache.contains("c"));
        assertEquals(2, cache.size());
        cache.getResults("b");
        assertEquals(List.of("a", "b", "c", "b"), calls);
    }

    @Test
    void invalidateForcesNewSearch() {
        Solution.QueryCache cache = new Solution.QueryCache(5, expensiveSearch);
        cache.getResults("news");
        cache.invalidate("news");
        assertFalse(cache.contains("news"));
        cache.getResults("news");
        assertEquals(List.of("news", "news"), calls);
        cache.invalidate("not cached"); // não deve falhar
    }

    @Test
    void machineForIsDeterministic() {
        for (int i = 0; i < 500; i++) {
            String q = "query " + i;
            int m = Solution.QueryCache.machineFor(q, 100);
            assertTrue(m >= 0 && m < 100);
            assertEquals(m, Solution.QueryCache.machineFor(q, 100));
        }
    }
}
