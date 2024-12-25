package leetcode.practise;

import java.util.*;

/**
 * @author Vivek
 * @since 2024-12-24
 */
public class Q0515_M_FindLargestValueInEachTreeRow {

  public static void main(String[] args) {
    Q0515_M_FindLargestValueInEachTreeRow q0515MFindLargestValueInEachTreeRow =
        new Q0515_M_FindLargestValueInEachTreeRow();
    TreeNode root = new TreeNode(1);
    root.left = new TreeNode(3);
    root.right = new TreeNode(2);
    root.left.left = new TreeNode(5);
    root.left.right = new TreeNode(3);
    root.right.right = new TreeNode(9);
    System.out.println(q0515MFindLargestValueInEachTreeRow.largestValues(root));

    root = new TreeNode(1);
    root.left = new TreeNode(2);
    root.right = new TreeNode(3);
    System.out.println(q0515MFindLargestValueInEachTreeRow.largestValues(root));

    System.out.println(q0515MFindLargestValueInEachTreeRow.largestValues(null));
  }

  public List<Integer> largestValues(TreeNode root) { // 3ms, beats 15.19%
    List<Integer> data = new ArrayList<>();
    if (root == null) return data;
    Queue<TreeNode> queue = new LinkedList<>();
    queue.add(root);
    while (!queue.isEmpty()) {
      List<TreeNode> list = new ArrayList<>();
      int max = Integer.MIN_VALUE;
      while (!queue.isEmpty()) {
        TreeNode node = queue.poll();
        max = Math.max(max, node.val);
        if (node.left != null) list.add(node.left);
        if (node.right != null) list.add(node.right);
      }
      data.add(max);
      queue.addAll(list);
    }
    return data;
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
