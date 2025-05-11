package leetcode.contest.weekly.w449_202505;

/**
 * @author Vivek
 * @since 2025-05-10
 */
public class Q3546_M_EqualSumGridPartitionI {

  public static void main(String[] args) {
    Q3546_M_EqualSumGridPartitionI q3546MEqualSumGridPartitionI =
        new Q3546_M_EqualSumGridPartitionI();
    System.out.println(
        q3546MEqualSumGridPartitionI.canPartitionGrid(
            new int[][] {
              {33955}, {33955},
            }));
    System.out.println(
        q3546MEqualSumGridPartitionI.canPartitionGrid(
            new int[][] {
              {1, 2, 8},
              {5, 6, 7},
              {10, 9, 5},
            }));
    System.out.println(
        q3546MEqualSumGridPartitionI.canPartitionGrid(
            new int[][] {
              {1, 4},
              {2, 3},
            }));
    System.out.println(
        q3546MEqualSumGridPartitionI.canPartitionGrid(
            new int[][] {
              {1, 3},
              {2, 4},
            }));
  }

  public boolean canPartitionGrid(int[][] grid) {
    int m = grid.length, n = grid[0].length;
    int[] rowSum = new int[m], colSum = new int[n];
    int[] cmRowSum = new int[m], cmColSum = new int[n];

    for (int i = 0; i < m; i++) for (int j = 0; j < n; j++) rowSum[i] += grid[i][j];
    for (int j = 0; j < n; j++) for (int i = 0; i < m; i++) colSum[j] += grid[i][j];
    int prev = 0;
    for (int i = 0; i < rowSum.length; i++) {
      cmRowSum[i] = prev + rowSum[i];
      prev = cmRowSum[i];
    }
    prev = 0;
    for (int j = 0; j < colSum.length; j++) {
      cmColSum[j] = prev + colSum[j];
      prev = cmColSum[j];
    }
    // check cols
    for (int j = 0; j < cmColSum.length - 1; j++)
      if (cmColSum[n - 1] == 2 * cmColSum[j]) return true;
    // check rows
    for (int i = 0; i < cmRowSum.length - 1; i++)
      if (cmRowSum[m - 1] == 2 * cmRowSum[i]) return true;
    return false;
  }
}
