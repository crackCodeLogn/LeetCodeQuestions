package leetcode.practise;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author Vivek
 * @since 2024-12-19
 */
public class Q2415_M_ReverseOddLevelsOfBinaryTree {

  public static void main(String[] args) {
    Q2415_M_ReverseOddLevelsOfBinaryTree q2415MReverseOddLevelsOfBinaryTree =
        new Q2415_M_ReverseOddLevelsOfBinaryTree();
    TreeNode root = new TreeNode(2);
    root.left = new TreeNode(3);
    root.right = new TreeNode(5);
    root.left.left = new TreeNode(8);
    root.left.right = new TreeNode(13);
    root.right.left = new TreeNode(21);
    root.right.right = new TreeNode(34);
    printLevelOrder(root);
    root = q2415MReverseOddLevelsOfBinaryTree.reverseOddLevels(root);
    printLevelOrder(root);
  }

  private static void printLevelOrder(TreeNode root) {
    if (root == null) return;
    Queue<TreeNode> queue = new LinkedList<>();
    queue.add(root);
    while (!queue.isEmpty()) {
      List<TreeNode> list = new ArrayList<>();
      while (!queue.isEmpty()) {
        TreeNode node = queue.poll();
        System.out.print(node.val + " ");
        if (node.left != null) list.add(node.left);
        if (node.right != null) list.add(node.right);
      }
      System.out.println();
      queue.addAll(list);
    }
  }

  public TreeNode reverseOddLevels(TreeNode root) { // 10ms, beats 34.32%, uses level order
    if (root == null) return root;

    Queue<TreeNode> queue = new LinkedList<>();
    queue.add(root);
    int level = 1;
    while (!queue.isEmpty()) {
      List<TreeNode> list = new ArrayList<>();
      while (!queue.isEmpty()) {
        TreeNode node = queue.poll();
        if (node.left != null) list.add(node.left);
        if (node.right != null) list.add(node.right);
      }
      if (level % 2 == 1) {
        for (int i = 0, j = list.size() - 1; i < j; i++, j--) {
          int temp = list.get(i).val;
          list.get(i).val = list.get(j).val;
          list.get(j).val = temp;
        }
      }
      queue.addAll(list);
      level++;
    }
    return root;
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
