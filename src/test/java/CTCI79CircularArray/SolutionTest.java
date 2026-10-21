package CTCI79CircularArray;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;

class SolutionTest {

    private static Solution.CircularArray<String> abcde() {
        Solution.CircularArray<String> array = new Solution.CircularArray<>(5);
        String[] values = {"a", "b", "c", "d", "e"};
        for (int i = 0; i < values.length; i++) {
            array.set(i, values[i]);
        }
        return array;
    }

    private static List<String> toList(Solution.CircularArray<String> array) {
        List<String> list = new ArrayList<>();
        for (String s : array) {
            list.add(s);
        }
        return list;
    }

    @Test
    void getAndSet() {
        Solution.CircularArray<String> array = abcde();
        assertEquals(5, array.size());
        assertEquals("c", array.get(2));
        assertEquals(List.of("a", "b", "c", "d", "e"), toList(array));
    }

    @Test
    void rotate() {
        Solution.CircularArray<String> array = abcde();
        array.rotate(1);
        assertEquals(List.of("b", "c", "d", "e", "a"), toList(array));
        array.rotate(2);
        assertEquals(List.of("d", "e", "a", "b", "c"), toList(array));
        array.rotate(-3);
        assertEquals(List.of("a", "b", "c", "d", "e"), toList(array));
        array.rotate(12); // 12 % 5 = 2
        assertEquals(List.of("c", "d", "e", "a", "b"), toList(array));
    }

    @Test
    void setAfterRotateUsesLogicalIndex() {
        Solution.CircularArray<String> array = abcde();
        array.rotate(3);
        array.set(0, "X");
        assertEquals(List.of("X", "e", "a", "b", "c"), toList(array));
        array.rotate(-3);
        assertEquals(List.of("a", "b", "c", "X", "e"), toList(array));
    }

    @Test
    void outOfBounds() {
        Solution.CircularArray<String> array = abcde();
        assertThrows(IndexOutOfBoundsException.class, () -> array.get(5));
        assertThrows(IndexOutOfBoundsException.class, () -> array.set(-1, "z"));
    }

    @Test
    void iteratorContract() {
        Solution.CircularArray<Integer> array = new Solution.CircularArray<>(2);
        array.set(0, 1);
        array.set(1, 2);
        Iterator<Integer> it = array.iterator();
        assertEquals(1, it.next());
        assertEquals(2, it.next());
        assertFalse(it.hasNext());
        assertThrows(NoSuchElementException.class, it::next);
    }
}
