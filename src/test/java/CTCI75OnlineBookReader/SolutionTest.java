package CTCI75OnlineBookReader;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SolutionTest {

    private Solution.OnlineReaderSystem system;
    private final Book ctci = new Book(1, "Cracking the Coding Interview", 3);
    private final Book clrs = new Book(2, "CLRS", 100);

    @BeforeEach
    void setUp() {
        system = new Solution.OnlineReaderSystem();
        system.addBook(ctci);
        system.addBook(clrs);
        system.addUser(new User(10, "Ana"));
        system.addUser(new User(20, "Bruno"));
    }

    @Test
    void libraryAndUsers() {
        assertEquals(ctci, system.findBook(1));
        assertEquals("Ana", system.findUser(10).name());
        assertTrue(system.removeBook(2));
        assertFalse(system.removeBook(2));
        assertNull(system.findBook(2));
        assertThrows(IllegalArgumentException.class, () -> system.setActiveUser(99));
    }

    @Test
    void readingRequiresActiveUser() {
        assertThrows(IllegalStateException.class, () -> system.openBook(1));
    }

    @Test
    void turnPagesWithinBounds() {
        system.setActiveUser(10);
        system.openBook(1);
        assertEquals(1, system.getCurrentPage());
        system.turnPageBackward();
        assertEquals(1, system.getCurrentPage());
        system.turnPageForward();
        system.turnPageForward();
        system.turnPageForward();
        assertEquals(3, system.getCurrentPage());
    }

    @Test
    void eachUserResumesWhereTheyStopped() {
        system.setActiveUser(10);
        system.openBook(2);
        for (int i = 0; i < 9; i++) {
            system.turnPageForward();
        }
        assertEquals(10, system.getCurrentPage());

        system.setActiveUser(20);
        system.openBook(2);
        assertEquals(1, system.getCurrentPage());
        system.turnPageForward();

        system.setActiveUser(10);
        system.openBook(1);
        assertEquals(1, system.getCurrentPage());
        system.openBook(2);
        assertEquals(10, system.getCurrentPage());

        system.setActiveUser(20);
        system.openBook(2);
        assertEquals(2, system.getCurrentPage());
    }
}
