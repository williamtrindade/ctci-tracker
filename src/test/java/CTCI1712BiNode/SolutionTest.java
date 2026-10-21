package CTCI1712BiNode;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.IdentityHashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SolutionTest {

    private final Solution solution = new Solution();

    private static BiNode insert(BiNode root, int v) {
        if (root == null) {
            return new BiNode(v);
        }
        if (v <= root.data) {
            root.node1 = insert(root.node1, v);
        } else {
            root.node2 = insert(root.node2, v);
        }
        return root;
    }

    private static void inOrder(BiNode n, List<Integer> values, Map<BiNode, Boolean> nodes) {
        if (n == null) {
            return;
        }
        inOrder(n.node1, values, nodes);
        values.add(n.data);
        nodes.put(n, true);
        inOrder(n.node2, values, nodes);
    }

    private void check(int... values) {
        BiNode root = null;
        for (int v : values) {
            root = insert(root, v);
        }
        List<Integer> expected = new ArrayList<>();
        Map<BiNode, Boolean> originalNodes = new IdentityHashMap<>();
        inOrder(root, expected, originalNodes);

        BiNode head = solution.convert(root);
        if (values.length == 0) {
            assertNull(head);
            return;
        }
        assertNull(head.node1, "A cabeça não tem anterior");
        List<Integer> forward = new ArrayList<>();
        BiNode tail = null;
        for (BiNode n = head; n != null; n = n.node2) {
            assertTrue(originalNodes.containsKey(n), "Deve reaproveitar os nós originais (in place)");
            if (n.node2 != null) {
                assertSame(n, n.node2.node1, "node1 do próximo deve apontar de volta");
            }
            forward.add(n.data);
            tail = n;
            if (forward.size() > values.length) {
                throw new AssertionError("A lista tem um ciclo");
            }
        }
        assertEquals(expected, forward);
        List<Integer> backward = new ArrayList<>();
        for (BiNode n = tail; n != null; n = n.node1) {
            backward.add(0, n.data);
        }
        assertEquals(expected, backward);
    }

    @Test
    void examples() {
        check(4, 2, 5, 1, 3, 6, 0);
        check(1);
        check(1, 2, 3, 4);
        check(4, 3, 2, 1);
        check();
    }

    @Test
    void randomTrees() {
        Random random = new Random(1712);
        for (int t = 0; t < 100; t++) {
            check(random.ints(random.nextInt(40) + 1, 0, 100).toArray());
        }
    }
}
