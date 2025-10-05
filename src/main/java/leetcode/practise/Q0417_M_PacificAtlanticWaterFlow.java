package leetcode.practise;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Vivek
 * @since 10/5/25
 */
public class Q0417_M_PacificAtlanticWaterFlow {
  private static final int[] X_4W = {0, 1, 0, -1}; // S, E, N, W
  private static final int[] Y_4W = {1, 0, -1, 0}; // S, E, N, W

  private int[][] heights;
  private boolean pacific, atlantic;

  public static void main(String[] args) {
    Q0417_M_PacificAtlanticWaterFlow q0417MPacificAtlanticWaterFlow =
        new Q0417_M_PacificAtlanticWaterFlow();
    System.out.println(
        q0417MPacificAtlanticWaterFlow.pacificAtlantic(
            new int[][] {
              {1, 2, 2, 3, 5}, {3, 2, 3, 4, 4}, {2, 4, 5, 3, 1}, {6, 7, 1, 4, 5}, {5, 1, 1, 2, 4}
            }));
    System.out.println(q0417MPacificAtlanticWaterFlow.pacificAtlantic(new int[][] {{1}}));
  }

  public List<List<Integer>> pacificAtlantic(int[][] heights) {
    this.heights = heights;
    List<List<Integer>> res = new ArrayList<>();

    for (int i = 0; i < heights.length; i++) {
      for (int j = 0; j < heights[i].length; j++) {
        pacific = false;
        atlantic = false;
        dfs(i, j, new boolean[heights.length][heights[i].length], heights[i][j]);
        if (pacific && atlantic) {
          List<Integer> list = new ArrayList<>();
          list.add(i);
          list.add(j);
          res.add(list);
        }
      }
    }

    return res;
  }

  private void dfs(int row, int col, boolean[][] visited, int lastLevel) {
    if (row < 0 || col < 0) {
      pacific = true;
      return;
    }
    if (row >= heights.length || col >= heights[row].length) {
      atlantic = true;
      return;
    }
    if (pacific && atlantic) return; // no need to explore further
    if (visited[row][col] || heights[row][col] > lastLevel) return;

    visited[row][col] = true;
    for (int k = 0; k < 4; k++) {
      dfs(row + X_4W[k], col + Y_4W[k], visited, heights[row][col]);
    }
  }
}
