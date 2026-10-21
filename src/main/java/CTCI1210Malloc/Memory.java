package CTCI1210Malloc;

import java.util.TreeMap;

/** Heap simulado com endereços não alinhados. Já implementado. */
public class Memory {
    private final byte[] heap = new byte[1 << 22];
    private final TreeMap<Integer, Integer> blocks = new TreeMap<>(); // início -> tamanho
    private int next = 13; // começa desalinhado de propósito

    public int malloc(int bytes) {
        if (bytes <= 0) {
            throw new IllegalArgumentException("bytes deve ser positivo");
        }
        int address = next;
        if (address + bytes > heap.length) {
            throw new OutOfMemoryError("heap simulado cheio");
        }
        blocks.put(address, bytes);
        next = address + bytes + 3; // mantém os próximos endereços desalinhados
        return address;
    }

    public void free(int address) {
        if (blocks.remove(address) == null) {
            throw new IllegalArgumentException("free() de endereço que não veio de malloc(): " + address);
        }
    }

    private void check(int address, int length) {
        var entry = blocks.floorEntry(address);
        if (entry == null || address + length > entry.getKey() + entry.getValue()) {
            throw new IllegalStateException("Segmentation fault: acesso fora de bloco alocado em " + address);
        }
    }

    public void writeInt(int address, int value) {
        check(address, 4);
        for (int i = 0; i < 4; i++) {
            heap[address + i] = (byte) (value >>> (8 * i));
        }
    }

    public int readInt(int address) {
        check(address, 4);
        int value = 0;
        for (int i = 0; i < 4; i++) {
            value |= (heap[address + i] & 0xFF) << (8 * i);
        }
        return value;
    }

    public void writeByte(int address, byte value) {
        check(address, 1);
        heap[address] = value;
    }

    public int allocatedBlocks() {
        return blocks.size();
    }
}
