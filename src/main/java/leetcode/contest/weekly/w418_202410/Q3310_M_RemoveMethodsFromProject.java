package leetcode.contest.weekly.w418_202410;

import java.util.*;

/**
 * @author Vivek
 * @since 2024-10-05
 */
public class Q3310_M_RemoveMethodsFromProject {

  private final Map<Integer, Node> map = new HashMap<>();

  public static void main(String[] args) {
    Q3310_M_RemoveMethodsFromProject q3310MRemoveMethodsFromProject =
        new Q3310_M_RemoveMethodsFromProject();
    System.out.println(
        q3310MRemoveMethodsFromProject.remainingMethods(
            4,
            1,
            new int[][] {
              {1, 2},
              {0, 1},
              {3, 1}
            }));

    System.out.println(
        q3310MRemoveMethodsFromProject.remainingMethods(
            5,
            0,
            new int[][] {
              {1, 2},
              {0, 2},
              {0, 1},
              {3, 4}
            }));

    System.out.println(
        q3310MRemoveMethodsFromProject.remainingMethods(
            3,
            2,
            new int[][] {
              {1, 2},
              {0, 1},
              {2, 0}
            }));
  }

  public List<Integer> remainingMethods(int n, int k, int[][] invocations) {
    map.clear();
    for (int i = 0; i < n; i++) map.put(i, new Node(i));

    for (int i = 0; i < invocations.length; i++) {
      int src = invocations[i][0], dest = invocations[i][1];
      Node srcNode = map.get(src);
      Node destNode = map.get(dest);
      srcNode.addChild(destNode);
      destNode.addParent(srcNode);
    }
    Set<Integer> visited = new HashSet<>();
    dfs(k, visited);

    for (Integer val : visited) {
      for (Node node : map.get(val).getParents()) {
        if (!visited.contains(node.getVal())) return new ArrayList<>(map.keySet());
      }
    }

    map.keySet().removeAll(visited);
    return new ArrayList<>(map.keySet());
  }

  private void dfs(int n, Set<Integer> visited) {
    visited.add(n);
    for (Node children : map.get(n).children) {
      if (!visited.contains(children.getVal())) dfs(children.getVal(), visited);
    }
  }

  private static final class Node {
    private final int val;
    private final Set<Node> children = new HashSet<>(); // direct links
    private final Set<Node> parents = new HashSet<>(); // indirect links

    public Node(int val) {
      this.val = val;
    }

    public int getVal() {
      return val;
    }

    public void addChild(Node child) {
      children.add(child);
    }

    public void addParent(Node parent) {
      parents.add(parent);
    }

    public Set<Node> getChildren() {
      return children;
    }

    public Set<Node> getParents() {
      return parents;
    }
  }
}
