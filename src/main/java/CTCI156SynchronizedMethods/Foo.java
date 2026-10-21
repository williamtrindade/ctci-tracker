package CTCI156SynchronizedMethods;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * Cada método "entra", avisa que entrou e espera até 300 ms a outra thread também entrar. Se as duas
 * conseguirem estar dentro ao mesmo tempo, o latch chega a zero. Já implementado.
 */
public class Foo {
    private final CountDownLatch bothInside;

    public Foo(CountDownLatch bothInside) {
        this.bothInside = bothInside;
    }

    public synchronized boolean methodA() throws InterruptedException {
        return meet(bothInside);
    }

    public boolean methodB() throws InterruptedException {
        return meet(bothInside);
    }

    public static synchronized boolean methodC(CountDownLatch latch) throws InterruptedException {
        return meet(latch);
    }

    private static boolean meet(CountDownLatch latch) throws InterruptedException {
        latch.countDown();
        return latch.await(300, TimeUnit.MILLISECONDS);
    }
}
