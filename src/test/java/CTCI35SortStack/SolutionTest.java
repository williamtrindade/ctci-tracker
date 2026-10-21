package CTCI35SortStack;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.Stack;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SolutionTest {

    private final Solution solution = new Solution();

    private void assertSortsCorrectly(List<Integer> values) {
        Stack<Integer> stack = new Stack<>();
        values.forEach(stack::push);
        solution.sort(stack);
        List<Integer> popped = new ArrayList<>();
        while (!stack.isEmpty()) {
            popped.add(stack.pop());
        }
        List<Integer> expected = new ArrayList<>(values);
        Collections.sort(expected); // o menor sai primeiro
        assertEquals(expected, popped);
    }

    @Test
    void smallestOnTop() {
        assertSortsCorrectly(List.of(5, 1, 4, 2, 3));
        assertSortsCorrectly(List.of(1, 2, 3));
        assertSortsCorrectly(List.of(3, 2, 1));
        assertSortsCorrectly(List.of(2, 2, 1, 1, 3));
        assertSortsCorrectly(List.of(-1, 7, -10, 0));
    }

    @Test
    void emptyAndSingle() {
        Stack<Integer> empty = new Stack<>();
        solution.sort(empty);
        assertTrue(empty.isEmpty());
        assertSortsCorrectly(List.of(42));
    }

    @Test
    void randomStacks() {
        Random random = new Random(5);
        for (int t = 0; t < 30; t++) {
            List<Integer> values = new ArrayList<>();
            for (int i = 0; i < random.nextInt(50); i++) {
                values.add(random.nextInt(100));
            }
            assertSortsCorrectly(values);
        }
    }
}
