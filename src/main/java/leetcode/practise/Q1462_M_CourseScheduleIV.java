package leetcode.practise;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author Vivek
 * @since 2025-01-26
 */
public class Q1462_M_CourseScheduleIV {

  Map<Integer, Set<Integer>> data;

  public static void main(String[] args) {
    Q1462_M_CourseScheduleIV q1462MCourseScheduleIV = new Q1462_M_CourseScheduleIV();
    System.out.println(
        q1462MCourseScheduleIV.checkIfPrerequisite(
            3,
            new int[][] {{1, 2}, {1, 0}, {2, 0}},
            new int[][] {
              {1, 0},
              {1, 2},
            }));
    System.out.println(
        q1462MCourseScheduleIV.checkIfPrerequisite(
            2,
            new int[][] {{1, 0}},
            new int[][] {
              {0, 1},
              {1, 0}
            }));
    System.out.println(
        q1462MCourseScheduleIV.checkIfPrerequisite(
            2,
            new int[][] {{}},
            new int[][] {
              {1, 0},
              {0, 1},
            }));
  }

  public List<Boolean> checkIfPrerequisite(
      int numCourses, int[][] prerequisites, int[][] queries) { // 40ms, beats 57.06%
    List<Boolean> result = new ArrayList<>(queries.length);
    Map<Integer, Node> nodeMap = new HashMap<>(numCourses);
    for (int i = 0; i < numCourses; i++) nodeMap.put(i, new Node(i));
    for (int[] prerequisite : prerequisites) {
      if (prerequisite.length == 0) continue;
      int u = prerequisite[0], v = prerequisite[1];
      Node nv = nodeMap.get(v), nu = nodeMap.get(u);
      nv.addConnected(nu);
    }

    // pre-compute
    data = new HashMap<>();
    nodeMap.forEach(
        (k, v) -> {
          Set<Integer> visited = new HashSet<>();
          dfsCrawl(v, visited);
          visited.remove(k);
          data.put(k, visited);
        });

    for (int[] query : queries) {
      int u = query[0], v = query[1];
      result.add(data.get(v).contains(u));
    }

    return result;
  }

  private void dfsCrawl(Node node, Set<Integer> visited) {
    if (visited.contains(node.val)) return;
    visited.add(node.val);
    if (data.containsKey(node.val)) {
      visited.addAll(data.get(node.val));
      return;
    }
    for (Node connect : node.connected) {
      if (visited.contains(connect.val)) continue;
      dfsCrawl(connect, visited);
    }
  }

  private class Node {
    private final int val;
    private final Set<Node> connected = new HashSet<>();

    public Node(int val) {
      this.val = val;
    }

    public void addConnected(Node node) {
      connected.add(node);
    }
  }
}
