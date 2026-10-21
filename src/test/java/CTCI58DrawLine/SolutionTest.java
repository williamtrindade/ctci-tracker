package CTCI58DrawLine;

import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class SolutionTest {

    private final Solution solution = new Solution();

    private static byte[] expected(byte[] initial, int width, int x1, int x2, int y) {
        byte[] screen = initial.clone();
        for (int x = x1; x <= x2; x++) {
            int index = y * (width / 8) + x / 8;
            screen[index] |= (byte) (0x80 >>> (x % 8));
        }
        return screen;
    }

    private void check(byte[] initial, int width, int x1, int x2, int y) {
        byte[] screen = initial.clone();
        solution.drawLine(screen, width, x1, x2, y);
        assertArrayEquals(expected(initial, width, x1, x2, y), screen,
                () -> "width=" + width + " x1=" + x1 + " x2=" + x2 + " y=" + y);
    }

    @Test
    void lineInsideOneByte() {
        check(new byte[4], 16, 2, 5, 1);   // 00111100 no byte 2
        check(new byte[4], 16, 0, 0, 0);
        check(new byte[4], 16, 7, 7, 0);
        check(new byte[4], 16, 0, 7, 0);
    }

    @Test
    void lineAcrossBytes() {
        check(new byte[12], 32, 3, 27, 2);
        check(new byte[12], 32, 0, 31, 1);
        check(new byte[12], 32, 7, 8, 0);
    }

    @Test
    void allPossibleLinesOnSmallScreen() {
        int width = 24;
        int height = 3;
        for (int y = 0; y < height; y++) {
            for (int x1 = 0; x1 < width; x1++) {
                for (int x2 = x1; x2 < width; x2++) {
                    check(new byte[width / 8 * height], width, x1, x2, y);
                }
            }
        }
    }

    @Test
    void keepsExistingPixels() {
        Random random = new Random(4);
        byte[] screen = new byte[64];
        random.nextBytes(screen);
        check(screen, 64, 5, 50, 3);
        check(screen, 64, 9, 14, 7);
    }
}
