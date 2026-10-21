package CTCI126Volatile;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SolutionTest {

    @Test
    @Timeout(10)
    void stopsWhenAnotherThreadRequests() throws InterruptedException {
        for (int round = 0; round < 3; round++) {
            Solution.Worker worker = new Solution.Worker();
            Thread thread = new Thread(worker);
            thread.start();
            Thread.sleep(300); // deixa o JIT compilar o laço
            assertTrue(worker.isRunning());
            worker.requestStop();
            thread.join(3000);
            assertFalse(thread.isAlive(), "O worker não viu o pedido de parada (faltou volatile?)");
            assertFalse(worker.isRunning());
            assertTrue(worker.iterations() > 0);
        }
    }
}
