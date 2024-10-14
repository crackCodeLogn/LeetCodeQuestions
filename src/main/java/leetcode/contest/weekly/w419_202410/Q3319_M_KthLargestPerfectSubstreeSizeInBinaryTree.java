package leetcode.contest.weekly.w419_202410;

import java.util.*;

/**
 * @author Vivek
 * @since 2024-10-12
 */
public class Q3319_M_KthLargestPerfectSubstreeSizeInBinaryTree {

  private PriorityQueue<Integer> sizes;
  private int level;
  private int size = 0;

  public static void main(String[] args) {
    Q3319_M_KthLargestPerfectSubstreeSizeInBinaryTree
        q3319MKthLargestPerfectSubstreeSizeInBinaryTree =
            new Q3319_M_KthLargestPerfectSubstreeSizeInBinaryTree();
    TreeNode root = new TreeNode(5);
    root.left = new TreeNode(3);
    root.left.left = new TreeNode(5);
    root.left.left.left = new TreeNode(1);
    root.left.left.right = new TreeNode(8);
    root.left.right = new TreeNode(2);
    root.right = new TreeNode(6);
    root.right.left = new TreeNode(5);
    root.right.left.left = new TreeNode(6);
    root.right.left.right = new TreeNode(8);
    root.right.right = new TreeNode(7);

    System.out.println(
        q3319MKthLargestPerfectSubstreeSizeInBinaryTree.kthLargestPerfectSubtree(root, 2));

    root = new TreeNode(1);
    root.left = new TreeNode(2);
    root.left.left = new TreeNode(4);
    root.left.right = new TreeNode(5);
    root.right = new TreeNode(3);
    root.right.left = new TreeNode(6);
    root.right.right = new TreeNode(7);
    System.out.println(
        q3319MKthLargestPerfectSubstreeSizeInBinaryTree.kthLargestPerfectSubtree(root, 1));

    root = new TreeNode(1);
    root.left = new TreeNode(2);
    root.left.right = new TreeNode(4);
    root.right = new TreeNode(3);
    System.out.println(
        q3319MKthLargestPerfectSubstreeSizeInBinaryTree.kthLargestPerfectSubtree(root, 3));
  }

  public int kthLargestPerfectSubtree(TreeNode root, int k) {
    sizes = new PriorityQueue<>(Collections.reverseOrder());
    level = -1;
    traverse(root);

    if (k > sizes.size()) return -1;
    while (--k > 0) sizes.poll();
    return sizes.poll();
  }

  private void traverse(TreeNode node) {
    if (node == null) return;

    size = 0;
    level = -1;
    if (isPerfect(node, 0)) {
      sizes.offer(size);
    }

    traverse(node.left);
    traverse(node.right);
  }

  private boolean isPerfect(TreeNode root, int depth) {
    if (root == null) return false;
    size++;
    if (root.left == null && root.right == null) {
      if (level == -1) {
        level = depth;
      }
      return level == depth;
    }
    if (root.left == null || root.right == null) return false;
    return isPerfect(root.left, depth + 1) && isPerfect(root.right, depth + 1);
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
