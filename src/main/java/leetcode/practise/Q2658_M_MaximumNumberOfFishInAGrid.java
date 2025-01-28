package leetcode.practise;

/**
 * @author Vivek
 * @since 2025-01-27
 */
public class Q2658_M_MaximumNumberOfFishInAGrid {
  private static final int[] X_4W = {0, 1, 0, -1};
  private static final int[] Y_4W = {1, 0, -1, 0};

  public static void main(String[] args) {
    Q2658_M_MaximumNumberOfFishInAGrid q2658MMaximumNumberOfFishInAGrid =
        new Q2658_M_MaximumNumberOfFishInAGrid();
    System.out.println(
        q2658MMaximumNumberOfFishInAGrid.findMaxFish(
            new int[][] {
              {0, 2, 1, 0},
              {4, 0, 0, 3},
              {1, 0, 0, 4},
              {0, 3, 2, 0},
            }));
    System.out.println(
        q2658MMaximumNumberOfFishInAGrid.findMaxFish(
            new int[][] {
              {1, 0, 0, 0},
              {0, 0, 0, 0},
              {0, 0, 0, 0},
              {0, 0, 0, 1},
            }));
  }

  public int findMaxFish(int[][] grid) { // 3ms, beats 100%
    int maxFish = 0;
    int n = grid.length, m = grid[0].length;

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        if (grid[i][j] > 0) {
          maxFish = Math.max(maxFish, dfs(grid, i, j));
        }
      }
    }

    return maxFish;
  }

  private int dfs(int[][] grid, int i, int j) {
    if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == 0) return 0;

    int val = grid[i][j];
    grid[i][j] = 0;

    for (int k = 0; k < X_4W.length; k++) {
      val += dfs(grid, i + X_4W[k], j + Y_4W[k]);
    }
    return val;
  }
}
