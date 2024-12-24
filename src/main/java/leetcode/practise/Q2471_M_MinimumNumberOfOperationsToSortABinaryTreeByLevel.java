package leetcode.practise;

import java.util.*;

/**
 * @author Vivek
 * @since 2024-12-23
 */
public class Q2471_M_MinimumNumberOfOperationsToSortABinaryTreeByLevel {

  public static void main(String[] args) {
    Q2471_M_MinimumNumberOfOperationsToSortABinaryTreeByLevel
        q2471MMinimumNumberOfOperationsToSortABinaryTreeByLevel =
            new Q2471_M_MinimumNumberOfOperationsToSortABinaryTreeByLevel();
    TreeNode root = new TreeNode(1);
    root.left = new TreeNode(4);
    root.right = new TreeNode(3);
    root.left.left = new TreeNode(7);
    root.left.right = new TreeNode(6);
    root.right.left = new TreeNode(8);
    root.right.right = new TreeNode(5);
    root.right.right.left = new TreeNode(9);
    root.right.right.right = new TreeNode(10);

    System.out.println(
        q2471MMinimumNumberOfOperationsToSortABinaryTreeByLevel.minimumOperations(root));

    root = new TreeNode(1);
    root.left = new TreeNode(3);
    root.right = new TreeNode(2);
    root.left.left = new TreeNode(7);
    root.left.right = new TreeNode(6);
    root.right.left = new TreeNode(5);
    root.right.right = new TreeNode(4);
    System.out.println(
        q2471MMinimumNumberOfOperationsToSortABinaryTreeByLevel.minimumOperations(root));

    root = new TreeNode(1);
    root.left = new TreeNode(2);
    root.right = new TreeNode(3);
    root.left.left = new TreeNode(4);
    root.left.right = new TreeNode(5);
    root.right.left = new TreeNode(6);
    System.out.println(
        q2471MMinimumNumberOfOperationsToSortABinaryTreeByLevel.minimumOperations(root));
  }

  public int minimumOperations(TreeNode root) { // 69ms, beats 48.57%
    int swaps = 0;

    Queue<TreeNode> queue = new LinkedList<>();
    queue.add(root);
    while (!queue.isEmpty()) {
      List<TreeNode> list = new ArrayList<>();
      while (!queue.isEmpty()) {
        TreeNode node = queue.poll();
        if (node.left != null) list.add(node.left);
        if (node.right != null) list.add(node.right);
      }
      int[] sortedData = new int[list.size()];
      Map<Integer, Integer> map = new HashMap<>();
      for (int i = 0; i < list.size(); i++) {
        sortedData[i] = list.get(i).val;
        map.put(sortedData[i], i);
      }
      Arrays.sort(sortedData);

      for (int i = 0; i < sortedData.length; i++) {
        if (list.get(i).val != sortedData[i]) {
          swaps++;
          int targetIndex = map.get(sortedData[i]);
          int tmp = list.get(targetIndex).val;
          map.put(list.get(i).val, map.get(sortedData[i]));
          list.get(targetIndex).val = list.get(i).val;
          list.get(i).val = tmp;
        }
      }

      queue.addAll(list);
    }

    return swaps;
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
