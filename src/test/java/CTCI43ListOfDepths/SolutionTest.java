package CTCI43ListOfDepths;

import common.TreeNode;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SolutionTest {

    private final Solution solution = new Solution();

    private List<List<Integer>> values(List<LinkedList<TreeNode>> levels) {
        return levels.stream()
                .map(level -> level.stream().map(n -> n.val).collect(Collectors.toList()))
                .collect(Collectors.toList());
    }

    @Test
    void completeTree() {
        TreeNode root = TreeNode.of(1, 2, 3, 4, 5, 6, 7);
        assertEquals(List.of(List.of(1), List.of(2, 3), List.of(4, 5, 6, 7)),
                values(solution.createLevelLinkedList(root)));
    }

    @Test
    void unbalancedTree() {
        TreeNode root = TreeNode.of(1, 2, null, 3, 4, null, null, 5);
        assertEquals(List.of(List.of(1), List.of(2), List.of(3, 4), List.of(5)),
                values(solution.createLevelLinkedList(root)));
    }

    @Test
    void returnsTheActualNodes() {
        TreeNode root = TreeNode.of(1, 2, 3);
        List<LinkedList<TreeNode>> levels = solution.createLevelLinkedList(root);
        assertTrue(levels.get(0).getFirst() == root);
        assertTrue(levels.get(1).getFirst() == root.left);
        assertTrue(levels.get(1).getLast() == root.right);
    }

    @Test
    void emptyAndSingle() {
        assertTrue(solution.createLevelLinkedList(null).isEmpty());
        assertEquals(List.of(List.of(9)), values(solution.createLevelLinkedList(new TreeNode(9))));
    }
}
