package leetcode.practise;

/**
 * @author Vivek
 * @since 2024-01-11
 */
public class Q1026_M_MaximumDifferenceBetweenNodeAndAncestor {
    private int diff;

    public int maxAncestorDiff(TreeNode root) {
        diff = 0;
        compute(root, root.val, root.val);
        return diff;
    }

    private void compute(TreeNode node, int curMin, int curMax) {
        if (node == null) return;
        curMax = Math.max(curMax, node.val);
        curMin = Math.min(curMin, node.val);
        diff = Math.max(diff, curMax - curMin);
        compute(node.left, curMin, curMax);
        compute(node.right, curMin, curMax);
    }

    private static class TreeNode {
        private final int val;
        TreeNode left;
        TreeNode right;


        private TreeNode(int val) {
            this.val = val;
        }
    }
}
