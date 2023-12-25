package leetcode.practise.blind75;

/**
 * @author Vivek
 * @since 2023-12-25
 */
public class Q0235_M_LowestCommonAncestorOfBST {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;
        if (root.val > Math.max(p.val, q.val)) {
            return lowestCommonAncestor(root.left, p, q);
        } else if (root.val < Math.min(p.val, q.val)) {
            return lowestCommonAncestor(root.right, p, q);
        }
        return root;
    }

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    }

}
