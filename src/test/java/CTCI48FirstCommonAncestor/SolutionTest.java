package CTCI48FirstCommonAncestor;

import common.TreeNode;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;

class SolutionTest {

    private final Solution solution = new Solution();

    //            1
    //          /   \
    //         2     3
    //        / \     \
    //       4   5     6
    //      /   / \
    //     7   8   9
    private final TreeNode root = TreeNode.of(1, 2, 3, 4, 5, null, 6, 7, null, 8, 9);

    private TreeNode node(int v) {
        return TreeNode.find(root, v);
    }

    /** Ancestral comum calculado com os ponteiros parent (só no teste). */
    private TreeNode bruteForce(TreeNode p, TreeNode q) {
        Set<TreeNode> ancestors = new HashSet<>();
        for (TreeNode n = p; n != null; n = n.parent) {
            ancestors.add(n);
        }
        for (TreeNode n = q; n != null; n = n.parent) {
            if (ancestors.contains(n)) {
                return n;
            }
        }
        return null;
    }

    @Test
    void examples() {
        assertSame(node(2), solution.commonAncestor(root, node(7), node(9)));
        assertSame(node(5), solution.commonAncestor(root, node(8), node(9)));
        assertSame(node(1), solution.commonAncestor(root, node(8), node(6)));
    }

    @Test
    void nodeIsAncestorOfTheOther() {
        assertSame(node(2), solution.commonAncestor(root, node(2), node(8)));
        assertSame(node(1), solution.commonAncestor(root, node(6), node(1)));
        assertSame(node(4), solution.commonAncestor(root, node(4), node(4)));
    }

    @Test
    void allPairs() {
        List<TreeNode> nodes = new ArrayList<>();
        for (int v = 1; v <= 9; v++) {
            nodes.add(node(v));
        }
        for (TreeNode p : nodes) {
            for (TreeNode q : nodes) {
                assertSame(bruteForce(p, q), solution.commonAncestor(root, p, q), "p=" + p + " q=" + q);
            }
        }
    }

    @Test
    void nodeNotInTreeReturnsNull() {
        TreeNode outsider = new TreeNode(100);
        assertNull(solution.commonAncestor(root, node(7), outsider));
        assertNull(solution.commonAncestor(root, outsider, node(1)));
    }
}
