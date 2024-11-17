package leetcode.contest.weekly.w422_202411;

/**
 * @author Vivek
 * @since 2024-11-02
 */
public class Q3341_M_FindMinimumTimeToReachLastRoomI_WA {
  private int[][] dp;
  private int[][] moveTime;

  public static void main(String[] args) {
    Q3341_M_FindMinimumTimeToReachLastRoomI_WA q3341MFindMinimumTimeToReachLastRoomIWA =
        new Q3341_M_FindMinimumTimeToReachLastRoomI_WA(); /*
                                                          System.out.println(
                                                              q2.minTimeToReach(
                                                                  new int[][] {
                                                                    {0, 4},
                                                                    {4, 4},
                                                                  }));
                                                          System.out.println(
                                                              q2.minTimeToReach(
                                                                  new int[][] {
                                                                    {0, 0, 0},
                                                                    {0, 0, 0},
                                                                  }));
                                                          System.out.println(
                                                              q2.minTimeToReach(
                                                                  new int[][] {
                                                                    {0, 1},
                                                                    {1, 2},
                                                                  }));*/
    System.out.println(
        q3341MFindMinimumTimeToReachLastRoomIWA.minTimeToReach(
            new int[][] {
              {1, 5, 57},
              {100, 22, 51},
            }));
  }

  public int minTimeToReach(int[][] moveTime) {
    this.moveTime = moveTime;
    this.dp = new int[moveTime.length][moveTime[0].length];
    boolean[][] visited = new boolean[moveTime.length][moveTime[0].length];

    return compute(0, 0, visited, 0);
  }

  private int compute(int i, int j, boolean[][] visited, int time) {
    if (i < 0 || j < 0 || i >= moveTime.length || j >= moveTime[0].length || visited[i][j]) {
      return 2600;
    }

    if (i == moveTime.length - 1 && j == moveTime[0].length - 1) {
      return time;
    }
    // System.out.println(i + " " + j + " " + time);
    if (dp[i][j] > 0 && dp[i][j] < time) return dp[i][j];
    visited[i][j] = true;
    int v1 = compute(i - 1, j, visited, time + 1 + safe(i - 1, j, time, visited));
    int v2 = compute(i + 1, j, visited, time + 1 + safe(i + 1, j, time, visited));
    int v3 = compute(i, j - 1, visited, time + 1 + safe(i, j - 1, time, visited));
    int v4 = compute(i, j + 1, visited, time + 1 + safe(i, j + 1, time, visited));
    visited[i][j] = false;
    int v = Math.min(v1, Math.min(v2, Math.min(v3, v4)));
    dp[i][j] = v;
    return v;
  }

  private int safe(int i, int j, int time, boolean[][] visited) {
    if (i < 0 || j < 0 || i >= moveTime.length || j >= moveTime[0].length || visited[i][j])
      return 2600;
    return Math.max(moveTime[i][j] - time, 0);
  }
}
