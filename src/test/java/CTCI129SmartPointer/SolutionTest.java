package CTCI129SmartPointer;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SolutionTest {

    @Test
    void deletesWhenLastReferenceIsReleased() {
        List<String> deleted = new ArrayList<>();
        String resource = "resource";
        Solution.SmartPointer<String> p1 = new Solution.SmartPointer<>(resource, deleted::add);
        assertEquals(1, p1.refCount());
        Solution.SmartPointer<String> p2 = p1.copy();
        Solution.SmartPointer<String> p3 = p2.copy();
        assertEquals(3, p1.refCount());
        assertSame(resource, p3.get());

        p1.release();
        assertEquals(2, p2.refCount());
        p2.release();
        assertTrue(deleted.isEmpty());
        p3.release();
        assertEquals(List.of("resource"), deleted);
    }

    @Test
    void releaseIsIdempotent() {
        List<String> deleted = new ArrayList<>();
        Solution.SmartPointer<String> p1 = new Solution.SmartPointer<>("x", deleted::add);
        Solution.SmartPointer<String> p2 = p1.copy();
        p1.release();
        p1.release();
        assertEquals(1, p2.refCount());
        assertTrue(deleted.isEmpty());
        p2.release();
        assertEquals(1, deleted.size());
    }

    @Test
    void cannotUseReleasedPointer() {
        Solution.SmartPointer<String> p = new Solution.SmartPointer<>("x", s -> { });
        p.release();
        assertThrows(IllegalStateException.class, p::get);
        assertThrows(IllegalStateException.class, p::copy);
    }
}
