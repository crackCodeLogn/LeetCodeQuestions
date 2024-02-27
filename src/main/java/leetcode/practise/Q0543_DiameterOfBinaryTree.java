package leetcode.practise;

/**
 * @author Vivek
 * @since 2024-02-27
 */
public class Q0543_DiameterOfBinaryTree {

    private int maxDepth = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        maxDepth = 0;
        if (root == null || (root.left == null && root.right == null)) return 0;
        compute(root);
        return maxDepth;
    }

    private int compute(TreeNode node) {
        if (node == null) return 0;

        int left = compute(node.left);
        int right = compute(node.right);
        maxDepth = Math.max(maxDepth, left + right);
        return 1 + Math.max(left, right);
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    }
}
