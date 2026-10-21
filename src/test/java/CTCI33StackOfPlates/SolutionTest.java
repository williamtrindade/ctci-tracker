package CTCI33StackOfPlates;

import org.junit.jupiter.api.Test;

import java.util.EmptyStackException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SolutionTest {

    @Test
    void behavesLikeASingleStack() {
        Solution.SetOfStacks set = new Solution.SetOfStacks(3);
        for (int i = 1; i <= 10; i++) {
            set.push(i);
        }
        for (int i = 10; i >= 1; i--) {
            assertEquals(i, set.pop());
        }
        assertTrue(set.isEmpty());
    }

    @Test
    void createsNewStackWhenCapacityIsReached() {
        Solution.SetOfStacks set = new Solution.SetOfStacks(3);
        set.push(1);
        set.push(2);
        set.push(3);
        assertEquals(1, set.getNumberOfStacks());
        set.push(4);
        assertEquals(2, set.getNumberOfStacks());
        set.pop();
        assertEquals(1, set.getNumberOfStacks(), "pilhas vazias devem ser descartadas");
    }

    @Test
    void popAtWithRollover() {
        Solution.SetOfStacks set = new Solution.SetOfStacks(3);
        for (int i = 1; i <= 7; i++) {
            set.push(i); // [1,2,3] [4,5,6] [7]
        }
        assertEquals(3, set.popAt(0)); // [1,2,4] [5,6,7]
        assertEquals(2, set.getNumberOfStacks());
        assertEquals(4, set.popAt(0)); // [1,2,5] [6,7]
        assertEquals(7, set.popAt(1)); // [1,2,5] [6]
        int[] expected = {6, 5, 2, 1};
        for (int e : expected) {
            assertEquals(e, set.pop());
        }
        assertTrue(set.isEmpty());
    }

    @Test
    void popAtLastStackRemovesItWhenEmpty() {
        Solution.SetOfStacks set = new Solution.SetOfStacks(2);
        set.push(1);
        set.push(2);
        set.push(3);
        assertEquals(3, set.popAt(1));
        assertEquals(1, set.getNumberOfStacks());
    }

    @Test
    void errors() {
        Solution.SetOfStacks set = new Solution.SetOfStacks(2);
        assertThrows(EmptyStackException.class, set::pop);
        assertThrows(EmptyStackException.class, () -> set.popAt(0));
        set.push(1);
        assertThrows(IndexOutOfBoundsException.class, () -> set.popAt(5));
    }
}
