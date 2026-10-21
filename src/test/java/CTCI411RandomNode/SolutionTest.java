package CTCI411RandomNode;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SolutionTest {

    @Test
    void insertFindAndSize() {
        Solution.RandomBST tree = new Solution.RandomBST(new Random(1));
        assertEquals(0, tree.size());
        int[] values = {20, 10, 30, 5, 15, 35, 3, 7, 17};
        for (int v : values) {
            tree.insertInOrder(v);
        }
        assertEquals(values.length, tree.size());
        for (int v : values) {
            assertTrue(tree.find(v));
        }
        assertFalse(tree.find(100));
        assertFalse(tree.find(8));
    }

    @Test
    void emptyTreeReturnsNull() {
        assertNull(new Solution.RandomBST(new Random(1)).getRandomNode());
    }

    @Test
    void singleNode() {
        Solution.RandomBST tree = new Solution.RandomBST(new Random(1));
        tree.insertInOrder(42);
        for (int i = 0; i < 10; i++) {
            assertEquals(42, tree.getRandomNode());
        }
    }

    @Test
    void randomNodeIsUniform() {
        Solution.RandomBST tree = new Solution.RandomBST(new Random(12345));
        // árvore desbalanceada de propósito: a distribuição deve continuar uniforme
        int[] values = {50, 30, 70, 20, 40, 60, 80, 10, 1, 2};
        for (int v : values) {
            tree.insertInOrder(v);
        }
        int samples = 200_000;
        Map<Integer, Integer> counts = new HashMap<>();
        for (int i = 0; i < samples; i++) {
            counts.merge(tree.getRandomNode(), 1, Integer::sum);
        }
        assertEquals(values.length, counts.size(), "Todos os nós devem poder ser sorteados");
        double expected = (double) samples / values.length;
        counts.forEach((value, count) ->
                assertTrue(Math.abs(count - expected) < expected * 0.05,
                        "Frequência de " + value + " = " + count + " (esperado ~" + expected + ")"));
    }
}
