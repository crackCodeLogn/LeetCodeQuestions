package leetcode.contest.weekly.w447_202504;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Vivek
 * @since 2025-04-26
 */
public class Q3531_M_CountCoveredBuildings {

  public static void main(String[] args) {
    Q3531_M_CountCoveredBuildings q3531MCountCoveredBuildings = new Q3531_M_CountCoveredBuildings();
    System.out.println(
        q3531MCountCoveredBuildings.countCoveredBuildings(
            4,
            new int[][] {
              {2, 4},
              {1, 2},
              {3, 1},
              {1, 4},
              {2, 3},
              {3, 3},
              {2, 2},
              {1, 3}
            })); // 1
    System.out.println(
        q3531MCountCoveredBuildings.countCoveredBuildings(
            3, new int[][] {{1, 2}, {2, 2}, {3, 2}, {2, 1}, {2, 3}})); // 1
    System.out.println(
        q3531MCountCoveredBuildings.countCoveredBuildings(
            3, new int[][] {{1, 1}, {1, 2}, {2, 1}, {2, 2}})); // 0
    System.out.println(
        q3531MCountCoveredBuildings.countCoveredBuildings(
            5, new int[][] {{1, 3}, {3, 2}, {3, 3}, {3, 5}, {5, 3}})); // 0
  }

  public int countCoveredBuildings(int n, int[][] buildings) { // 106ms, beats 90.95%
    Map<Integer, int[]> rows = new HashMap<>();
    Map<Integer, int[]> cols = new HashMap<>();

    for (int[] building : buildings) {
      int r = building[0], c = building[1];

      int[] row;
      if (rows.containsKey(r)) {
        row = rows.get(r);
        if (c < row[0]) row[0] = c;
        else if (c > row[1]) row[1] = c;
      } else {
        row = genArr(c);
        rows.put(r, row);
      }

      int[] col;
      if (cols.containsKey(c)) {
        col = cols.get(c);
        if (r < col[0]) col[0] = r;
        else if (r > col[1]) col[1] = r;
      } else {
        col = genArr(r);
        cols.put(c, col);
      }
    }
    int cnt = 0;
    for (int[] building : buildings) {
      int r = building[0], c = building[1];
      int[] row = rows.get(r), col = cols.get(c);
      if (c > row[0] && c < row[1] && r > col[0] && r < col[1]) cnt++;
    }

    return cnt;
  }

  private int[] genArr(int r) {
    return new int[] {r, r};
  }
}
