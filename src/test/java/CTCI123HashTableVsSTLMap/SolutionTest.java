package CTCI123HashTableVsSTLMap;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.TreeMap;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SolutionTest {

    @Test
    void basicOperations() {
        Solution.BstMap<String, Integer> map = new Solution.BstMap<>();
        assertNull(map.firstKey());
        assertNull(map.put("banana", 1));
        assertNull(map.put("apple", 2));
        assertNull(map.put("cherry", 3));
        assertEquals(2, map.put("apple", 20));
        assertEquals(20, map.get("apple"));
        assertTrue(map.containsKey("cherry"));
        assertFalse(map.containsKey("durian"));
        assertEquals(3, map.size());
        assertEquals(List.of("apple", "banana", "cherry"), map.keys());
        assertEquals("apple", map.firstKey());
        assertEquals("cherry", map.lastKey());
    }

    @Test
    void keysAreSortedLikeStdMap() {
        Random random = new Random(1);
        Solution.BstMap<Integer, Integer> map = new Solution.BstMap<>();
        TreeMap<Integer, Integer> model = new TreeMap<>();
        for (int i = 0; i < 10_000; i++) {
            int k = random.nextInt(5000);
            assertEquals(model.put(k, i), map.put(k, i));
        }
        assertEquals(new ArrayList<>(model.keySet()), map.keys());
        assertEquals(model.size(), map.size());
        assertEquals(model.firstKey(), map.firstKey());
        assertEquals(model.lastKey(), map.lastKey());
    }

    @Test
    void sortedInsertionsDoNotOverflowTheStack() {
        Solution.BstMap<Integer, Integer> map = new Solution.BstMap<>();
        for (int i = 0; i < 5000; i++) {
            map.put(i, i);
        }
        assertEquals(5000, map.keys().size());
        assertEquals(4999, map.get(4999));
    }
}
