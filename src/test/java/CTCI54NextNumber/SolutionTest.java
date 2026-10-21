package CTCI54NextNumber;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    private final Solution solution = new Solution();

    private static int bruteNext(int n) {
        int bits = Integer.bitCount(n);
        for (long x = (long) n + 1; x <= Integer.MAX_VALUE; x++) {
            if (Long.bitCount(x) == bits) {
                return (int) x;
            }
        }
        return -1;
    }

    private static int brutePrev(int n) {
        int bits = Integer.bitCount(n);
        for (int x = n - 1; x > 0; x--) {
            if (Integer.bitCount(x) == bits) {
                return x;
            }
        }
        return -1;
    }

    @Test
    void bookStyleExample() {
        // 13948 = 11011001111100
        assertEquals(0b11011010001111, solution.getNext(0b11011001111100));
        // 10115 = 10011110000011
        assertEquals(0b10011101110000, solution.getPrev(0b10011110000011));
    }

    @Test
    void smallNumbersMatchBruteForce() {
        for (int n = 1; n <= 5000; n++) {
            assertEquals(bruteNext(n), solution.getNext(n), "getNext(" + n + ")");
            assertEquals(brutePrev(n), solution.getPrev(n), "getPrev(" + n + ")");
        }
    }

    @Test
    void noAnswer() {
        assertEquals(-1, solution.getPrev(0b111));     // não há menor com três 1s
        assertEquals(-1, solution.getPrev(1));
        assertEquals(-1, solution.getNext(Integer.MAX_VALUE));
        assertEquals(-1, solution.getNext(0x7FFF0000)); // 0111...1 000...0
    }

    @Test
    void bigNumbers() {
        assertEquals(0x40000000, solution.getNext(0x20000000));
        assertEquals(0x10000000, solution.getPrev(0x20000000));
        assertEquals(-1, solution.getPrev(Integer.MAX_VALUE)); // 31 uns: não existe menor positivo
    }
}
