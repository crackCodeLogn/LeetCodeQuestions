package leetcode.practise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Vivek
 * @since 2024-07-22
 */
public class Q1110_M_DeleteNodesAndReturnForest {

    int[] del;

    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        List<TreeNode> set = new ArrayList<>();
        Arrays.sort(to_delete);
        this.del = to_delete;
        if (!in(root.val)) set.add(root);
        // for (int del: to_delete) this.del.add(del);
        remove(root, null, ' ', set);
        return set;
    }

    private boolean in(int val) {
        return Arrays.binarySearch(del, val) >= 0;
    }

    private void remove(TreeNode node, TreeNode parent, char side, List<TreeNode> set) {
        if (node == null) return;

        if (Arrays.binarySearch(del, node.val) >= 0) {
            if (parent != null) {
                if (side == 'L') parent.left = null;
                else parent.right = null;
            }
            // set.remove(node);
            if (node.left != null && !in(node.left.val)) set.add(node.left);
            if (node.right != null && !in(node.right.val)) set.add(node.right);
        }
        remove(node.left, node, 'L', set);
        remove(node.right, node, 'R', set);
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
