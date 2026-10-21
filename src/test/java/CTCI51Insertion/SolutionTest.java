package CTCI51Insertion;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    private final Solution solution = new Solution();

    @Test
    void bookExample() {
        assertEquals(0b10001001100, solution.updateBits(0b10000000000, 0b10011, 2, 6));
    }

    @Test
    void overwritesExistingBits() {
        // N = 11111111, M = 00, i = 2, j = 3 -> 11110011
        assertEquals(0b11110011, solution.updateBits(0b11111111, 0b00, 2, 3));
        // N = 0, M = 101, i = 0, j = 2 -> 101
        assertEquals(0b101, solution.updateBits(0, 0b101, 0, 2));
    }

    @Test
    void edgePositions() {
        assertEquals(1, solution.updateBits(0, 1, 0, 0));
        assertEquals(Integer.MIN_VALUE, solution.updateBits(0, 1, 31, 31));
        assertEquals(0x7FFFFFFF, solution.updateBits(-1, 0, 31, 31));
        assertEquals(0xABCD0000 | 0x1234, solution.updateBits(0xFFFF1234, 0xABCD, 16, 31));
        assertEquals(42, solution.updateBits(-1, 42, 0, 31));
    }
}
