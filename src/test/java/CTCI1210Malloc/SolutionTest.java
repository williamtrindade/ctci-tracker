package CTCI1210Malloc;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    private final Solution solution = new Solution();

    @Test
    void bookExample() {
        Memory memory = new Memory();
        int p = solution.alignedMalloc(memory, 1000, 128);
        assertEquals(0, p % 128, "Endereço deve ser múltiplo de 128");
        // os 1000 bytes devem ser utilizáveis
        assertDoesNotThrow(() -> {
            memory.writeInt(p, 1);
            memory.writeInt(p + 996, 2);
            memory.writeByte(p + 999, (byte) 3);
        });
        solution.alignedFree(memory, p);
        assertEquals(0, memory.allocatedBlocks(), "aligned_free deve liberar o bloco original");
    }

    @Test
    void manyAlignments() {
        Memory memory = new Memory();
        List<Integer> pointers = new ArrayList<>();
        for (int alignment = 1; alignment <= 4096; alignment *= 2) {
            for (int size : new int[]{1, 7, 64, 1000}) {
                int p = solution.alignedMalloc(memory, size, alignment);
                assertEquals(0, p % alignment, "alignment=" + alignment);
                int last = p + size - 1;
                assertDoesNotThrow(() -> memory.writeByte(last, (byte) 1));
                pointers.add(p);
            }
        }
        for (int p : pointers) {
            solution.alignedFree(memory, p);
        }
        assertEquals(0, memory.allocatedBlocks());
    }
}
