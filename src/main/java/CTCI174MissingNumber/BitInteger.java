package CTCI174MissingNumber;

import java.util.concurrent.atomic.AtomicLong;

/** Inteiro do qual só é possível ler um bit por vez. Já implementado. */
public class BitInteger {
    public static final int INTEGER_SIZE = 32;
    private static final AtomicLong FETCHES = new AtomicLong();
    private final int value;

    public BitInteger(int value) {
        this.value = value;
    }

    /** Retorna o bit da coluna (0 = menos significativo). */
    public int fetch(int column) {
        if (column < 0 || column >= INTEGER_SIZE) {
            throw new IllegalArgumentException("coluna inválida");
        }
        FETCHES.incrementAndGet();
        return (value >>> column) & 1;
    }

    public static long fetchCount() {
        return FETCHES.get();
    }

    public static void resetFetchCount() {
        FETCHES.set(0);
    }
}
