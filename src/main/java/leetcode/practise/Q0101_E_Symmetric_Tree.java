package leetcode.practise;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author Vivek
 * @since 2023-03-14
 */
public class Q0101_E_Symmetric_Tree {
    private Custom gen(TreeNode node, boolean from) {
        return new Custom(node, from);
    }

    public boolean isSymmetric(TreeNode root) {
        Queue<Custom> queue = new LinkedList<>();
        boolean flag = true;
        queue.add(gen(root, true));
        while (!queue.isEmpty()) {
            List<Custom> list = new ArrayList<>();
            while (!queue.isEmpty()) {
                TreeNode node = queue.poll().node;
                if (node == null) continue;
                list.add(gen(node.left, true));
                list.add(gen(node.right, false));
            }
            if (list.size() % 2 != 0) return false;

            for (int i = 0, j = list.size() - 1; i < j; i++, j--) {
                if (list.get(i).from != list.get(j).from && ((list.get(i).node == null && list.get(j).node == null) || (((list.get(i).node != null && list.get(j).node != null)) && list.get(i).node.val == list.get(j).node.val))) {
                } else return false;
            }
            queue.addAll(list);
        }
        return true;
    }

    private static class TreeNode {
        int val;
        TreeNode left, right;


    }

    private class Custom {
        TreeNode node;
        boolean from; //left = true, right = false;

        public Custom(TreeNode node, boolean from) {
            this.node = node;
            this.from = from;
        }
    }

}
