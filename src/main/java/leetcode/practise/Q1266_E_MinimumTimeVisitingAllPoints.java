package leetcode.practise;

/**
 * @author Vivek
 * @since 2026-01-11
 */
public class Q1266_E_MinimumTimeVisitingAllPoints {

  public static void main(String[] args) {
    Q1266_E_MinimumTimeVisitingAllPoints q1266EMinimumTimeVisitingAllPoints =
        new Q1266_E_MinimumTimeVisitingAllPoints();
    System.out.println(
        q1266EMinimumTimeVisitingAllPoints.minTimeToVisitAllPoints(
            new int[][] {
              {1, 1},
              {3, 4},
              {-1, 0}
            }));
    System.out.println(
        q1266EMinimumTimeVisitingAllPoints.minTimeToVisitAllPoints(
            new int[][] {
              {3, 2},
              {-2, 2}
            }));
  }

  public int minTimeToVisitAllPoints(int[][] points) { // 1md, beats 95.28%
    int ans = 0;
    for (int i = 1; i < points.length; i++) {
      int dx = Math.abs(points[i][0] - points[i - 1][0]);
      int dy = Math.abs(points[i][1] - points[i - 1][1]);
      ans += Math.max(dx, dy);
    }
    return ans;
  }
}
