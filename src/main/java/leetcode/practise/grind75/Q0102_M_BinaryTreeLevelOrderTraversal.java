package leetcode.practise.grind75;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author Vivek
 * @since 2024-01-05
 */
public class Q0102_M_BinaryTreeLevelOrderTraversal {

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;

        Queue<TreeNode> data = new LinkedList<>();
        data.offer(root);

        while (!data.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            List<TreeNode> l = new ArrayList<>();
            while (!data.isEmpty()) {
                TreeNode node = data.poll();
                list.add(node.val);

                if (node.left != null)
                    l.add(node.left);
                if (node.right != null)
                    l.add(node.right);
            }
            data.addAll(l);
            result.add(list);
        }
        return result;
    }

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    }
}
