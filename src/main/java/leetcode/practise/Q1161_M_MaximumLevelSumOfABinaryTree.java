package leetcode.practise;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author Vivek
 * @since 2026-01-05
 */
public class Q1161_M_MaximumLevelSumOfABinaryTree {

  public int maxLevelSum(TreeNode root) { // 12ms, beats 9.47%
    int level = 1, sum = Integer.MIN_VALUE, il = 1;
    if (root == null) return level;

    Queue<TreeNode> queue = new LinkedList<>();
    queue.add(root);
    while (!queue.isEmpty()) {
      List<TreeNode> list = new ArrayList<>();
      int loc = 0;
      while (!queue.isEmpty()) {
        TreeNode node = queue.poll();
        loc += node.val;
        if (node.left != null) list.add(node.left);
        if (node.right != null) list.add(node.right);
      }
      if (loc > sum) {
        sum = loc;
        level = il;
      }
      queue.addAll(list);
      il++;
    }
    return level;
  }

  private static final class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {}

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
