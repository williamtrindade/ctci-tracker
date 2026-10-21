package CTCI98Pastebin;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SolutionTest {

    private long now = 1_000_000;

    private Solution.Pastebin pastebin() {
        return new Solution.Pastebin(new Random(1), () -> now);
    }

    @Test
    void createAndRead() {
        Solution.Pastebin bin = pastebin();
        String key = bin.createPaste("hello world", 0);
        assertTrue(key.matches("[a-zA-Z0-9]{10}"), key);
        assertEquals("hello world", bin.getPaste(key));
        assertNull(bin.getPaste("doesNotExist"));
    }

    @Test
    void sameContentGetsDifferentKeys() {
        Solution.Pastebin bin = pastebin();
        Set<String> keys = new HashSet<>();
        for (int i = 0; i < 1000; i++) {
            keys.add(bin.createPaste("same text", 0));
        }
        assertEquals(1000, keys.size());
    }

    @Test
    void expiration() {
        Solution.Pastebin bin = pastebin();
        String temporary = bin.createPaste("temp", 1000);
        String forever = bin.createPaste("forever", 0);
        now += 999;
        assertEquals("temp", bin.getPaste(temporary));
        now += 1;
        assertNull(bin.getPaste(temporary));
        now += 1_000_000_000L;
        assertEquals("forever", bin.getPaste(forever));
    }

    @Test
    void countsViews() {
        Solution.Pastebin bin = pastebin();
        String a = bin.createPaste("a", 0);
        String b = bin.createPaste("b", 0);
        assertNotEquals(a, b);
        bin.getPaste(a);
        bin.getPaste(a);
        bin.getPaste(b);
        assertEquals(2, bin.getViews(a));
        assertEquals(1, bin.getViews(b));
        assertEquals(0, bin.getViews("nope"));
    }
}
