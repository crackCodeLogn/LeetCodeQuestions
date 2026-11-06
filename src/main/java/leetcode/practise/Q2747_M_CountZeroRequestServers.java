package leetcode.practise;

import java.util.*;

public class Q2747_M_CountZeroRequestServers {

  public int[] countServers(int n, int[][] logs, int x, int[] queries) { // 2351ms, beats 5.77%
    int[] answers = new int[queries.length];
    int max = 0;
    for (int q : queries) if (q > max) max = q;
    max++;

    Set<Integer>[] timeServerIds = new HashSet[max];
    for (int i = 0; i < logs.length; i++) {
      if (logs[i][1] >= timeServerIds.length)
        continue; // query is lower than this, no need to compute
      if (timeServerIds[logs[i][1]] == null) timeServerIds[logs[i][1]] = new HashSet<>(100);
      timeServerIds[logs[i][1]].add(logs[i][0]);
    }
    int[] timePointServersNotServing = new int[max];
    Map<Integer, Integer> slidingServerAndRequests = new HashMap<>();

    for (int i = 1; i < max; i++) {
      // add current
      Set<Integer> vals = timeServerIds[i];
      if (vals != null) {
        for (Integer serverId : vals) {
          slidingServerAndRequests.compute(serverId, (k, v) -> v == null ? 1 : v + 1);
        }
      }
      // remove trailing
      int trail = i - x - 1;
      if (trail >= 0) {
        vals = timeServerIds[trail];
        if (vals != null) {
          for (Integer serverId : vals) {
            Integer prev = slidingServerAndRequests.get(serverId);
            if (prev != null) {
              if (prev > 1) {
                slidingServerAndRequests.put(serverId, prev - 1);
              } else if (prev == 1) {
                slidingServerAndRequests.remove(serverId);
              }
            } // else shouldn't be happening as it is getting removed
          }
        }
      }
      timePointServersNotServing[i] = n - slidingServerAndRequests.size();
    }

    for (int q = 0; q < queries.length; q++) {
      answers[q] = timePointServersNotServing[queries[q]];
    }
    return answers;
  }

  public static void main(String[] args) {
    Q2747_M_CountZeroRequestServers q2747MCountZeroRequestServers =
        new Q2747_M_CountZeroRequestServers();
    System.out.println(
        Arrays.toString(
            q2747MCountZeroRequestServers.countServers(
                3, new int[][] {{1, 3}, {2, 6}, {1, 5}}, 5, new int[] {10, 11})));
    System.out.println(
        Arrays.toString(
            q2747MCountZeroRequestServers.countServers(
                3, new int[][] {{1, 3}, {2, 6}, {1, 5}, {3, 3}}, 5, new int[] {10, 11})));
    System.out.println(
        Arrays.toString(
            q2747MCountZeroRequestServers.countServers(
                3, new int[][] {{2, 4}, {2, 1}, {1, 2}, {3, 1}}, 2, new int[] {3, 4})));
  }
}
