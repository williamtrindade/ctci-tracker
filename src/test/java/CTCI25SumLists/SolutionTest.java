package CTCI25SumLists;

import common.ListNode;
import org.junit.jupiter.api.Test;

import java.math.BigInteger;
import java.util.List;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class SolutionTest {

    private final Solution solution = new Solution();

    private static ListNode digits(String number, boolean reverse) {
        String s = reverse ? new StringBuilder(number).reverse().toString() : number;
        return ListNode.of(s.chars().map(c -> c - '0').toArray());
    }

    private static String number(ListNode list, boolean reverse) {
        StringBuilder sb = new StringBuilder();
        for (int d : ListNode.toList(list)) {
            sb.append(d);
        }
        return reverse ? sb.reverse().toString() : sb.toString();
    }

    @Test
    void reverseOrderBookExample() {
        assertEquals(List.of(2, 1, 9), ListNode.toList(solution.addLists(ListNode.of(7, 1, 6), ListNode.of(5, 9, 2))));
    }

    @Test
    void reverseOrderDifferentLengthsAndFinalCarry() {
        // 99 + 1 = 100
        assertEquals(List.of(0, 0, 1), ListNode.toList(solution.addLists(ListNode.of(9, 9), ListNode.of(1))));
        // 5 + 0 = 5 ; null + 12 = 12
        assertEquals(List.of(5), ListNode.toList(solution.addLists(ListNode.of(5), ListNode.of(0))));
        assertEquals(List.of(2, 1), ListNode.toList(solution.addLists(null, ListNode.of(2, 1))));
        assertNull(solution.addLists(null, null));
    }

    @Test
    void forwardOrderBookExample() {
        assertEquals(List.of(9, 1, 2), ListNode.toList(solution.addListsForward(ListNode.of(6, 1, 7), ListNode.of(2, 9, 5))));
    }

    @Test
    void forwardOrderDifferentLengthsAndFinalCarry() {
        // 99 + 1 = 100
        assertEquals(List.of(1, 0, 0), ListNode.toList(solution.addListsForward(ListNode.of(9, 9), ListNode.of(1))));
        // 1234 + 56 = 1290
        assertEquals(List.of(1, 2, 9, 0), ListNode.toList(solution.addListsForward(ListNode.of(1, 2, 3, 4), ListNode.of(5, 6))));
        assertNull(solution.addListsForward(null, null));
    }

    @Test
    void hugeRandomNumbers() {
        Random random = new Random(7);
        for (int t = 0; t < 30; t++) {
            BigInteger a = new BigInteger(random.nextInt(200) + 1, random);
            BigInteger b = new BigInteger(random.nextInt(200) + 1, random);
            String expected = a.add(b).toString();
            assertEquals(expected, number(solution.addLists(digits(a.toString(), true), digits(b.toString(), true)), true));
            assertEquals(expected, number(solution.addListsForward(digits(a.toString(), false), digits(b.toString(), false)), false));
        }
    }
}
