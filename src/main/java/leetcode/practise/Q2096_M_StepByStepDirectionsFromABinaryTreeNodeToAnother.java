package leetcode.practise;

/**
 * @author Vivek
 * @since 2024-07-22
 */
public class Q2096_M_StepByStepDirectionsFromABinaryTreeNodeToAnother {

    private String pathToStart = "";
    private String pathToDest = "";

    public String getDirections(TreeNode root, int startValue, int destValue) {
        dfs(lca(root, startValue, destValue), startValue, destValue, new StringBuilder());
        return "U".repeat(pathToStart.length()) + pathToDest;
    }

    private TreeNode lca(TreeNode root, int p, int q) {
        if (root == null || root.val == p || root.val == q)
            return root;
        TreeNode left = lca(root.left, p, q);
        TreeNode right = lca(root.right, p, q);
        if (left != null && right != null)
            return root;
        return left == null ? right : left;
    }

    private void dfs(TreeNode root, int p, int q, StringBuilder path) {
        if (root == null)
            return;
        if (root.val == p)
            pathToStart = path.toString();
        if (root.val == q)
            pathToDest = path.toString();
        dfs(root.left, p, q, path.append('L'));
        path.deleteCharAt(path.length() - 1);
        dfs(root.right, p, q, path.append('R'));
        path.deleteCharAt(path.length() - 1);
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
