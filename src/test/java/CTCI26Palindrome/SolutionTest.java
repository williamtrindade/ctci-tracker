package CTCI26Palindrome;

import common.ListNode;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SolutionTest {

    private final Solution solution = new Solution();

    @Test
    void palindromes() {
        assertTrue(solution.isPalindrome(null));
        assertTrue(solution.isPalindrome(ListNode.of(1)));
        assertTrue(solution.isPalindrome(ListNode.of(1, 1)));
        assertTrue(solution.isPalindrome(ListNode.of(1, 2, 1)));
        assertTrue(solution.isPalindrome(ListNode.of(0, 1, 2, 1, 0)));
        assertTrue(solution.isPalindrome(ListNode.of(1, 2, 2, 1)));
    }

    @Test
    void nonPalindromes() {
        assertFalse(solution.isPalindrome(ListNode.of(1, 2)));
        assertFalse(solution.isPalindrome(ListNode.of(1, 2, 3)));
        assertFalse(solution.isPalindrome(ListNode.of(1, 2, 3, 1)));
        assertFalse(solution.isPalindrome(ListNode.of(1, 2, 1, 2)));
        assertFalse(solution.isPalindrome(ListNode.of(0, 1, 2, 3, 1, 0)));
    }

    @Test
    void doesNotModifyTheList() {
        ListNode head = ListNode.of(1, 2, 3, 2, 1);
        solution.isPalindrome(head);
        assertEquals(List.of(1, 2, 3, 2, 1), ListNode.toList(head));
    }
}
