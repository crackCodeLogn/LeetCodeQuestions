package leetcode.practise;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Vivek
 * @since 2025-01-22
 */
public class Q1267_M_CountServersThatCommunicate {

  public static void main(String[] args) {
    Q1267_M_CountServersThatCommunicate q1267MCountServersThatCommunicate =
        new Q1267_M_CountServersThatCommunicate();
    System.out.println(
        q1267MCountServersThatCommunicate.countServers(
            new int[][] {
              {1, 1, 0, 0},
              {0, 0, 1, 0},
              {0, 0, 1, 0},
              {0, 0, 0, 1},
            }));
    System.out.println(
        q1267MCountServersThatCommunicate.countServers(
            new int[][] {
              {1, 0},
              {0, 1},
            }));
    System.out.println(
        q1267MCountServersThatCommunicate.countServers(
            new int[][] {
              {1, 0},
              {1, 1},
            }));
  }

  public int countServers(int[][] grid) { // 2ms, beats 100%
    int[] rows = new int[251];
    int[] cols = new int[251];
    int n = grid.length, m = grid[0].length, cnt = 0;

    for (int i = 0; i < n; i++)
      for (int j = 0; j < m; j++)
        if (grid[i][j] == 1) {
          rows[i]++;
          cols[j]++;
        }

    for (int i = 0; i < n; i++)
      for (int j = 0; j < m; j++) if (grid[i][j] == 1) if (rows[i] > 1 || cols[j] > 1) cnt++;

    return cnt;
  }

  public int countServers2(int[][] grid) { // 6ms, beats 20.54%
    Map<Integer, Integer> rows = new HashMap<>();
    Map<Integer, Integer> cols = new HashMap<>();
    int n = grid.length, m = grid[0].length, cnt = 0;

    for (int i = 0; i < n; i++)
      for (int j = 0; j < m; j++)
        if (grid[i][j] == 1) {
          rows.compute(i, (k, v) -> v == null ? 1 : v + 1);
          cols.compute(j, (k, v) -> v == null ? 1 : v + 1);
        }

    for (int i = 0; i < n; i++)
      for (int j = 0; j < m; j++)
        if (grid[i][j] == 1) if (rows.getOrDefault(i, 0) > 1 || cols.getOrDefault(j, 0) > 1) cnt++;

    return cnt;
  }
}
