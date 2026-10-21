package CTCI151ThreadVsProcess;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

@Timeout(30)
class SolutionTest {

    private final Solution solution = new Solution();

    @Test
    void threadsShareMemory() throws Exception {
        assertEquals(8 * 100_000, solution.incrementWithThreads(8, 100_000));
    }

    @Test
    void threadsLiveInTheSameProcess() throws Exception {
        assertEquals(Set.of(ProcessHandle.current().pid()), solution.processIdsSeenByThreads(10));
    }

    @Test
    void childProcessHasItsOwnPid() throws Exception {
        assertNotEquals(ProcessHandle.current().pid(), solution.startChildProcessAndGetPid());
    }
}
