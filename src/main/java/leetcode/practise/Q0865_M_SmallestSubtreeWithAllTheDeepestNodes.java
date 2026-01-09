package leetcode.practise;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/**
 * @author Vivek
 * @since 2026-01-08
 */
public class Q0865_M_SmallestSubtreeWithAllTheDeepestNodes {

  public static void main(String[] args) {
    Q0865_M_SmallestSubtreeWithAllTheDeepestNodes q0865MSmallestSubtreeWithAllTheDeepestNodes =
        new Q0865_M_SmallestSubtreeWithAllTheDeepestNodes();
    TreeNode root;
    root = new TreeNode(0);
    root.left = new TreeNode(1);
    root.left.left = new TreeNode(3);
    root.left.left.left = new TreeNode(6);
    root.left.right = new TreeNode(2);
    root.left.right.right = new TreeNode(4);
    root.left.right.left = new TreeNode(5);
    TreeNode node = q0865MSmallestSubtreeWithAllTheDeepestNodes.subtreeWithAllDeepest(root);
    System.out.println(node.val);
  }

  public TreeNode subtreeWithAllDeepest(TreeNode root) { // 3ms, beats 2.71%
    if (root == null) return null;

    Map<Integer, Integer> nodeParentMap = new HashMap<>();
    Map<Integer, TreeNode> nodeMap = new HashMap<>();
    Queue<TreeNode> queue = new LinkedList<>();
    queue.add(root);
    nodeParentMap.put(root.val, null);

    List<Integer> levelList = new ArrayList<>();
    while (!queue.isEmpty()) {
      List<TreeNode> nodes = new ArrayList<>();
      levelList.clear();

      while (!queue.isEmpty()) {
        TreeNode node = queue.poll();
        levelList.add(node.val);
        nodeMap.put(node.val, node);

        if (node.left != null) {
          nodes.add(node.left);
          nodeParentMap.put(node.left.val, node.val);
        }
        if (node.right != null) {
          nodes.add(node.right);
          nodeParentMap.put(node.right.val, node.val);
        }
      }
      queue.addAll(nodes);
    }
    if (levelList.size() == 1) return nodeMap.get(levelList.get(0));
    Map<Integer, Integer> mapTrace = new LinkedHashMap<>();
    int nodeVal = levelList.get(0);
    mapTrace.put(nodeVal, 0);
    int level = 1;
    while (nodeParentMap.get(nodeVal) != null) {
      nodeVal = nodeParentMap.get(nodeVal);
      mapTrace.put(nodeVal, level++);
    }

    int currentIntersectionIndex = -1;
    for (int i = 1; i < levelList.size(); i++) {
      nodeVal = levelList.get(i);

      while (nodeParentMap.get(nodeVal) != null) {
        nodeVal = nodeParentMap.get(nodeVal);
        if (mapTrace.containsKey(nodeVal)) {
          if (mapTrace.get(nodeVal) >= currentIntersectionIndex) {
            currentIntersectionIndex = mapTrace.get(nodeVal);
            break;
          }
        }
      }
    }
    int i = 0;
    for (Map.Entry<Integer, Integer> entry : mapTrace.entrySet()) {
      if (i == currentIntersectionIndex) return nodeMap.get(entry.getKey());
      i++;
    }
    return null;
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
