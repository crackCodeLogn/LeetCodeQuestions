package leetcode.practise;

import java.util.*;

/**
 * @author Vivek
 * @since 2025-01-23
 */
public class Q0802_M_FindEventualSafeStates {

  Map<Integer, List<Integer>> fwd = new HashMap<>();
  boolean[] unsafe, safe;

  public static void main(String[] args) {
    Q0802_M_FindEventualSafeStates q0802MFindEventualSafeStates =
        new Q0802_M_FindEventualSafeStates();

    System.out.println(
        q0802MFindEventualSafeStates.eventualSafeNodes(new int[][] {{}, {2}, {3, 4}, {4}, {}}));
    System.out.println(
        q0802MFindEventualSafeStates.eventualSafeNodes(
            new int[][] {{}, {0, 2, 3, 4}, {3}, {4}, {}}));
    System.out.println(
        q0802MFindEventualSafeStates.eventualSafeNodes(
            new int[][] {
              {1, 3, 4},
              {2, 3, 4},
              {0, 3},
              {4},
              {}
            }));
    System.out.println(
        q0802MFindEventualSafeStates.eventualSafeNodes(
            new int[][] {
              {1, 2, 3},
              {},
              {},
              {},
            }));
    System.out.println(
        q0802MFindEventualSafeStates.eventualSafeNodes(
            new int[][] {
              {1, 2},
              {2, 3},
              {5},
              {0},
              {5},
              {},
              {},
            }));
    System.out.println(
        q0802MFindEventualSafeStates.eventualSafeNodes(
            new int[][] {
              {1, 2, 3, 4},
              {1, 2},
              {3, 4},
              {0, 4},
              {},
            }));
  }

  public List<Integer> eventualSafeNodes(int[][] graph) { // 74 ms, beats 5.03%
    int n = graph.length;
    fwd.clear();
    unsafe = new boolean[n];
    safe = new boolean[n];

    for (int u = 0; u < n; u++) {
      fwd.put(u, new ArrayList<>());
      for (int v : graph[u]) {
        fwd.get(u).add(v);
        if (u == v) unsafe[u] = true;
      }
      if (fwd.get(u).isEmpty()) safe[u] = true;
    }
    for (int u = 0; u < n; u++) {
      boolean[] visited = new boolean[n];
      isSafe(u, visited);
    }

    List<Integer> data = new ArrayList<>(n);
    for (int u = 0; u < n; u++) if (safe[u]) data.add(u);
    return data;
  }

  /*
  private boolean isSafe(int u, Set<Integer> visited) {
    if (unsafe.contains(u)) return false;
    if (safe.contains(u)) return true;
    if (visited.contains(u)) return false;

    visited.add(u);
    boolean val = true;
    for (int v : fwd.get(u)) {
      if (!isSafe(v, visited)) {
        val = false;
        unsafe.add(v);
        break;
      }
    }
    if (val) safe.add(u);
    return val;
  }

  public List<Integer> eventualSafeNodes2(int[][] graph) { // 139 ms, beats 5.03%
    int n = graph.length;
    fwd.clear();
    unsafe.clear();
    safe.clear();

    Map<Integer, Set<Integer>> rev = new HashMap<>();
    for (int i = 0; i < n; i++) {
      fwd.put(i, new HashSet<>());
      rev.put(i, new HashSet<>());
    }
    for (int u = 0; u < n; u++) {
      for (int v : graph[u]) {
        fwd.get(u).add(v);
        rev.get(v).add(u);
        if (u == v) unsafe.add(u);
      }
    }
    Set<Integer> queue = new HashSet<>();
    for (int i = 0; i < n; i++) {
      if (fwd.get(i).isEmpty()) {
        safe.add(i); // term
      }
      queue.addAll(rev.get(i));
    }
    for (int u : queue) {
      if (isSafe(u, new HashSet<>())) {
        safe.add(u);
      }
    }

    return new ArrayList<>(safe);
  }*/

  private boolean isSafe(int u, boolean[] visited) {
    if (unsafe[u]) return false;
    if (safe[u]) return true;
    if (visited[u]) return false;

    visited[u] = true;
    boolean val = true;
    for (int v : fwd.get(u)) {
      if (!isSafe(v, visited)) {
        val = false;
        unsafe[v] = true;
        break;
      }
    }
    if (val) safe[u] = true;
    return val;
  }
}
