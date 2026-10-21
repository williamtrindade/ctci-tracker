package CTCI44CheckBalanced;

import common.TreeNode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SolutionTest {

    private final Solution solution = new Solution();

    @Test
    void balancedTrees() {
        assertTrue(solution.isBalanced(null));
        assertTrue(solution.isBalanced(new TreeNode(1)));
        assertTrue(solution.isBalanced(TreeNode.of(1, 2)));
        assertTrue(solution.isBalanced(TreeNode.of(1, 2, 3, 4, 5, 6, 7)));
        assertTrue(solution.isBalanced(TreeNode.of(1, 2, 3, 4, null, null, 5)));
    }

    @Test
    void unbalancedTrees() {
        assertFalse(solution.isBalanced(TreeNode.of(1, 2, null, 3)));
        assertFalse(solution.isBalanced(TreeNode.of(1, 2, 3, 4, null, null, null, 5)));
    }

    @Test
    void rootBalancedButSubtreeUnbalanced() {
        //         1
        //       /   \
        //      2     3
        //     /       \
        //    4         5
        //   /           \
        //  6             7
        // Na raiz as alturas são iguais, mas os nós 2 e 3 estão desbalanceados.
        TreeNode root = TreeNode.of(1, 2, 3, 4, null, null, 5, 6, null, null, 7);
        assertFalse(solution.isBalanced(root));
    }
}
