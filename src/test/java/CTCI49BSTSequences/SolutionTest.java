package CTCI49BSTSequences;

import common.TreeNode;
import org.junit.jupiter.api.Test;

import java.math.BigInteger;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SolutionTest {

    private final Solution solution = new Solution();

    private static long binomial(int n, int k) {
        BigInteger r = BigInteger.ONE;
        for (int i = 0; i < k; i++) {
            r = r.multiply(BigInteger.valueOf(n - i)).divide(BigInteger.valueOf(i + 1));
        }
        return r.longValueExact();
    }

    /** Número esperado de sequências: C(L + R, L) * count(esq) * count(dir). */
    private static long expectedCount(TreeNode n) {
        if (n == null) {
            return 1;
        }
        int l = TreeNode.size(n.left);
        int r = TreeNode.size(n.right);
        return binomial(l + r, l) * expectedCount(n.left) * expectedCount(n.right);
    }

    private void checkTree(TreeNode root) {
        List<List<Integer>> sequences = solution.allSequences(root);
        Set<List<Integer>> distinct = new HashSet<>(sequences);
        assertEquals(sequences.size(), distinct.size(), "Não deve haver sequências repetidas");
        assertEquals(expectedCount(root), sequences.size(), "Quantidade de sequências");
        for (List<Integer> seq : sequences) {
            TreeNode rebuilt = TreeNode.bstOf(seq.stream().mapToInt(Integer::intValue).toArray());
            assertTrue(TreeNode.sameTree(root, rebuilt), () -> "A sequência " + seq + " não gera a mesma árvore");
        }
    }

    @Test
    void bookExample() {
        TreeNode root = TreeNode.bstOf(2, 1, 3);
        assertEquals(Set.of(List.of(2, 1, 3), List.of(2, 3, 1)), new HashSet<>(solution.allSequences(root)));
    }

    @Test
    void emptyTree() {
        assertEquals(List.of(List.of()), solution.allSequences(null));
    }

    @Test
    void singleNodeAndChains() {
        checkTree(TreeNode.bstOf(5));
        checkTree(TreeNode.bstOf(1, 2, 3, 4));
    }

    @Test
    void biggerTree() {
        //            50
        //         /      \
        //       20        60
        //      /  \         \
        //    10    25        70
        //   /  \            /  \
        //  5    15         65   80
        checkTree(TreeNode.bstOf(50, 20, 60, 10, 25, 70, 5, 15, 65, 80));
    }
}
