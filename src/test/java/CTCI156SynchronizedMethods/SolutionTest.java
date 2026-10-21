package CTCI156SynchronizedMethods;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Timeout(10)
class SolutionTest {

    private final Solution solution = new Solution();

    /** Roda as duas chamadas em paralelo; true se as duas conseguiram estar "dentro" ao mesmo tempo. */
    private static boolean ranConcurrently(Callable<Boolean> a, Callable<Boolean> b) throws Exception {
        ExecutorService pool = Executors.newFixedThreadPool(2);
        try {
            Future<Boolean> fa = pool.submit(a);
            Future<Boolean> fb = pool.submit(b);
            return fa.get() && fb.get();
        } finally {
            pool.shutdownNow();
        }
    }

    @Test
    void synchronizedOnSameInstance() throws Exception {
        CountDownLatch latch = new CountDownLatch(2);
        Foo foo = new Foo(latch);
        boolean experiment = ranConcurrently(foo::methodA, foo::methodA);
        assertEquals(false, experiment);
        assertEquals(experiment, solution.canRunSynchronizedOnSameInstance());
    }

    @Test
    void synchronizedOnDifferentInstances() throws Exception {
        CountDownLatch latch = new CountDownLatch(2);
        Foo foo1 = new Foo(latch);
        Foo foo2 = new Foo(latch);
        boolean experiment = ranConcurrently(foo1::methodA, foo2::methodA);
        assertEquals(true, experiment);
        assertEquals(experiment, solution.canRunSynchronizedOnDifferentInstances());
    }

    @Test
    void synchronizedAndNormalOnSameInstance() throws Exception {
        CountDownLatch latch = new CountDownLatch(2);
        Foo foo = new Foo(latch);
        boolean experiment = ranConcurrently(foo::methodA, foo::methodB);
        assertEquals(true, experiment);
        assertEquals(experiment, solution.canRunSynchronizedAndNormalOnSameInstance());
    }

    @Test
    void staticSynchronized() throws Exception {
        CountDownLatch latch = new CountDownLatch(2);
        boolean experiment = ranConcurrently(() -> Foo.methodC(latch), () -> Foo.methodC(latch));
        assertEquals(false, experiment);
        assertEquals(experiment, solution.canRunStaticSynchronizedOnDifferentInstances());
    }
}
