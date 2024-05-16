package leetcode.practise;

public class Q2331_E_EvaluateBooleanBinaryTree {

    public boolean evaluateTree(TreeNode root) {
        return compute(root) == 1;
    }

    private int compute(TreeNode node) {
        if (node.left == null && node.right == null) return node.val;
        boolean l = compute(node.left) != 0;
        boolean r = compute(node.right) != 0;

        if (node.val == 2) return l || r ? 1 : 0;
        return l && r ? 1 : 0;
    }

    private static final class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
