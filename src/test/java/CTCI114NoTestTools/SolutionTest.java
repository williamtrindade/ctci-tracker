package CTCI114NoTestTools;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import java.util.concurrent.atomic.AtomicInteger;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@Timeout(20)
class SolutionTest {

    private final Solution solution = new Solution();

    @Test
    void countsRequestsAndFailures() throws Exception {
        AtomicInteger calls = new AtomicInteger();
        LoadTestReport report = solution.loadTest(() -> {
            int n = calls.incrementAndGet();
            if (n % 10 == 0) {
                throw new RuntimeException("500 Internal Server Error");
            }
            return n % 10 != 5; // a 5ª de cada 10 retorna "false"
        }, 10, 50);
        assertEquals(500, calls.get());
        assertEquals(500, report.totalRequests());
        assertEquals(100, report.failures());
    }

    @Test
    void measuresLatency() throws Exception {
        LoadTestReport report = solution.loadTest(() -> {
            Thread.sleep(20);
            return true;
        }, 4, 5);
        assertEquals(0, report.failures());
        assertTrue(report.averageLatencyMillis() >= 19, "média = " + report.averageLatencyMillis());
        assertTrue(report.maxLatencyMillis() >= report.averageLatencyMillis());
    }

    @Test
    void usersRunInParallel() throws Exception {
        AtomicInteger concurrent = new AtomicInteger();
        AtomicInteger maxConcurrent = new AtomicInteger();
        long begin = System.nanoTime();
        solution.loadTest(() -> {
            int now = concurrent.incrementAndGet();
            maxConcurrent.accumulateAndGet(now, Math::max);
            Thread.sleep(50);
            concurrent.decrementAndGet();
            return true;
        }, 10, 2);
        long elapsedMillis = (System.nanoTime() - begin) / 1_000_000;
        assertTrue(maxConcurrent.get() > 1, "As requisições devem rodar em paralelo");
        assertTrue(elapsedMillis < 900, "10 usuários x 2 x 50ms em série levariam 1s; levou " + elapsedMillis + "ms");
    }
}
