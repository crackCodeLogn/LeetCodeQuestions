package leetcode.practise;

/**
 * @author Vivek
 * @since 2024-06-25
 */
public class Q1038_M_BinarySearchTreeToGreaterSumTree {

    int sum;

    public TreeNode bstToGst(TreeNode root) {
        sum = 0;
        compute(root);
        return root;
    }

    private void compute(TreeNode node) {
        if (node == null) return;

        compute(node.right);
        node.val += sum;
        sum = node.val;
        compute(node.left);
    }

    public static final class TreeNode {
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
