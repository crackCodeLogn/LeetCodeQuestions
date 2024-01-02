package leetcode.practise.grind75;

/**
 * @author Vivek
 * @since 2023-12-26
 */
public class Q0110_E_BalancedBinaryTree {

    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        int lh = height(root.left);
        int rh = height(root.right);
        return Math.abs(lh - rh) <= 1 && isBalanced(root.left) && isBalanced(root.right);

    }

    private int height(TreeNode root) {
        if (root == null) return 0;
        int left = height(root.left);
        int right = height(root.right);
        return 1 + Math.max(left, right);
    }

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    }
}
