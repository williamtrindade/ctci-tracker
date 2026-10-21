package CTCI133FinalEtc;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SolutionTest {

    private final Solution solution = new Solution();

    private static Resource resource(List<String> log, boolean failOnRead) {
        return new Resource() {
            @Override
            public void open() {
                log.add("open");
            }

            @Override
            public String read() {
                log.add("read");
                if (failOnRead) {
                    throw new IllegalStateException("disk error");
                }
                return "data";
            }

            @Override
            public void close() {
                log.add("close");
            }
        };
    }

    @Test
    void immutablePointIsFinal() {
        assertTrue(Modifier.isFinal(Solution.ImmutablePoint.class.getModifiers()), "A classe deve ser final");
        for (Field f : Solution.ImmutablePoint.class.getDeclaredFields()) {
            assertTrue(Modifier.isFinal(f.getModifiers()), "O campo " + f.getName() + " deve ser final");
        }
        Solution.ImmutablePoint p = new Solution.ImmutablePoint(1, 2);
        Solution.ImmutablePoint q = p.withX(10);
        assertEquals(1, p.getX());
        assertEquals(10, q.getX());
        assertEquals(2, q.getY());
    }

    @Test
    void finallyClosesOnSuccess() {
        List<String> log = new ArrayList<>();
        assertEquals("data", solution.readAndClose(resource(log, false)));
        assertEquals(List.of("open", "read", "close"), log);
    }

    @Test
    void finallyClosesOnFailure() {
        List<String> log = new ArrayList<>();
        assertThrows(IllegalStateException.class, () -> solution.readAndClose(resource(log, true)));
        assertEquals(List.of("open", "read", "close"), log);
    }
}
