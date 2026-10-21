package CTCI42MinimalTree;

import common.TreeNode;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class SolutionTest {

    private final Solution solution = new Solution();

    private static int minimalHeight(int n) {
        // menor altura (em nós) capaz de conter n nós: ceil(log2(n + 1))
        int h = 0;
        while ((1 << h) - 1 < n) {
            h++;
        }
        return h;
    }

    private void check(int[] array) {
        TreeNode root = solution.createMinimalBST(array);
        List<Integer> expected = Arrays.stream(array).boxed().collect(Collectors.toList());
        assertEquals(expected, TreeNode.inOrder(root), "O percurso em ordem deve ser o próprio array (é uma BST)");
        assertEquals(minimalHeight(array.length), TreeNode.height(root), "Altura deve ser mínima");
    }

    @Test
    void emptyArray() {
        assertNull(solution.createMinimalBST(new int[0]));
    }

    @Test
    void smallArrays() {
        check(new int[]{1});
        check(new int[]{1, 2});
        check(new int[]{1, 2, 3});
        check(new int[]{2, 4, 6, 8, 10, 12, 14, 16, 18, 20});
    }

    @Test
    void manySizes() {
        for (int n = 1; n <= 200; n++) {
            check(IntStream.range(0, n).map(i -> i * 3 - 50).toArray());
        }
    }
}
