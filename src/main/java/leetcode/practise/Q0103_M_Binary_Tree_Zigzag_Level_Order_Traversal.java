package leetcode.practise;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author Vivek
 * @since 2023-02-20
 */

public class Q0103_M_Binary_Tree_Zigzag_Level_Order_Traversal {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;
        Queue<TreeNode> nodes = new LinkedList<>();
        nodes.add(root);
        boolean fromLeft = true;
        while (!nodes.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            List<TreeNode> list2 = new ArrayList<>();
            while (!nodes.isEmpty()) {
                TreeNode node = nodes.poll();
                list.add(node.val);
                if (node.left != null) list2.add(node.left);
                if (node.right != null) list2.add(node.right);
            }
            nodes.addAll(list2);
            list2.clear();
            if (!fromLeft) Collections.reverse(list);
            result.add(list);
            fromLeft = !fromLeft;
        }

        return result;
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
