package CTCI115TestAPen;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SolutionTest {

    @Test
    void normalUse() {
        Solution.Pen pen = new Solution.Pen(100);
        assertTrue(pen.isCapped());
        pen.uncap();
        assertFalse(pen.isCapped());
        assertEquals("hello world", pen.write("hello world"));
        assertEquals(90, pen.inkLeft(), "espaços não gastam tinta");
    }

    @Test
    void cappedPenDoesNotWrite() {
        Solution.Pen pen = new Solution.Pen(10);
        assertEquals("", pen.write("abc"));
        assertEquals(10, pen.inkLeft());
        pen.uncap();
        pen.cap();
        assertEquals("", pen.write("abc"));
    }

    @Test
    void runningOutOfInk() {
        Solution.Pen pen = new Solution.Pen(3);
        pen.uncap();
        assertEquals("ab c", pen.write("ab cd"));
        assertEquals(0, pen.inkLeft());
        assertEquals("", pen.write("x"));
        assertEquals("  ", pen.write("  y"), "espaços continuam 'saindo' mesmo sem tinta");
    }

    @Test
    void extremeCases() {
        Solution.Pen empty = new Solution.Pen(0);
        empty.uncap();
        assertEquals("", empty.write("a"));
        Solution.Pen pen = new Solution.Pen(5);
        pen.uncap();
        assertEquals("", pen.write(""));
        assertEquals("", pen.write(null));
        assertThrows(IllegalArgumentException.class, () -> new Solution.Pen(-1));
    }
}
