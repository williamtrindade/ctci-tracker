package CTCI410CheckSubtree;

import common.TreeNode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SolutionTest {

    private final Solution solution = new Solution();

    //            3
    //          /   \
    //         4     5
    //        / \
    //       1   2
    private final TreeNode t1 = TreeNode.of(3, 4, 5, 1, 2);

    @Test
    void detectsSubtree() {
        assertTrue(solution.containsTree(t1, TreeNode.of(4, 1, 2)));
        assertTrue(solution.containsTree(t1, TreeNode.of(5)));
        assertTrue(solution.containsTree(t1, TreeNode.of(3, 4, 5, 1, 2)));
    }

    @Test
    void subtreeMustMatchUntilTheLeaves() {
        // 4 -> 1 existe em T1, mas em T1 o nó 4 também tem o filho 2
        assertFalse(solution.containsTree(t1, TreeNode.of(4, 1)));
        assertFalse(solution.containsTree(TreeNode.of(3, 4, 5, 1, 2, null, null, null, null, 0), TreeNode.of(4, 1, 2)));
    }

    @Test
    void structureMatters() {
        // Mesmos valores em pré-ordem se não marcarmos os nulos: 1,2 (2 à esquerda) vs 1,2 (2 à direita)
        TreeNode big = TreeNode.of(0, 1, 9, 2); // nó 1 com filho 2 à ESQUERDA
        TreeNode small = TreeNode.of(1, null, 2);
        assertFalse(solution.containsTree(big, small));
    }

    @Test
    void emptyTrees() {
        assertTrue(solution.containsTree(t1, null));
        assertTrue(solution.containsTree(null, null));
        assertFalse(solution.containsTree(null, TreeNode.of(1)));
    }

    @Test
    void repeatedRootValues() {
        //        1
        //       / \
        //      1   1
        //     /     \
        //    1       2
        TreeNode big = TreeNode.of(1, 1, 1, 1, null, null, 2);
        assertTrue(solution.containsTree(big, TreeNode.of(1, null, 2)));
        assertFalse(solution.containsTree(big, TreeNode.of(1, 2)));
    }
}
