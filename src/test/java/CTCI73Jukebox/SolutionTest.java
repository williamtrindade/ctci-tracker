package CTCI73Jukebox;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SolutionTest {

    private final Song yesterday = new Song("Yesterday", "The Beatles");
    private final Song imagine = new Song("Imagine", "John Lennon");
    private final Song help = new Song("Help!", "The Beatles");

    private Solution.Jukebox jukebox() {
        Solution.Jukebox jukebox = new Solution.Jukebox();
        jukebox.addToLibrary(yesterday);
        jukebox.addToLibrary(imagine);
        jukebox.addToLibrary(help);
        return jukebox;
    }

    @Test
    void playsSongsInQueueOrder() {
        Solution.Jukebox jukebox = jukebox();
        assertTrue(jukebox.enqueue("Imagine"));
        assertTrue(jukebox.enqueue("Yesterday"));
        assertEquals(List.of(imagine, yesterday), jukebox.getQueue());
        assertNull(jukebox.getCurrentSong());
        assertEquals(imagine, jukebox.playNext());
        assertEquals(imagine, jukebox.getCurrentSong());
        assertEquals(List.of(yesterday), jukebox.getQueue());
        assertEquals(yesterday, jukebox.playNext());
        assertNull(jukebox.playNext());
        assertNull(jukebox.getCurrentSong());
        assertEquals(List.of(imagine, yesterday), jukebox.getHistory());
    }

    @Test
    void cannotEnqueueUnknownSong() {
        Solution.Jukebox jukebox = jukebox();
        assertFalse(jukebox.enqueue("Bohemian Rhapsody"));
        assertTrue(jukebox.getQueue().isEmpty());
    }

    @Test
    void sameSongCanBeQueuedTwice() {
        Solution.Jukebox jukebox = jukebox();
        jukebox.enqueue("Help!");
        jukebox.enqueue("Help!");
        assertEquals(List.of(help, help), jukebox.getQueue());
    }

    @Test
    void queueIsACopy() {
        Solution.Jukebox jukebox = jukebox();
        jukebox.enqueue("Help!");
        jukebox.getQueue().clear();
        assertEquals(1, jukebox.getQueue().size());
    }
}
