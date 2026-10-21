package CTCI32StackMin;

import org.junit.jupiter.api.Test;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Deque;
import java.util.EmptyStackException;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SolutionTest {

    @Test
    void minIsUpdatedOnPushAndPop() {
        Solution.StackWithMin stack = new Solution.StackWithMin();
        stack.push(5);
        assertEquals(5, stack.min());
        stack.push(6);
        assertEquals(5, stack.min());
        stack.push(3);
        assertEquals(3, stack.min());
        stack.push(7);
        assertEquals(3, stack.min());
        assertEquals(7, stack.pop());
        assertEquals(3, stack.min());
        assertEquals(3, stack.pop());
        assertEquals(5, stack.min());
        assertEquals(6, stack.peek());
    }

    @Test
    void duplicatedMinimums() {
        Solution.StackWithMin stack = new Solution.StackWithMin();
        stack.push(2);
        stack.push(2);
        stack.push(1);
        stack.push(1);
        assertEquals(1, stack.pop());
        assertEquals(1, stack.min());
        assertEquals(1, stack.pop());
        assertEquals(2, stack.min());
        assertEquals(2, stack.pop());
        assertEquals(2, stack.min());
        assertFalse(stack.isEmpty());
        assertEquals(2, stack.pop());
        assertTrue(stack.isEmpty());
    }

    @Test
    void emptyStackThrows() {
        Solution.StackWithMin stack = new Solution.StackWithMin();
        assertThrows(EmptyStackException.class, stack::pop);
        assertThrows(EmptyStackException.class, stack::peek);
        assertThrows(EmptyStackException.class, stack::min);
    }

    @Test
    void randomOperationsMatchModel() {
        Random random = new Random(3);
        Solution.StackWithMin stack = new Solution.StackWithMin();
        Deque<Integer> model = new ArrayDeque<>();
        for (int i = 0; i < 5000; i++) {
            if (model.isEmpty() || random.nextInt(3) > 0) {
                int v = random.nextInt(100) - 50;
                stack.push(v);
                model.push(v);
            } else {
                assertEquals(model.pop(), stack.pop());
            }
            if (!model.isEmpty()) {
                assertEquals(Collections.min(model), stack.min());
            }
        }
    }
}
