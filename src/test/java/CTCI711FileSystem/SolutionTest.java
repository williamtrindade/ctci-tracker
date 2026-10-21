package CTCI711FileSystem;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SolutionTest {

    private Solution.Directory root;
    private Solution.Directory home;
    private Solution.Directory docs;
    private Solution.File notes;
    private Solution.File cv;

    @BeforeEach
    void setUp() {
        root = new Solution.Directory("", null);
        home = new Solution.Directory("home", root);
        docs = new Solution.Directory("docs", home);
        notes = new Solution.File("notes.txt", home, "hello");
        cv = new Solution.File("cv.pdf", docs, "1234567890");
        new Solution.Directory("tmp", root);
    }

    @Test
    void fullPaths() {
        assertEquals("/", root.getFullPath());
        assertEquals("/home", home.getFullPath());
        assertEquals("/home/docs/cv.pdf", cv.getFullPath());
        assertSame(docs, cv.getParent());
    }

    @Test
    void sizesAndCounts() {
        assertEquals(5, notes.size());
        assertEquals(15, root.size());
        assertEquals(10, docs.size());
        assertEquals(2, root.numberOfFiles());
        assertEquals(2, root.getContents().size());
    }

    @Test
    void resolvePaths() {
        assertSame(cv, root.resolve("home/docs/cv.pdf"));
        assertSame(docs, home.resolve("docs"));
        assertNull(root.resolve("home/nope"));
        assertNull(root.resolve("home/notes.txt/x"));
    }

    @Test
    void deleteAndRename() {
        assertTrue(docs.delete());
        assertEquals(1, root.numberOfFiles());
        assertEquals(5, root.size());
        assertNull(root.resolve("home/docs"));
        assertFalse(root.delete());
        notes.rename("todo.txt");
        assertEquals("/home/todo.txt", notes.getFullPath());
        notes.setContent("abc");
        assertEquals(3, home.size());
    }
}
