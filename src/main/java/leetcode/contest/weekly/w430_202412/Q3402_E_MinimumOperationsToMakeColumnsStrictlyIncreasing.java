package leetcode.contest.weekly.w430_202412;

/**
 * @author Vivek
 * @since 2024-12-28
 */
public class Q3402_E_MinimumOperationsToMakeColumnsStrictlyIncreasing {

  public static void main(String[] args) {
    Q3402_E_MinimumOperationsToMakeColumnsStrictlyIncreasing
        q3402EMinimumOperationsToMakeColumnsStrictlyIncreasing =
            new Q3402_E_MinimumOperationsToMakeColumnsStrictlyIncreasing();
    System.out.println(
        q3402EMinimumOperationsToMakeColumnsStrictlyIncreasing.minimumOperations(
            new int[][] {
              {3, 2},
              {1, 3},
              {3, 4},
              {0, 1},
            }));
    System.out.println(
        q3402EMinimumOperationsToMakeColumnsStrictlyIncreasing.minimumOperations(
            new int[][] {
              {3, 2, 1},
              {2, 1, 0},
              {1, 2, 3},
            }));
    System.out.println(
        q3402EMinimumOperationsToMakeColumnsStrictlyIncreasing.minimumOperations(
            new int[][] {
              {0, 0},
              {0, 0},
            }));
  }

  public int minimumOperations(int[][] grid) {
    int cnt = 0;
    for (int j = 0; j < grid[0].length; j++) {
      int last = grid[0][j];
      for (int i = 1; i < grid.length; i++) {
        int val = grid[i][j];
        if (val > last) {
          last = val;
        } else {
          cnt += last - val + 1;
          last++;
        }
      }
    }
    return cnt;
  }
}
