package leetcode.practise;

/**
 * @author Vivek
 * @since 2024-01-11
 */
public class Q0404_E_SumOfLeftLeaves {

    public int sumOfLeftLeaves(TreeNode root) {
        return compute(root, '-');
    }

    private int compute(TreeNode node, char src) {
        if (node == null) return 0;
        if (node.left == null && node.right == null) {
            if (src == 'L') return node.val;
            return 0;
        }
        return compute(node.left, 'L') + compute(node.right, 'R');
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
