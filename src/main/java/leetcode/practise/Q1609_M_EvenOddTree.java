package leetcode.practise;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author Vivek
 * @since 2024-02-29
 */
public class Q1609_M_EvenOddTree {

    public boolean isEvenOddTree(TreeNode root) {
        if (root == null) return false;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int level = 0;
        while (!queue.isEmpty()) {
            List<TreeNode> list = new ArrayList<>();
            boolean flag = isEven(level);
            level++;

            int base = -1;
            while (!queue.isEmpty()) {
                TreeNode node = queue.poll();
                if (flag && isEven(node.val)) return false;
                if (!flag && isOdd(node.val)) return false;

                if (base == -1) base = node.val;
                else {
                    if (flag && node.val - base <= 0) return false;
                    else if (!flag && node.val - base >= 0) return false;
                    base = node.val;
                }

                if (node.left != null) list.add(node.left);
                if (node.right != null) list.add(node.right);
            }
            queue.addAll(list);
        }
        return true;
    }

    private boolean isOdd(int num) {
        return (num & 1) == 1;
    }

    private boolean isEven(int num) {
        return !isOdd(num);
    }


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    }
}
