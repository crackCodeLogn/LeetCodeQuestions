package leetcode.contest.weekly.w410_202408;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Vivek
 * @since 2024-08-24
 */
public class Q0145_E_BinaryTreePostorderTraversal {
    private final List<Integer> data = new ArrayList<>();

    public List<Integer> postorderTraversal(TreeNode root) {
        data.clear();
        postorder(root);
        return data;
    }

    private void postorder(TreeNode node) {
        if (node == null) return;
        postorder(node.left);
        postorder(node.right);
        data.add(node.val);
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
