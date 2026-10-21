package CTCI46Successor;

import common.TreeNode;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class SolutionTest {

    private final Solution solution = new Solution();

    private void checkAllNodes(TreeNode root) {
        List<Integer> order = TreeNode.inOrder(root);
        for (int i = 0; i < order.size(); i++) {
            TreeNode node = TreeNode.find(root, order.get(i));
            TreeNode succ = solution.inorderSucc(node);
            if (i == order.size() - 1) {
                assertNull(succ, "O último nó não tem sucessor");
            } else {
                assertEquals(order.get(i + 1), succ == null ? null : succ.val, "Sucessor de " + order.get(i));
            }
        }
    }

    @Test
    void sampleTree() {
        //          20
        //        /    \
        //      8       22
        //     / \
        //    4   12
        //       /  \
        //     10    14
        checkAllNodes(TreeNode.bstOf(20, 8, 22, 4, 12, 10, 14));
    }

    @Test
    void degenerateTrees() {
        checkAllNodes(TreeNode.bstOf(1, 2, 3, 4, 5));
        checkAllNodes(TreeNode.bstOf(5, 4, 3, 2, 1));
    }

    @Test
    void randomTrees() {
        Random random = new Random(1);
        for (int t = 0; t < 20; t++) {
            int[] values = random.ints(0, 1000).distinct().limit(40).toArray();
            checkAllNodes(TreeNode.bstOf(values));
        }
    }

    @Test
    void nullNode() {
        assertNull(solution.inorderSucc(null));
    }
}
