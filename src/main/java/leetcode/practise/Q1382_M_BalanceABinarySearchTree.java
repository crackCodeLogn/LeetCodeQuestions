package leetcode.practise;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Vivek
 * @since 2024-06-26
 */
public class Q1382_M_BalanceABinarySearchTree {

    List<Integer> list;

    public TreeNode balanceBST(TreeNode root) {
        list = new ArrayList<>(10_001);
        inorder(root);
        return construct(0, list.size() - 1);
    }

    private TreeNode construct(int lb, int ub) {
        if (lb > ub) return null;

        int mid = lb + (ub - lb) / 2;
        TreeNode node = new TreeNode(list.get(mid));
        node.left = construct(lb, mid - 1);
        node.right = construct(mid + 1, ub);
        return node;
    }

    private void inorder(TreeNode node) {
        if (node == null) return;

        inorder(node.left);
        list.add(node.val);
        inorder(node.right);
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
