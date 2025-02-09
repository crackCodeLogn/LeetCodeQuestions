package leetcode.contest.weekly.w436_202502;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author Vivek
 * @since 2025-02-08
 */
public class Q3446_E_SortMatrixByDiamonds {

  public static void main(String[] args) {
    Q3446_E_SortMatrixByDiamonds q3446ESortMatrixByDiamonds = new Q3446_E_SortMatrixByDiamonds();
    System.out.println(
        Arrays.deepToString(
            q3446ESortMatrixByDiamonds.sortMatrix(
                new int[][] {
                  {1, 7, 3},
                  {9, 8, 2},
                  {4, 5, 6}
                })));
  }

  public int[][] sortMatrix(int[][] grid) {
    int n = grid.length;
    for (int k = 0; k < n; k++) {
      List<Integer> value = new ArrayList<>();
      for (int i = k, j = 0; j < n && i < n; i++, j++) value.add(grid[i][j]);
      value.sort(Collections.reverseOrder());
      for (int i = k, j = 0; j < n && i < n; i++, j++) grid[i][j] = value.get(j);
    }
    for (int k = 1; k < n; k++) {
      List<Integer> value = new ArrayList<>();
      for (int i = 0, j = k; j < n && i < n; i++, j++) value.add(grid[i][j]);
      Collections.sort(value);
      for (int i = 0, j = k; j < n && i < n; i++, j++) grid[i][j] = value.get(i);
    }

    return grid;
  }
}
