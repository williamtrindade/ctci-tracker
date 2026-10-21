package CTCI31ThreeInOne;

import org.junit.jupiter.api.Test;

import java.util.EmptyStackException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SolutionTest {

    @Test
    void threeIndependentStacks() {
        Solution.FixedMultiStack stacks = new Solution.FixedMultiStack(3);
        stacks.push(0, 1);
        stacks.push(0, 2);
        stacks.push(1, 10);
        stacks.push(2, 100);
        stacks.push(2, 200);
        stacks.push(2, 300);

        assertEquals(2, stacks.peek(0));
        assertEquals(10, stacks.peek(1));
        assertEquals(300, stacks.pop(2));
        assertEquals(200, stacks.pop(2));
        assertEquals(2, stacks.pop(0));
        assertEquals(1, stacks.pop(0));
        assertEquals(10, stacks.pop(1));
        assertEquals(100, stacks.pop(2));
        assertTrue(stacks.isEmpty(0));
        assertTrue(stacks.isEmpty(1));
        assertTrue(stacks.isEmpty(2));
    }

    @Test
    void fullStackThrowsAndDoesNotAffectOthers() {
        Solution.FixedMultiStack stacks = new Solution.FixedMultiStack(2);
        stacks.push(1, 5);
        stacks.push(1, 6);
        assertTrue(stacks.isFull(1));
        assertThrows(FullStackException.class, () -> stacks.push(1, 7));
        assertFalse(stacks.isFull(0));
        stacks.push(0, 1);
        stacks.push(2, 9);
        assertEquals(6, stacks.pop(1));
        assertEquals(1, stacks.pop(0));
        assertEquals(9, stacks.pop(2));
    }

    @Test
    void emptyStackThrows() {
        Solution.FixedMultiStack stacks = new Solution.FixedMultiStack(2);
        assertThrows(EmptyStackException.class, () -> stacks.pop(0));
        assertThrows(EmptyStackException.class, () -> stacks.peek(2));
    }

    @Test
    void manyPushAndPop() {
        Solution.FixedMultiStack stacks = new Solution.FixedMultiStack(100);
        for (int i = 0; i < 100; i++) {
            for (int s = 0; s < 3; s++) {
                stacks.push(s, i * 3 + s);
            }
        }
        for (int i = 99; i >= 0; i--) {
            for (int s = 2; s >= 0; s--) {
                assertEquals(i * 3 + s, stacks.pop(s));
            }
        }
    }
}
