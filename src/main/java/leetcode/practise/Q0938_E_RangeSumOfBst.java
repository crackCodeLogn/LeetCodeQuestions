package leetcode.practise;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Vivek
 * @since 2024-01-08
 */
public class Q0938_E_RangeSumOfBst {

    private static final List<Integer> data = new ArrayList<>();

    public int rangeSumBST(TreeNode root, int low, int high) {
        if (root == null) return 0;

        int sum = 0;
        if (inRange(root.val, low, high)) {
            sum += root.val + rangeSumBST(root.left, low, high) + rangeSumBST(root.right, low, high);
        } else if (root.val < low) {
            sum += rangeSumBST(root.right, low, high);
        } else if (root.val > high) {
            sum += rangeSumBST(root.left, low, high);
        }
        return sum;
    }


    public int rangeSumBST3(TreeNode root, int low, int high) {
        if (root == null) return 0;

        int sum = 0;
        if (inRange(root.val, low, high)) sum += root.val;
        return sum + rangeSumBST3(root.left, low, high) + rangeSumBST3(root.right, low, high);
    }

    private boolean inRange(int v, int l, int h) {
        return v >= l && v <= h;
    }

    public int rangeSumBST2(TreeNode root, int low, int high) {
        data.clear();
        inorder(root);
        int i = 0, j = data.size() - 1;
        for (; i < data.size() && data.get(i) < low; i++) ;
        for (; j >= 0 && data.get(j) > high; j--) ;
        if (i > j) return 0;
        int sum = 0;
        for (; i <= j; i++) sum += data.get(i);
        return sum;
    }

    private void inorder(TreeNode node) {
        if (node == null) return;
        inorder(node.left);
        data.add(node.val);
        inorder(node.right);
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    }
}
