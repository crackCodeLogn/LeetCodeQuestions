package leetcode.practise;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author Vivek
 * @since 2025-02-23
 */
public class Q2467_M_MostProfitablePathInATree {

  private int netIncome;

  public static void main(String[] args) {
    Q2467_M_MostProfitablePathInATree q2467MMostProfitablePathInATree =
        new Q2467_M_MostProfitablePathInATree();
    System.out.println(
        q2467MMostProfitablePathInATree.mostProfitablePath(
            new int[][] {
              {0, 1},
              {1, 2},
              {1, 3},
              {3, 4},
            },
            3,
            new int[] {-2, 4, 2, -4, 6}));
    System.out.println(
        q2467MMostProfitablePathInATree.mostProfitablePath(
            new int[][] {
              {0, 1},
              {1, 2},
              {1, 4},
              {3, 4},
            },
            3,
            new int[] {-2, 4, 2, -4, 6}));

    System.out.println(
        q2467MMostProfitablePathInATree.mostProfitablePath(
            new int[][] {{0, 1}}, 1, new int[] {-7280, 2350}));
  }

  public int mostProfitablePath(int[][] edges, int bob, int[] amount) { // 92ms, beats 28.63%
    netIncome = Integer.MIN_VALUE;
    Map<Integer, Node> map = new HashMap<>();
    for (int i = 0; i <= edges.length; i++) map.put(i, new Node(i, amount[i]));

    for (int[] edge : edges) {
      int src = edge[0], dest = edge[1];
      Node srcNode = map.get(src), destNode = map.get(dest);
      srcNode.addConnection(destNode);
      destNode.addConnection(srcNode);
    }

    Map<Node, Integer> bobTraversalMap = new HashMap<>(); // node x timestamp
    bobTraversalMap.put(map.get(bob), 0);
    computeBobPath(map.get(bob), bobTraversalMap, 0, new HashSet<>());

    computeAlicePath(map.get(0), 0, 0, new HashSet<>(), bobTraversalMap);
    return netIncome;
  }

  private void computeAlicePath(
      Node node,
      int time,
      int currentIncome,
      Set<Integer> visited,
      Map<Node, Integer> bobTraversalMap) {
    if (node == null) return;
    if (visited.contains(node.getVal())) return;

    int incr = node.getAmount();
    if (bobTraversalMap.containsKey(node)) {
      if (bobTraversalMap.get(node) == time) incr /= 2;
      if (time > bobTraversalMap.get(node)) incr = 0;
    }
    currentIncome += incr;

    if (node.getConnections().size() == 1
        && visited.contains(node.getConnections().get(0).getVal())) { // leaf
      netIncome = Math.max(netIncome, currentIncome);
      return;
    }

    visited.add(node.getVal());
    for (Node connection : node.getConnections())
      if (!visited.contains(connection.getVal()))
        computeAlicePath(connection, time + 1, currentIncome, visited, bobTraversalMap);
  }

  private boolean computeBobPath(
      Node bobNode, Map<Node, Integer> map, int time, Set<Integer> visited) {
    if (bobNode.getVal() == 0) return true;

    if (visited.contains(bobNode.getVal())) return false;
    visited.add(bobNode.getVal());

    for (Node connect : bobNode.getConnections())
      if (!visited.contains(connect.getVal()))
        if (computeBobPath(connect, map, time + 1, visited)) {
          map.put(connect, time + 1);
          return true;
        }
    return false;
  }

  private static final class Node {
    private final int val;
    private final int amount;
    private final List<Node> connections = new ArrayList<>();

    public Node(int val, int amount) {
      this.val = val;
      this.amount = amount;
    }

    public void addConnection(Node connection) {
      connections.add(connection);
    }

    public int getAmount() {
      return amount;
    }

    @Override
    public String toString() {
      return val
          + " -> "
          + (connections.stream()
              .map(node -> String.valueOf(node.val))
              .collect(Collectors.toSet()));
    }

    public int getVal() {
      return val;
    }

    public List<Node> getConnections() {
      return connections;
    }
  }
}
