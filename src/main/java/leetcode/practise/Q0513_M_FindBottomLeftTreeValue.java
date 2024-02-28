package leetcode.practise;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author Vivek
 * @since 2024-02-28
 */
public class Q0513_M_FindBottomLeftTreeValue {

    public int findBottomLeftValue(TreeNode root) {
        if (root == null) return -1;
        int value = -1;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            List<TreeNode> list = new ArrayList<>();
            boolean first = false;
            while (!queue.isEmpty()) {
                TreeNode node = queue.poll();
                if (!first) {
                    first = true;
                    value = node.val;
                }
                if (node.left != null) list.add(node.left);
                if (node.right != null) list.add(node.right);
            }
            queue.addAll(list);
        }
        return value;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    }
}
