package CTCI153DiningPhilosophers;

import java.util.concurrent.atomic.AtomicInteger;

/** Registra as refeições e detecta quem tenta comer sem os dois hashis. Já implementado. */
public class MealLog {
    private final AtomicInteger meals = new AtomicInteger();
    private final AtomicInteger violations = new AtomicInteger();

    public void eat(int philosopher, Chopstick left, Chopstick right) {
        if (!left.isHeldByCurrentThread() || !right.isHeldByCurrentThread()) {
            violations.incrementAndGet();
        }
        meals.incrementAndGet();
        Thread.yield(); // "mastigando"
    }

    public int totalMeals() {
        return meals.get();
    }

    public int violations() {
        return violations.get();
    }
}
