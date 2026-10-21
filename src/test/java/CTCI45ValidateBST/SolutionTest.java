package CTCI45ValidateBST;

import common.TreeNode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SolutionTest {

    private final Solution solution = new Solution();

    @Test
    void validBsts() {
        assertTrue(solution.checkBST(null));
        assertTrue(solution.checkBST(new TreeNode(1)));
        assertTrue(solution.checkBST(TreeNode.of(2, 1, 3)));
        assertTrue(solution.checkBST(TreeNode.bstOf(20, 10, 30, 5, 15, 25, 35, 3, 7, 17)));
    }

    @Test
    void invalidBsts() {
        assertFalse(solution.checkBST(TreeNode.of(2, 3, 1)));
        assertFalse(solution.checkBST(TreeNode.of(10, 5, 20, null, null, 15, 30, 9)));
    }

    @Test
    void checksAgainstAllAncestorsNotOnlyTheParent() {
        //      20
        //     /  \
        //   10    30
        //     \
        //      25   <- 25 > 10 (ok com o pai), mas 25 > 20 (inválido)
        assertFalse(solution.checkBST(TreeNode.of(20, 10, 30, null, 25)));
    }

    @Test
    void duplicatesOnlyAllowedOnTheLeft() {
        assertTrue(solution.checkBST(TreeNode.of(2, 2, 3)));
        assertFalse(solution.checkBST(TreeNode.of(2, 1, 2)));
    }

    @Test
    void extremeValues() {
        assertTrue(solution.checkBST(TreeNode.of(Integer.MIN_VALUE, null, Integer.MAX_VALUE)));
        assertTrue(solution.checkBST(TreeNode.of(Integer.MAX_VALUE, Integer.MIN_VALUE)));
        assertFalse(solution.checkBST(TreeNode.of(Integer.MIN_VALUE, Integer.MAX_VALUE)));
    }
}
