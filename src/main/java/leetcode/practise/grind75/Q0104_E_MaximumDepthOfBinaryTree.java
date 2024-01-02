package leetcode.practise.grind75;

/**
 * @author Vivek
 * @since 2024-01-03
 */
public class Q0104_E_MaximumDepthOfBinaryTree {

    public int maxDepth(TreeNode root) {
        return compute(root);
    }

    private int compute(TreeNode node) {
        if (node == null) return 0;
        return Math.max(compute(node.left), compute(node.right)) + 1;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    }
}
