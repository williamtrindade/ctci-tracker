package CTCI610Poison;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/** Laboratório com garrafas e tiras de teste. Já implementado. */
public class PoisonLab {
    private final int bottleCount;
    private final int stripCount;
    private final int poisonedBottle;
    private final List<Set<Integer>> pendingDrops = new ArrayList<>();
    private final boolean[] positive;
    private int daysElapsed = 0;

    public PoisonLab(int bottleCount, int stripCount, int poisonedBottle) {
        this.bottleCount = bottleCount;
        this.stripCount = stripCount;
        this.poisonedBottle = poisonedBottle;
        this.positive = new boolean[stripCount];
        for (int i = 0; i < stripCount; i++) {
            pendingDrops.add(new HashSet<>());
        }
    }

    public int getBottleCount() {
        return bottleCount;
    }

    public int getStripCount() {
        return stripCount;
    }

    /** Pinga uma gota da garrafa (0-based) na tira (0-based). */
    public void addDrop(int bottle, int strip) {
        if (bottle < 0 || bottle >= bottleCount || strip < 0 || strip >= stripCount) {
            throw new IllegalArgumentException("garrafa/tira inválida");
        }
        if (positive[strip]) {
            throw new IllegalStateException("A tira " + strip + " já está positiva e não pode ser reutilizada");
        }
        pendingDrops.get(strip).add(bottle);
    }

    /** Roda todos os testes pendentes; o resultado leva 7 dias. Retorna as tiras positivas (acumulado). */
    public List<Integer> runTestsAndWait() {
        daysElapsed += 7;
        List<Integer> result = new ArrayList<>();
        for (int strip = 0; strip < stripCount; strip++) {
            if (pendingDrops.get(strip).contains(poisonedBottle)) {
                positive[strip] = true;
            }
            pendingDrops.get(strip).clear();
            if (positive[strip]) {
                result.add(strip);
            }
        }
        return result;
    }

    public int getDaysElapsed() {
        return daysElapsed;
    }
}
