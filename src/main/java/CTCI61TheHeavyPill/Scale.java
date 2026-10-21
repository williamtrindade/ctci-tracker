package CTCI61TheHeavyPill;

/** Balança exata que só pode ser usada uma vez. Já implementada. */
public class Scale {
    private final int heavyBottle;
    private final int bottleCount;
    private boolean used = false;

    public Scale(int bottleCount, int heavyBottle) {
        this.bottleCount = bottleCount;
        this.heavyBottle = heavyBottle;
    }

    /**
     * @param pillsFromEachBottle quantos comprimidos colocar na balança de cada frasco (tamanho = número de frascos)
     * @return o peso total em gramas
     */
    public double weigh(int[] pillsFromEachBottle) {
        if (used) {
            throw new IllegalStateException("A balança só pode ser usada uma vez!");
        }
        if (pillsFromEachBottle.length != bottleCount) {
            throw new IllegalArgumentException("Informe a quantidade de comprimidos de cada um dos " + bottleCount + " frascos");
        }
        used = true;
        double total = 0;
        for (int i = 0; i < pillsFromEachBottle.length; i++) {
            total += pillsFromEachBottle[i] * (i == heavyBottle ? 1.1 : 1.0);
        }
        return total;
    }
}
