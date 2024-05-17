package leetcode.practise;

public class Q1325_M_DeleteLeavesWithAGivenValue {

    private TreeNode root;
    private int target;

    public TreeNode removeLeafNodes(TreeNode root, int target) {
        this.root = root;
        this.target = target;

        compute(root, null, true);
        return this.root;
    }

    private void compute(TreeNode node, TreeNode parent, boolean isLeft) { // 0ms
        if (node.left != null) compute(node.left, node, true);
        if (node.right != null) compute(node.right, node, false);

        if (isLeaf(node) && node.val == target) {
            if (parent != null) {
                if (isLeft) parent.left = null;
                else parent.right = null;
            } else {
                this.root = null;
            }
        }
    }

    private boolean isLeaf(TreeNode node) {
        return node.left == null && node.right == null;
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
