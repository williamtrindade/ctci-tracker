package CTCI153DiningPhilosophers;

import java.util.concurrent.locks.ReentrantLock;

/** Hashi: um lock. Já implementado. */
public class Chopstick {
    private final ReentrantLock lock = new ReentrantLock();
    private final int number;

    public Chopstick(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    public void pickUp() {
        lock.lock();
    }

    public boolean tryPickUp() {
        return lock.tryLock();
    }

    public void putDown() {
        lock.unlock();
    }

    public boolean isHeldByCurrentThread() {
        return lock.isHeldByCurrentThread();
    }
}
