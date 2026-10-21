package CTCI22ReturnKthToLast;

import common.ListNode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;

class SolutionTest {

    private final Solution solution = new Solution();

    @Test
    void kEqualsOneReturnsLastNode() {
        ListNode head = ListNode.of(1, 2, 3, 4, 5);
        assertSame(ListNode.nodeAt(head, 4), solution.kthToLast(head, 1));
    }

    @Test
    void returnsKthToLastNode() {
        ListNode head = ListNode.of(10, 20, 30, 40, 50);
        assertSame(ListNode.nodeAt(head, 3), solution.kthToLast(head, 2));
        assertSame(ListNode.nodeAt(head, 2), solution.kthToLast(head, 3));
    }

    @Test
    void kEqualsLengthReturnsHead() {
        ListNode head = ListNode.of(1, 2, 3);
        assertSame(head, solution.kthToLast(head, 3));
    }

    @Test
    void outOfBoundsReturnsNull() {
        ListNode head = ListNode.of(1, 2, 3);
        assertNull(solution.kthToLast(head, 4));
        assertNull(solution.kthToLast(head, 0));
        assertNull(solution.kthToLast(null, 1));
    }
}
