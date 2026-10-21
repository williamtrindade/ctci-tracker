package CTCI135TreeMapHashMapLinkedHashMap;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SolutionTest {

    private static List<Integer> keys(Map<Integer, String> map) {
        return new ArrayList<>(map.keySet());
    }

    private static void fill(Map<Integer, String> map) {
        for (int k : new int[]{50, 10, 40, 20, 30}) {
            map.put(k, "v" + k);
        }
    }

    @Test
    void sortedByKey() {
        Map<Integer, String> map = Solution.sortedByKey();
        fill(map);
        assertEquals(List.of(10, 20, 30, 40, 50), keys(map));
    }

    @Test
    void insertionOrdered() {
        Map<Integer, String> map = Solution.insertionOrdered();
        fill(map);
        assertEquals(List.of(50, 10, 40, 20, 30), keys(map));
    }

    @Test
    void fastestIsAHashMap() {
        Map<Integer, String> map = Solution.fastest();
        assertEquals(HashMap.class, map.getClass());
    }

    @Test
    void lruCache() {
        Map<Integer, String> cache = Solution.lruCache(3);
        cache.put(1, "a");
        cache.put(2, "b");
        cache.put(3, "c");
        cache.get(1);        // 1 vira o mais recente
        cache.put(4, "d");   // remove o 2 (menos recente)
        assertEquals(List.of(3, 1, 4), keys(cache));
        assertTrue(cache.size() <= 3);
    }
}
