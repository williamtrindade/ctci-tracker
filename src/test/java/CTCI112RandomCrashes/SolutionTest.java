package CTCI112RandomCrashes;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    @Test
    void deliversEventsToSubscribers() {
        Solution.EventBus bus = new Solution.EventBus();
        List<String> received = new ArrayList<>();
        Subscription s = bus.subscribe(received::add);
        bus.publish("a");
        bus.publish("b");
        s.cancel();
        bus.publish("c");
        assertEquals(List.of("a", "b"), received);
        assertEquals(0, bus.subscriberCount());
    }

    @Test
    void listenerCanCancelItselfDuringPublish() {
        Solution.EventBus bus = new Solution.EventBus();
        List<String> log = new ArrayList<>();
        Subscription[] self = new Subscription[1];
        self[0] = bus.subscribe(e -> {
            log.add("once:" + e);
            self[0].cancel();
        });
        bus.subscribe(e -> log.add("always:" + e));
        bus.publish("1");
        bus.publish("2");
        assertEquals(List.of("once:1", "always:1", "always:2"), log);
    }

    @Test
    void listenerSubscribedDuringPublishOnlyGetsNextEvents() {
        Solution.EventBus bus = new Solution.EventBus();
        List<String> log = new ArrayList<>();
        bus.subscribe(e -> {
            if (e.equals("first")) {
                bus.subscribe(x -> log.add("late:" + x));
            }
        });
        bus.publish("first");
        bus.publish("second");
        assertEquals(List.of("late:second"), log);
    }

    @Test
    @Timeout(10)
    void concurrentUseDoesNotCrash() throws Exception {
        Solution.EventBus bus = new Solution.EventBus();
        AtomicInteger delivered = new AtomicInteger();
        ExecutorService pool = Executors.newFixedThreadPool(8);
        CountDownLatch start = new CountDownLatch(1);
        List<Future<?>> futures = new ArrayList<>();
        for (int t = 0; t < 8; t++) {
            futures.add(pool.submit(() -> {
                start.await();
                for (int i = 0; i < 2000; i++) {
                    Subscription s = bus.subscribe(e -> delivered.incrementAndGet());
                    bus.publish("event");
                    s.cancel();
                }
                return null;
            }));
        }
        start.countDown();
        for (Future<?> f : futures) {
            f.get(); // propaga qualquer exceção (ex.: ConcurrentModificationException)
        }
        pool.shutdown();
        pool.awaitTermination(5, TimeUnit.SECONDS);
        assertEquals(0, bus.subscriberCount());
    }
}
