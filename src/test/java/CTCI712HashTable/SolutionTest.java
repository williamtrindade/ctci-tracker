package CTCI712HashTable;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SolutionTest {

    /** Chave com hashCode péssimo: todas colidem. */
    private record BadKey(int id) {
        @Override
        public int hashCode() {
            return 42;
        }
    }

    @Test
    void basicOperations() {
        Solution.HashTable<String, Integer> table = new Solution.HashTable<>(4);
        assertNull(table.put("a", 1));
        assertNull(table.put("b", 2));
        assertEquals(1, table.put("a", 10));
        assertEquals(10, table.get("a"));
        assertEquals(2, table.size());
        assertTrue(table.containsKey("b"));
        assertEquals(2, table.remove("b"));
        assertNull(table.remove("b"));
        assertFalse(table.containsKey("b"));
        assertNull(table.get("zzz"));
        assertEquals(1, table.size());
    }

    @Test
    void collisionsAreHandledByChaining() {
        Solution.HashTable<BadKey, String> table = new Solution.HashTable<>(8);
        for (int i = 0; i < 50; i++) {
            table.put(new BadKey(i), "v" + i);
        }
        assertEquals(50, table.size());
        for (int i = 0; i < 50; i++) {
            assertEquals("v" + i, table.get(new BadKey(i)));
        }
        assertEquals("v0", table.remove(new BadKey(0)));
        assertEquals("v25", table.remove(new BadKey(25)));
        assertEquals("v49", table.remove(new BadKey(49)));
        assertEquals(47, table.size());
        assertNull(table.get(new BadKey(25)));
        assertEquals("v24", table.get(new BadKey(24)));
    }

    @Test
    void negativeHashCodes() {
        Solution.HashTable<Integer, Integer> table = new Solution.HashTable<>(3);
        for (int i = -100; i < 100; i++) {
            table.put(i, i * 2);
        }
        assertEquals(-200, table.get(-100));
        assertNull(table.put(Integer.MIN_VALUE, 1));
        assertEquals(1, table.get(Integer.MIN_VALUE));
    }

    @Test
    void nullKeyIsRejected() {
        Solution.HashTable<String, Integer> table = new Solution.HashTable<>(4);
        assertThrows(IllegalArgumentException.class, () -> table.put(null, 1));
    }

    @Test
    @Timeout(5)
    void manyRandomOperationsMatchHashMap() {
        Random random = new Random(12);
        Solution.HashTable<Integer, Integer> table = new Solution.HashTable<>(1);
        Map<Integer, Integer> model = new HashMap<>();
        for (int i = 0; i < 200_000; i++) {
            int key = random.nextInt(50_000);
            int op = random.nextInt(3);
            if (op == 0) {
                assertEquals(model.put(key, i), table.put(key, i));
            } else if (op == 1) {
                assertEquals(model.get(key), table.get(key));
            } else {
                assertEquals(model.remove(key), table.remove(key));
            }
        }
        assertEquals(model.size(), table.size());
    }
}
