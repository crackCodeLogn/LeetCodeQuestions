package leetcode.practise;

import java.util.StringJoiner;

/**
 * @author Vivek
 * @since 2026-09-10
 */
public class Q2265_M_CountNodesEqualToAverageOfSubtree_Re {
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

    @Override
    public String toString() {
      return new StringJoiner(", ", TreeNode.class.getSimpleName() + "[", "]")
          .add("val=" + val)
          .toString();
    }
  }

  record Pair(int val, int num) {}

  int cnt = 0;

  public int averageOfSubtree(TreeNode root) { // 1ms, beats 56.32%
    cnt = 0;
    calc(root);
    return cnt;
  }

  private Pair calc(TreeNode node) {
    if (node == null) return new Pair(0, 0);
    if (node.left == null && node.right == null) {
      cnt++;
      return new Pair(node.val, 1);
    }

    Pair p1 = calc(node.left);
    Pair p2 = calc(node.right);

    int sum = p1.val + p2.val + node.val;
    int n = p1.num + p2.num + 1;
    if (sum / n == node.val) cnt++;
    return new Pair(sum, n);
  }

  public static void main(String[] args) {
    Q2265_M_CountNodesEqualToAverageOfSubtree_Re q2265MCountNodesEqualToAverageOfSubtreeRe =
        new Q2265_M_CountNodesEqualToAverageOfSubtree_Re();

    TreeNode root = new TreeNode(4);
    root.left = new TreeNode(8);
    root.right = new TreeNode(5);
    root.left.left = new TreeNode(0);
    root.left.right = new TreeNode(1);
    root.right.right = new TreeNode(6);
    System.out.println(q2265MCountNodesEqualToAverageOfSubtreeRe.averageOfSubtree(root));
    System.out.println(q2265MCountNodesEqualToAverageOfSubtreeRe.averageOfSubtree(new TreeNode(1)));
  }
}
