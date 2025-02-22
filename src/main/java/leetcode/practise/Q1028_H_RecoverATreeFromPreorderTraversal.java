package leetcode.practise;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * @author Vivek
 * @since 2025-02-21
 */
public class Q1028_H_RecoverATreeFromPreorderTraversal {

  private final Map<Integer, LinkedList<TreeNode>> map2 =
      new HashMap<>(); // this approach took 6ms, and beat 57.51%
  private final Map<Integer, TreeNode> map = new HashMap<>(); // this had the same performance

  private static void preOrder(TreeNode node) {
    if (node == null) return;
    System.out.print(node.val + " ");
    preOrder(node.left);
    preOrder(node.right);
  }

  public static void main(String[] args) {
    Q1028_H_RecoverATreeFromPreorderTraversal q1028HRecoverATreeFromPreorderTraversal =
        new Q1028_H_RecoverATreeFromPreorderTraversal();
    TreeNode root;
    root = q1028HRecoverATreeFromPreorderTraversal.recoverFromPreorder("3");
    preOrder(root);
    System.out.println();

    root = q1028HRecoverATreeFromPreorderTraversal.recoverFromPreorder("1-2--3--4-5--6--7");
    preOrder(root);
    System.out.println();

    root = q1028HRecoverATreeFromPreorderTraversal.recoverFromPreorder("1-2--3---4-5--6---7");
    preOrder(root);
    System.out.println();

    root = q1028HRecoverATreeFromPreorderTraversal.recoverFromPreorder("1-401--349---90--88");
    preOrder(root);
    System.out.println();
  }

  public TreeNode recoverFromPreorder(String traversal) { // 6ms, beats 57.51%
    map.clear();
    int ni = 0, dashes = 0, n = traversal.length();
    int i = 0;
    while (i < n && traversal.charAt(i) != '-') i++;
    TreeNode root = new TreeNode(Integer.parseInt(traversal.substring(0, i)));
    map.put(0, root);

    boolean ns = false;
    for (; i < n; i++) {
      char ch = traversal.charAt(i);
      if (ch == '-') {
        if (ns) {
          ns = false;
          compute(dashes, Integer.parseInt(traversal.substring(ni, i)));
          dashes = 0;
        }
        dashes++;
      } else if (!ns) {
        ns = true;
        ni = i;
      }
    }
    if (dashes > 0) compute(dashes, Integer.parseInt(traversal.substring(ni)));

    return root;
  }

  private void compute(int dashes, int num) {
    TreeNode node = new TreeNode(num);
    map.put(dashes, node);
    TreeNode parent = map.get(dashes - 1);
    if (parent.left == null) {
      parent.left = node;
    } else if (parent.right == null) {
      parent.right = node;
    } else {
      throw new RuntimeException("weird");
    }
  }

  public TreeNode recoverFromPreorder2(String traversal) { // 6ms, and beat 57.51%
    map.clear();
    int ni = 0, dashes = 0, n = traversal.length();
    int i = 0;
    while (i < n && traversal.charAt(i) != '-') i++;
    TreeNode root = new TreeNode(Integer.parseInt(traversal.substring(0, i)));
    LinkedList<TreeNode> list = new LinkedList<>();
    list.add(root);
    map2.put(0, list);

    boolean ns = false;
    for (; i < n; i++) {
      char ch = traversal.charAt(i);
      if (ch == '-') {
        if (ns) {
          ns = false;
          compute2(dashes, Integer.parseInt(traversal.substring(ni, i)));
          dashes = 0;
        }
        dashes++;
      } else if (!ns) {
        ns = true;
        ni = i;
      }
    }
    if (dashes > 0) compute2(dashes, Integer.parseInt(traversal.substring(ni)));
    return root;
  }

  private void compute2(int dashes, int num) {
    TreeNode node = new TreeNode(num);
    map2.compute(dashes, (k, v) -> v == null ? new LinkedList<>() : v).addLast(node);
    TreeNode parent = map2.get(dashes - 1).getLast();
    if (parent.left == null) {
      parent.left = node;
    } else if (parent.right == null) {
      parent.right = node;
    } else {
      throw new RuntimeException("weird");
    }
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
