package CTCI34QueueViaStacks;

import org.junit.jupiter.api.Test;

import java.util.ArrayDeque;
import java.util.NoSuchElementException;
import java.util.Queue;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SolutionTest {

    @Test
    void fifoOrder() {
        Solution.MyQueue<String> queue = new Solution.MyQueue<>();
        queue.add("a");
        queue.add("b");
        queue.add("c");
        assertEquals(3, queue.size());
        assertEquals("a", queue.peek());
        assertEquals("a", queue.remove());
        queue.add("d");
        assertEquals("b", queue.remove());
        assertEquals("c", queue.remove());
        assertEquals("d", queue.remove());
        assertTrue(queue.isEmpty());
    }

    @Test
    void emptyQueueThrows() {
        Solution.MyQueue<Integer> queue = new Solution.MyQueue<>();
        assertThrows(NoSuchElementException.class, queue::remove);
        assertThrows(NoSuchElementException.class, queue::peek);
    }

    @Test
    void randomOperationsMatchModel() {
        Random random = new Random(11);
        Solution.MyQueue<Integer> queue = new Solution.MyQueue<>();
        Queue<Integer> model = new ArrayDeque<>();
        for (int i = 0; i < 10_000; i++) {
            int op = random.nextInt(3);
            if (op == 0 || model.isEmpty()) {
                queue.add(i);
                model.add(i);
            } else if (op == 1) {
                assertEquals(model.remove(), queue.remove());
            } else {
                assertEquals(model.peek(), queue.peek());
            }
            assertEquals(model.size(), queue.size());
        }
    }
}
