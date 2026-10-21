package CTCI23DeleteMiddleNode;

import common.ListNode;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SolutionTest {

    private final Solution solution = new Solution();

    @Test
    void bookExample() {
        // a->b->c->d->e->f  (a=1 ... f=6), remove c
        ListNode head = ListNode.of(1, 2, 3, 4, 5, 6);
        assertTrue(solution.deleteNode(ListNode.nodeAt(head, 2)));
        assertEquals(List.of(1, 2, 4, 5, 6), ListNode.toList(head));
    }

    @Test
    void deleteSecondToLast() {
        ListNode head = ListNode.of(1, 2, 3);
        assertTrue(solution.deleteNode(ListNode.nodeAt(head, 1)));
        assertEquals(List.of(1, 3), ListNode.toList(head));
    }

    @Test
    void cannotDeleteLastNodeOrNull() {
        ListNode head = ListNode.of(1, 2, 3);
        assertFalse(solution.deleteNode(ListNode.nodeAt(head, 2)));
        assertFalse(solution.deleteNode(null));
        assertEquals(List.of(1, 2, 3), ListNode.toList(head));
    }
}
