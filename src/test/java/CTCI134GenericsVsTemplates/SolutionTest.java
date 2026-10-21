package CTCI134GenericsVsTemplates;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SolutionTest {

    @Test
    void staticFieldIsSharedAcrossTypeArguments() {
        int before = Solution.Box.instanceCount();
        Solution.Box<String> a = new Solution.Box<>("a");
        Solution.Box<Integer> b = new Solution.Box<>(1);
        new Solution.Box<>(List.of());
        assertEquals(before + 3, Solution.Box.instanceCount());
        assertEquals("a", a.get());
        assertEquals(1, b.get());
    }

    @Test
    void typeArgumentsAreErasedAtRuntime() {
        assertTrue(Solution.sameRuntimeClass(new ArrayList<String>(), new ArrayList<Integer>()));
        assertTrue(Solution.sameRuntimeClass(new Solution.Box<>("x"), new Solution.Box<>(2.0)));
        assertFalse(Solution.sameRuntimeClass("x", 1));
    }

    @Test
    void boundedGenerics() {
        assertEquals(9, Solution.max(List.of(3, 9, 1)));
        assertEquals("pear", Solution.max(List.of("apple", "pear", "fig")));
        assertThrows(NoSuchElementException.class, () -> Solution.max(new ArrayList<Integer>()));
    }
}
