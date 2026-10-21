package CTCI124VirtualFunctions;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Locale;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    @Test
    void dynamicDispatchThroughBaseReference() {
        Solution.Shape s = new Solution.Circle(1);
        assertEquals(Math.PI, s.area(), 1e-9);
        assertEquals("circle", s.name());
        Solution.Shape q = new Solution.Square(2);
        assertEquals(4, q.area(), 1e-9);
        assertEquals("square", q.name());
    }

    @Test
    void nonOverriddenMethodCallsVirtualOnes() {
        Locale previous = Locale.getDefault();
        Locale.setDefault(Locale.US);
        try {
            assertEquals(List.of("circle with area 3.14", "square with area 9.00"),
                    Solution.describeAll(List.of(new Solution.Circle(1), new Solution.Square(3))));
        } finally {
            Locale.setDefault(previous);
        }
    }

    @Test
    void staticMethodsAreBoundByTheDeclaredType() {
        assertEquals("shape", Solution.Shape.staticName());
        assertEquals("circle", Solution.Circle.staticName());
        assertEquals("square", Solution.Square.staticName());
    }
}
