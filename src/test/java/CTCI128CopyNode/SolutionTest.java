package CTCI128CopyNode;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import java.util.IdentityHashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotSame;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;

@Timeout(5)
class SolutionTest {

    private final Solution solution = new Solution();

    /** Verifica que a cópia é isomorfa ao original e não compartilha nenhum nó com ele. */
    private static void assertIsomorphic(Node original, Node copy, Map<Node, Node> mapping) {
        if (original == null) {
            assertNull(copy);
            return;
        }
        assertNotSame(original, copy);
        Node mapped = mapping.get(original);
        if (mapped != null) {
            assertSame(mapped, copy, "Nó compartilhado deve continuar compartilhado na cópia");
            return;
        }
        mapping.put(original, copy);
        assertEquals(original.data, copy.data);
        assertIsomorphic(original.ptr1, copy.ptr1, mapping);
        assertIsomorphic(original.ptr2, copy.ptr2, mapping);
    }

    @Test
    void treeLikeStructure() {
        Node root = new Node(1);
        root.ptr1 = new Node(2);
        root.ptr2 = new Node(3);
        root.ptr1.ptr1 = new Node(4);
        Node copy = solution.copyStructure(root);
        assertIsomorphic(root, copy, new IdentityHashMap<>());
    }

    @Test
    void sharedNodesAndCycles() {
        Node a = new Node(1);
        Node b = new Node(2);
        Node c = new Node(3);
        a.ptr1 = b;
        a.ptr2 = c;
        b.ptr1 = c;      // c é compartilhado
        c.ptr1 = a;      // ciclo
        c.ptr2 = c;      // auto-referência
        Node copy = solution.copyStructure(a);
        assertIsomorphic(a, copy, new IdentityHashMap<>());
        assertSame(copy.ptr2, copy.ptr1.ptr1);
        assertSame(copy, copy.ptr2.ptr1);
        assertSame(copy.ptr2, copy.ptr2.ptr2);
    }

    @Test
    void nullAndSingle() {
        assertNull(solution.copyStructure(null));
        Node single = new Node(42);
        Node copy = solution.copyStructure(single);
        assertNotSame(single, copy);
        assertEquals(42, copy.data);
    }

    @Test
    void longChain() {
        Node head = new Node(0);
        Node cur = head;
        for (int i = 1; i < 2000; i++) {
            cur.ptr1 = new Node(i);
            cur.ptr2 = head;
            cur = cur.ptr1;
        }
        assertIsomorphic(head, solution.copyStructure(head), new IdentityHashMap<>());
    }
}
