package CTCI104SortedSearchNoSize;

/** Estrutura sem size(): elementAt retorna -1 fora dos limites. Já implementada. */
public class Listy {
    private final int[] array;
    private int accesses = 0;

    public Listy(int[] array) {
        this.array = array.clone();
    }

    public int elementAt(int index) {
        accesses++;
        if (index < 0 || index >= array.length) {
            return -1;
        }
        return array[index];
    }

    /** Quantas vezes elementAt foi chamado (usado pelos testes). */
    public int getAccesses() {
        return accesses;
    }
}
