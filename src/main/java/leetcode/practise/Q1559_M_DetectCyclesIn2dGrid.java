package leetcode.practise;


/**
 * @author Vivek
 * @since 2026-04-25
 */
public class Q1559_M_DetectCyclesIn2dGrid {
  private static final int[] X_4W = {1, 0, -1, 0}; // E, S, W, N
  private static final int[] Y_4W = {0, 1, 0, -1}; // E, S, W, N
  private char[][] grid;
  private int[][][] visited;
  private boolean[][] marked;

  // private boolean result; // discard usage

  public static void main(String[] args) {
    Q1559_M_DetectCyclesIn2dGrid q1559MDetectCyclesIn2dGrid = new Q1559_M_DetectCyclesIn2dGrid();
    System.out.println(
        q1559MDetectCyclesIn2dGrid.containsCycle(
            new char[][] {
              {'a', 'a', 'a', 'a'},
              {'a', 'b', 'b', 'a'},
              {'a', 'b', 'b', 'a'},
              {'a', 'a', 'a', 'a'},
            }));
    System.out.println(
        q1559MDetectCyclesIn2dGrid.containsCycle(
            new char[][] {
              {'c', 'c', 'c', 'a'},
              {'c', 'd', 'c', 'c'},
              {'c', 'c', 'e', 'c'},
              {'f', 'c', 'c', 'c'},
            }));
    System.out.println(
        q1559MDetectCyclesIn2dGrid.containsCycle(
            new char[][] {
              {'a', 'b', 'b'},
              {'b', 'z', 'b'},
              {'b', 'b', 'a'},
            }));
  }

  public boolean containsCycle(char[][] grid) { // 42ms, beats 5.85%
    this.grid = grid;
    //    result = false;
    flushVisited();
    for (int i = 0; i < grid.length; i++)
      for (int j = 0; j < grid[0].length; j++) {
        // flushVisited();
        if (!marked[i][j] && dfs(i, j, -1, -1, 0, i, j)) return true;
      }
    return false;
  }

  private void flushVisited() {
    visited = new int[grid.length][grid[0].length][2];
    marked = new boolean[grid.length][grid[0].length];
    //    for (int i = 0; i < visited.length; i++)
    //      for (int j = 0; j < visited[i].length; j++) Arrays.fill(visited[i][j], -1);
  }

  private boolean dfs(int i, int j, int prevI, int prevJ, int step, int i0, int j0) {
    //    if (step > 0 && i == i0 && j == j0) {
    //      if (i == visited[prevI][prevJ][0] && j == visited[prevI][prevJ][1]) return;
    //      result = true;
    //      return;
    //    }
    marked[i][j] = true;
    //    if (step > 0) {
    //      visited[i][j][0] = prevI;
    //      visited[i][j][1] = prevJ;
    //      marked[i][j] = true;
    //    }
    //    System.out.println("\t>>" + i + " " + j + " " + step + " " + i0 + " " + j0 + " " +
    // grid[i][j]);
    //    for (int k = 0; k < 4 && !result; k++) {
    for (int k = 0; k < 4; k++) {
      int ni = i + X_4W[k];
      int nj = j + Y_4W[k];

      if (ni < 0
          || nj < 0
          || ni >= grid.length
          || nj >= grid[0].length
          || (ni == prevI && nj == prevJ)
          || grid[ni][nj] != grid[i0][j0]) continue;
      if (marked[ni][nj]) return true;
      if (dfs(ni, nj, i, j, step + 1, i0, j0)) return true;
    }
    // marked[i][j] = false;
    return false;
  }
}
