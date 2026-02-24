package leetcode.practise;

/**
 * @author Vivek
 * @since 2026-02-23
 */
public class Q1022_E_SumOfRootToLeafBinaryNumbers {

  private int sum;

  public int sumRootToLeaf(TreeNode root) { // 0ms, beats 100%
    sum = 0;
    calc(root, 0);
    return sum;
  }

  private void calc(TreeNode node, int num) {
    if (node == null) return;
    int n = (num << 1) + node.val;
    if (node.left == null && node.right == null) {
      sum += n;
      return;
    }
    calc(node.left, n);
    calc(node.right, n);
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
