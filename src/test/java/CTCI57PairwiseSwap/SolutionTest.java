package CTCI57PairwiseSwap;

import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    private final Solution solution = new Solution();

    private static int brute(int x) {
        int result = 0;
        for (int i = 0; i < 32; i += 2) {
            int even = (x >>> i) & 1;
            int odd = (x >>> (i + 1)) & 1;
            result |= (even << (i + 1)) | (odd << i);
        }
        return result;
    }

    @Test
    void examples() {
        assertEquals(0b01, solution.swapOddEvenBits(0b10));
        assertEquals(0b10, solution.swapOddEvenBits(0b01));
        assertEquals(0b0101, solution.swapOddEvenBits(0b1010));
        assertEquals(0b100110, solution.swapOddEvenBits(0b011001));
        assertEquals(-1, solution.swapOddEvenBits(-1));
        assertEquals(0, solution.swapOddEvenBits(0));
    }

    @Test
    void signBitIsSwappedToo() {
        assertEquals(0x40000000, solution.swapOddEvenBits(Integer.MIN_VALUE));
        assertEquals(Integer.MIN_VALUE, solution.swapOddEvenBits(0x40000000));
        assertEquals(0x55555555, solution.swapOddEvenBits(0xAAAAAAAA));
    }

    @Test
    void randomNumbers() {
        Random random = new Random(21);
        for (int t = 0; t < 1000; t++) {
            int x = random.nextInt();
            assertEquals(brute(x), solution.swapOddEvenBits(x));
        }
    }
}
