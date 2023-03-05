package leetcode.contest.weekly.w335_202303;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author Vivek
 * @since 2023-03-05
 */
public class Q6308_M_Kth_Largest_Sum_in_Binary_Tree {
    public long kthLargestLevelSum(TreeNode root, int k) {
        List<Long> sums = new ArrayList<>();

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            List<TreeNode> buffer = new ArrayList<>();
            long sum = 0;
            while (!queue.isEmpty()) {
                TreeNode node = queue.poll();
                sum += node.val;
                if (node.left != null) buffer.add(node.left);
                if (node.right != null) buffer.add(node.right);
            }
            sums.add(sum);
            queue.addAll(buffer);
            buffer.clear();
        }
        sums.sort(Collections.reverseOrder());
        return (k - 1) < sums.size() ? sums.get(k - 1) : -1;
    }

    public class TreeNode {
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
