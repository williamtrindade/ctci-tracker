package CTCI1625LRUCache;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SolutionTest {

    @Test
    void evictsLeastRecentlyUsed() {
        Solution.LRUCache cache = new Solution.LRUCache(2);
        cache.setKeyValue(1, "one");
        cache.setKeyValue(2, "two");
        assertEquals("one", cache.getValue(1)); // 1 fica mais recente
        cache.setKeyValue(3, "three");          // remove 2
        assertNull(cache.getValue(2));
        assertEquals("one", cache.getValue(1));
        assertEquals("three", cache.getValue(3));
        assertEquals(2, cache.size());
    }

    @Test
    void updateCountsAsUse() {
        Solution.LRUCache cache = new Solution.LRUCache(2);
        cache.setKeyValue(1, "a");
        cache.setKeyValue(2, "b");
        cache.setKeyValue(1, "A"); // atualiza e torna 1 o mais recente
        cache.setKeyValue(3, "c"); // remove 2
        assertEquals("A", cache.getValue(1));
        assertNull(cache.getValue(2));
    }

    @Test
    void remove() {
        Solution.LRUCache cache = new Solution.LRUCache(3);
        cache.setKeyValue(1, "a");
        assertTrue(cache.removeKey(1));
        assertFalse(cache.removeKey(1));
        assertEquals(0, cache.size());
        assertNull(cache.getValue(1));
    }

    @Test
    void sizeOne() {
        Solution.LRUCache cache = new Solution.LRUCache(1);
        cache.setKeyValue(1, "a");
        cache.setKeyValue(2, "b");
        assertNull(cache.getValue(1));
        assertEquals("b", cache.getValue(2));
    }

    @Test
    @Timeout(5)
    void randomOperationsMatchLinkedHashMap() {
        int capacity = 50;
        Map<Integer, String> model = new LinkedHashMap<>(16, 0.75f, true) {
            @Override
            protected boolean removeEldestEntry(Map.Entry<Integer, String> eldest) {
                return size() > capacity;
            }
        };
        Solution.LRUCache cache = new Solution.LRUCache(capacity);
        Random random = new Random(25);
        for (int i = 0; i < 300_000; i++) {
            int key = random.nextInt(100);
            int op = random.nextInt(3);
            if (op == 0) {
                model.remove(key);
                model.put(key, "v" + i);
                cache.setKeyValue(key, "v" + i);
            } else if (op == 1) {
                assertEquals(model.get(key), cache.getValue(key));
            } else {
                assertEquals(model.remove(key) != null, cache.removeKey(key));
            }
            assertEquals(model.size(), cache.size());
        }
    }
}
