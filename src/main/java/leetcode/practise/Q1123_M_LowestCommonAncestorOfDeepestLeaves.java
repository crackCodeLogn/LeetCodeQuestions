package leetcode.practise;

import java.util.*;

public class Q1123_M_LowestCommonAncestorOfDeepestLeaves {
  private static final List<Node> nodes = new ArrayList<>();

  public static void main(String[] args) {}

  public TreeNode lcaDeepestLeaves(TreeNode root) { // 7ms, beats 5.13%
    nodes.clear();
    traverse(root, 0, null, null);
    nodes.sort(Comparator.comparingInt(Node::depth));
    if (nodes.size() == 1) return root;
    int last = nodes.size() - 1;
    int maxDepth = nodes.get(last).depth();

    int result = 0;
    List<TreeNode> lineage = new ArrayList<>();
    trace(nodes.get(last), lineage);

    for (int i = last - 1; i >= 0 && nodes.get(i).depth() == maxDepth; i--)
      result = traceResult(nodes.get(i), lineage, result);
    return lineage.get(result);
  }

  private int traceResult(Node root, List<TreeNode> lineage, int result) {
    Set<TreeNode> line = new HashSet<>();
    trace(root, line);
    for (int i = result; i < lineage.size(); i++) if (line.contains(lineage.get(i))) return i;
    return result;
  }

  private void trace(Node root, List<TreeNode> lineage) {
    if (root == null) return;
    lineage.add(root.node());
    trace(root.parentNode(), lineage);
  }

  private void trace(Node root, Set<TreeNode> lineage) {
    if (root == null) return;
    lineage.add(root.node());
    trace(root.parentNode(), lineage);
  }

  private void traverse(TreeNode current, int depth, TreeNode parent, Node parentNode) {
    if (current == null) return;

    Node nodeC = new Node(current, depth, parent, parentNode);
    nodes.add(nodeC);
    traverse(current.left, depth + 1, current, nodeC);
    traverse(current.right, depth + 1, current, nodeC);
  }

  private record Node(TreeNode node, int depth, TreeNode parent, Node parentNode) {}

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
