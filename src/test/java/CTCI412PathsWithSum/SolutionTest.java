package CTCI412PathsWithSum;

import common.TreeNode;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    private final Solution solution = new Solution();

    /** Força bruta só para o teste: para cada nó, conta caminhos que começam nele. */
    private static int brute(TreeNode root, int target) {
        if (root == null) {
            return 0;
        }
        return fromNode(root, target, 0) + brute(root.left, target) + brute(root.right, target);
    }

    private static int fromNode(TreeNode node, int target, int sum) {
        if (node == null) {
            return 0;
        }
        sum += node.val;
        return (sum == target ? 1 : 0) + fromNode(node.left, target, sum) + fromNode(node.right, target, sum);
    }

    @Test
    void classicExample() {
        //          10
        //         /  \
        //        5    -3
        //       / \     \
        //      3   2     11
        //     / \   \
        //    3  -2   1
        TreeNode root = TreeNode.of(10, 5, -3, 3, 2, null, 11, 3, -2, null, 1);
        assertEquals(3, solution.countPathsWithSum(root, 8)); // 5->3, 5->2->1, -3->11
        assertEquals(3, solution.countPathsWithSum(root, 18)); // 10->5->3, 10->5->2->1, 10->-3->11
    }

    @Test
    void emptyTreeAndSingleNode() {
        assertEquals(0, solution.countPathsWithSum(null, 0));
        assertEquals(1, solution.countPathsWithSum(new TreeNode(5), 5));
        assertEquals(0, solution.countPathsWithSum(new TreeNode(5), 4));
    }

    @Test
    void zerosCreateManyPaths() {
        TreeNode root = TreeNode.of(0, 0, 0, 0);
        // caminhos de soma 0: cada nó sozinho (4) + 0->0 (3) + 0->0->0 (1) = 8
        assertEquals(8, solution.countPathsWithSum(root, 0));
    }

    @Test
    void randomTreesMatchBruteForce() {
        Random random = new Random(99);
        for (int t = 0; t < 100; t++) {
            Integer[] values = new Integer[random.nextInt(30) + 1];
            for (int i = 0; i < values.length; i++) {
                values[i] = random.nextInt(5) == 0 ? null : random.nextInt(11) - 5;
            }
            values[0] = random.nextInt(11) - 5;
            TreeNode root = TreeNode.of(values);
            int target = random.nextInt(11) - 5;
            assertEquals(brute(root, target), solution.countPathsWithSum(root, target));
        }
    }
}
