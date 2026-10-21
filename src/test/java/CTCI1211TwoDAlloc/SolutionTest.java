package CTCI1211TwoDAlloc;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    @Test
    void layoutIsHeaderThenData() {
        Solution.Matrix2D m = Solution.Matrix2D.my2DAlloc(3, 4);
        int[] backing = m.backingArray();
        assertEquals(3 + 12, backing.length, "Um único bloco: ponteiros + dados");
        assertEquals(3, backing[0]);
        assertEquals(7, backing[1]);
        assertEquals(11, backing[2]);
    }

    @Test
    void getAndSet() {
        int rows = 5;
        int cols = 7;
        Solution.Matrix2D m = Solution.Matrix2D.my2DAlloc(rows, cols);
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                m.set(i, j, i * 100 + j);
            }
        }
        int[] backing = m.backingArray();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                assertEquals(i * 100 + j, m.get(i, j));
                assertEquals(i * 100 + j, backing[backing[i] + j], "arr[i][j] == *(arr[i] + j)");
                assertEquals(i * 100 + j, backing[rows + i * cols + j], "Os dados são contíguos, linha a linha");
            }
        }
    }
}
