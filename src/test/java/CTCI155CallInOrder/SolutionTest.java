package CTCI155CallInOrder;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    private interface Call {
        void run(Solution.Foo foo, List<String> log) throws InterruptedException;
    }

    private static Thread thread(Solution.Foo foo, List<String> log, Call call) {
        return new Thread(() -> {
            try {
                call.run(foo, log);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });
    }

    private void runInOrder(int... startOrder) throws InterruptedException {
        Solution.Foo foo = new Solution.Foo();
        List<String> log = Collections.synchronizedList(new ArrayList<>());
        Thread[] threads = {
                thread(foo, log, (f, l) -> f.first(() -> l.add("first"))),
                thread(foo, log, (f, l) -> f.second(() -> l.add("second"))),
                thread(foo, log, (f, l) -> f.third(() -> l.add("third")))
        };
        for (int i : startOrder) {
            threads[i].start();
            Thread.sleep(5); // dá tempo de a thread "chegar" antes da próxima
        }
        for (Thread t : threads) {
            t.join();
        }
        assertEquals(List.of("first", "second", "third"), log);
    }

    @Test
    @Timeout(10)
    void respectsOrderRegardlessOfStartOrder() throws Exception {
        int[][] orders = {{0, 1, 2}, {2, 1, 0}, {1, 2, 0}, {2, 0, 1}, {1, 0, 2}, {0, 2, 1}};
        for (int round = 0; round < 10; round++) {
            for (int[] order : orders) {
                runInOrder(order);
            }
        }
    }
}
