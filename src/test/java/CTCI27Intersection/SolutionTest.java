package CTCI27Intersection;

import common.ListNode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;

class SolutionTest {

    private final Solution solution = new Solution();

    @Test
    void listsIntersectingInTheMiddle() {
        // 3 -> 1 -> 5 -> 9 -> [7 -> 2 -> 1]
        //           4 -> 6 -> [7 -> 2 -> 1]
        ListNode shared = ListNode.of(7, 2, 1);
        ListNode a = ListNode.of(3, 1, 5, 9);
        ListNode.last(a).next = shared;
        ListNode b = ListNode.of(4, 6);
        ListNode.last(b).next = shared;
        assertSame(shared, solution.findIntersection(a, b));
        assertSame(shared, solution.findIntersection(b, a));
    }

    @Test
    void intersectionIsByReferenceNotValue() {
        ListNode a = ListNode.of(1, 2, 3);
        ListNode b = ListNode.of(1, 2, 3);
        assertNull(solution.findIntersection(a, b));
    }

    @Test
    void oneListIsSuffixOfTheOther() {
        ListNode a = ListNode.of(1, 2, 3, 4);
        ListNode b = ListNode.nodeAt(a, 2);
        assertSame(b, solution.findIntersection(a, b));
    }

    @Test
    void sameList() {
        ListNode a = ListNode.of(1, 2);
        assertSame(a, solution.findIntersection(a, a));
    }

    @Test
    void nullLists() {
        assertNull(solution.findIntersection(null, ListNode.of(1)));
        assertNull(solution.findIntersection(null, null));
    }
}
