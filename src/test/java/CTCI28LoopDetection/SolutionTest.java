package CTCI28LoopDetection;

import common.ListNode;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;

@Timeout(5)
class SolutionTest {

    private final Solution solution = new Solution();

    private static ListNode withLoop(int size, int loopStartIndex) {
        int[] values = new int[size];
        for (int i = 0; i < size; i++) {
            values[i] = i;
        }
        ListNode head = ListNode.of(values);
        ListNode.last(head).next = ListNode.nodeAt(head, loopStartIndex);
        return head;
    }

    @Test
    void bookExample() {
        // A -> B -> C -> D -> E -> C
        ListNode head = withLoop(5, 2);
        assertSame(ListNode.nodeAt(head, 2), solution.findBeginning(head));
    }

    @Test
    void loopAtHeadAndSelfLoop() {
        ListNode head = withLoop(6, 0);
        assertSame(head, solution.findBeginning(head));

        ListNode single = withLoop(1, 0);
        assertSame(single, solution.findBeginning(single));
    }

    @Test
    void variousLoopSizes() {
        for (int size = 1; size <= 30; size++) {
            for (int start = 0; start < size; start++) {
                ListNode head = withLoop(size, start);
                assertSame(ListNode.nodeAt(head, start), solution.findBeginning(head),
                        "size=" + size + " start=" + start);
            }
        }
    }

    @Test
    void noLoop() {
        assertNull(solution.findBeginning(ListNode.of(1, 2, 3, 4)));
        assertNull(solution.findBeginning(ListNode.of(1)));
        assertNull(solution.findBeginning(null));
    }
}
