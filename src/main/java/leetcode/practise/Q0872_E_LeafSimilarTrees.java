package leetcode.practise;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Vivek
 * @since 2024-01-09
 */
public class Q0872_E_LeafSimilarTrees {

    private static final Queue<Integer> data = new LinkedList<>();

    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        data.clear();
        if (root1 == null && root2 == null) return true;
        if (root1 == null || root2 == null) return false;

        collectLeaves(root1);
        boolean result = isSimilar(root2);
        if (!data.isEmpty()) return false;
        return result;
    }

    private void collectLeaves(TreeNode node) {
        if (node == null) return;
        if (node.left == null && node.right == null) data.offer(node.val);
        collectLeaves(node.left);
        collectLeaves(node.right);
    }

    private boolean isSimilar(TreeNode node) {
        if (node == null) return true;
        if (node.left == null && node.right == null) {
            return !data.isEmpty() && data.poll() == node.val;
        }

        return isSimilar(node.left) && isSimilar(node.right);
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    }
}
