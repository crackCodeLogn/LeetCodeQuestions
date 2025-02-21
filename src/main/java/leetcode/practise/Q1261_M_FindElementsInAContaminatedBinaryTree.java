package leetcode.practise;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Vivek
 * @since 2025-02-20
 */
public class Q1261_M_FindElementsInAContaminatedBinaryTree {

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

  class FindElements { // 20ms, beats 98.92%

    private final Set<Integer> values;
    private final TreeNode root;

    public FindElements(TreeNode root) {
      this.root = root;
      values = new HashSet<>();

      this.root.val = 0;
      values.add(0);
      recover(root);
    }

    private void recover(TreeNode node) {
      if (node == null) return;

      if (node.left != null) {
        node.left.val = 2 * node.val + 1;
        values.add(node.left.val);
      }
      if (node.right != null) {
        node.right.val = 2 * node.val + 2;
        values.add(node.right.val);
      }
      recover(node.left);
      recover(node.right);
    }

    public boolean find(int target) {
      return values.contains(target);
    }
  }
}
