package common;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Nó de árvore binária usado nas questões do capítulo 4 (e outras).
 * O campo {@code parent} é preenchido pelos utilitários desta classe (útil na 4.6 e 4.8).
 */
public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;
    public TreeNode parent;

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        setLeft(left);
        setRight(right);
    }

    public void setLeft(TreeNode left) {
        this.left = left;
        if (left != null) {
            left.parent = this;
        }
    }

    public void setRight(TreeNode right) {
        this.right = right;
        if (right != null) {
            right.parent = this;
        }
    }

    /**
     * Constrói uma árvore a partir de uma lista em ordem de nível (estilo LeetCode), onde null
     * indica ausência de filho. Ex.: of(2, 1, 3) cria raiz 2 com filhos 1 e 3.
     */
    public static TreeNode of(Integer... levelOrder) {
        if (levelOrder.length == 0 || levelOrder[0] == null) {
            return null;
        }
        TreeNode root = new TreeNode(levelOrder[0]);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int i = 1;
        while (!queue.isEmpty() && i < levelOrder.length) {
            TreeNode current = queue.poll();
            if (i < levelOrder.length && levelOrder[i] != null) {
                current.setLeft(new TreeNode(levelOrder[i]));
                queue.add(current.left);
            }
            i++;
            if (i < levelOrder.length && levelOrder[i] != null) {
                current.setRight(new TreeNode(levelOrder[i]));
                queue.add(current.right);
            }
            i++;
        }
        return root;
    }

    /** Insere um valor como em uma BST simples (<= vai para a esquerda). Retorna a raiz. */
    public static TreeNode insertBst(TreeNode root, int value) {
        if (root == null) {
            return new TreeNode(value);
        }
        if (value <= root.val) {
            root.setLeft(insertBst(root.left, value));
        } else {
            root.setRight(insertBst(root.right, value));
        }
        return root;
    }

    /** Constrói uma BST inserindo os valores na ordem dada. */
    public static TreeNode bstOf(int... values) {
        TreeNode root = null;
        for (int v : values) {
            root = insertBst(root, v);
        }
        return root;
    }

    public static List<Integer> inOrder(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        inOrder(root, result);
        return result;
    }

    private static void inOrder(TreeNode node, List<Integer> out) {
        if (node == null) {
            return;
        }
        inOrder(node.left, out);
        out.add(node.val);
        inOrder(node.right, out);
    }

    /** Altura em número de nós (árvore vazia = 0, só raiz = 1). */
    public static int height(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + Math.max(height(root.left), height(root.right));
    }

    public static int size(TreeNode root) {
        return root == null ? 0 : 1 + size(root.left) + size(root.right);
    }

    /** Busca (pré-ordem) o primeiro nó com o valor dado. */
    public static TreeNode find(TreeNode root, int value) {
        if (root == null) {
            return null;
        }
        if (root.val == value) {
            return root;
        }
        TreeNode left = find(root.left, value);
        return left != null ? left : find(root.right, value);
    }

    /** Compara estrutura e valores de duas árvores. */
    public static boolean sameTree(TreeNode a, TreeNode b) {
        if (a == null || b == null) {
            return a == b;
        }
        return a.val == b.val && sameTree(a.left, b.left) && sameTree(a.right, b.right);
    }

    @Override
    public String toString() {
        return "TreeNode(" + val + ")";
    }
}
