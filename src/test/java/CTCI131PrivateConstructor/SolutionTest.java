package CTCI131PrivateConstructor;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SolutionTest {

    private static void assertOnlyPrivateConstructors(Class<?> c) {
        for (Constructor<?> constructor : c.getDeclaredConstructors()) {
            assertTrue(Modifier.isPrivate(constructor.getModifiers()), c.getSimpleName() + " tem construtor não privado");
        }
    }

    @Test
    void shapeHasOnlyPrivateConstructors() {
        assertOnlyPrivateConstructors(Solution.Shape.class);
    }

    @Test
    void nestedClassesCanStillExtendIt() {
        Solution.Shape c = Solution.Shape.circle(1);
        Solution.Shape s = Solution.Shape.square(3);
        assertTrue(c instanceof Solution.Shape.Circle);
        assertTrue(s instanceof Solution.Shape.Square);
        assertEquals(Math.PI, c.area(), 1e-9);
        assertEquals(9, s.area(), 1e-9);
        assertEquals(4, new Solution.Shape.Square(2).area(), 1e-9);
    }

    @Test
    void singleton() {
        assertOnlyPrivateConstructors(Solution.Registry.class);
        assertSame(Solution.Registry.getInstance(), Solution.Registry.getInstance());
    }
}
