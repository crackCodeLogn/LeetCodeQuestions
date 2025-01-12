package leetcode.contest.weekly.w432_202501;

/**
 * @author Vivek
 * @since 2025-01-11
 */
public class Q3418_M_MaximumAmountOfMoneyRobotCanEarn {
  int[][] coins;
  int n, m;
  int[][][] dp;

  public static void main(String[] args) {
    Q3418_M_MaximumAmountOfMoneyRobotCanEarn q3418MMaximumAmountOfMoneyRobotCanEarn = new Q3418_M_MaximumAmountOfMoneyRobotCanEarn();
    System.out.println(
        q3418MMaximumAmountOfMoneyRobotCanEarn.maximumAmount(
            new int[][] {
              {-7, 12, 12, 13},
              {-6, 19, 19, -6},
              {9, -2, -10, 16},
              {-4, 14, -10, -9}
            }));
    System.out.println(
        q3418MMaximumAmountOfMoneyRobotCanEarn.maximumAmount(
            new int[][] {
              {0, 1, -1},
              {1, -2, 3},
              {2, -3, 4},
            }));
    System.out.println(
        q3418MMaximumAmountOfMoneyRobotCanEarn.maximumAmount(
            new int[][] {
              {10, 10, 10},
              {10, 10, 10},
            }));
  }

  public int maximumAmount(int[][] coins) {
    this.coins = coins;
    n = coins.length;
    m = coins[0].length;
    dp = new int[n][m][3];
    for (int i = 0; i < n; i++)
      for (int j = 0; j < m; j++) for (int k = 0; k < 3; k++) dp[i][j][k] = Integer.MIN_VALUE;

    return compute(n - 1, m - 1, 2);
  }

  public int compute(int i, int j, int neutral) {
    if (i < 0 || j < 0 || i >= n || j >= m) return Integer.MIN_VALUE;
    if (i == 0 && j == 0) { // base
      if (coins[i][j] < 0) return neutral > 0 ? 0 : coins[i][j];
      return coins[i][j];
    }
    if (dp[i][j][neutral] != Integer.MIN_VALUE) return dp[i][j][neutral];

    int v;
    if (coins[i][j] >= 0 || neutral == 0) {
      v = coins[i][j] + Math.max(compute(i - 1, j, neutral), compute(i, j - 1, neutral));
    } else {
      v =
          Math.max(
              coins[i][j] + Math.max(compute(i - 1, j, neutral), compute(i, j - 1, neutral)),
              Math.max(compute(i - 1, j, neutral - 1), compute(i, j - 1, neutral - 1)));
    }
    dp[i][j][neutral] = v;
    return v;
  }
}
