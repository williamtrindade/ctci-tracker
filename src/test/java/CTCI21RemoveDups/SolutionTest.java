package CTCI21RemoveDups;

import common.ListNode;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.function.Consumer;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    private final Solution solution = new Solution();

    private void check(Consumer<ListNode> method) {
        ListNode l1 = ListNode.of(1, 2, 3, 2, 1, 4);
        method.accept(l1);
        assertEquals(List.of(1, 2, 3, 4), ListNode.toList(l1));

        ListNode l2 = ListNode.of(5, 5, 5, 5);
        method.accept(l2);
        assertEquals(List.of(5), ListNode.toList(l2));

        ListNode l3 = ListNode.of(1, 2, 3);
        method.accept(l3);
        assertEquals(List.of(1, 2, 3), ListNode.toList(l3));

        ListNode l4 = ListNode.of(7);
        method.accept(l4);
        assertEquals(List.of(7), ListNode.toList(l4));

        ListNode l5 = ListNode.of(3, 1, 3, 3, 2, 1, 2, 3);
        method.accept(l5);
        assertEquals(List.of(3, 1, 2), ListNode.toList(l5));

        assertDoesNotThrow(() -> method.accept(null));
    }

    @Test
    void deleteDupsWithBuffer() {
        check(solution::deleteDups);
    }

    @Test
    void deleteDupsWithoutBuffer() {
        check(solution::deleteDupsNoBuffer);
    }
}
