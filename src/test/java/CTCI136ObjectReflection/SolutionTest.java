package CTCI136ObjectReflection;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SolutionTest {

    private final Solution solution = new Solution();

    @Test
    void createAndInvokeByName() throws Exception {
        Object rect = solution.newInstance("CTCI136ObjectReflection.Rectangle", 3.0, 4.0);
        assertTrue(rect instanceof Rectangle);
        assertEquals(12.0, solution.invoke(rect, "area"));
        assertEquals(48.0, solution.invoke(rect, "scaledArea", 2.0));
    }

    @Test
    void inspectFields() {
        assertEquals(List.of("height", "secret", "width"), solution.declaredFieldNames(Rectangle.class));
    }

    @Test
    void readPrivateField() throws Exception {
        assertEquals("s3cr3t", solution.readPrivateField(new Rectangle(1, 1), "secret"));
    }

    @Test
    void unknownMethod() {
        assertThrows(NoSuchMethodException.class, () -> solution.invoke(new Rectangle(1, 1), "perimeter"));
    }
}
