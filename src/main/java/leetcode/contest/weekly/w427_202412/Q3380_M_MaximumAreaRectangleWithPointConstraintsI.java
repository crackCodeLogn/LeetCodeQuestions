package leetcode.contest.weekly.w427_202412;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Vivek
 * @since 2024-12-07
 */
public class Q3380_M_MaximumAreaRectangleWithPointConstraintsI {

  public static void main(String[] args) {
    Q3380_M_MaximumAreaRectangleWithPointConstraintsI
        q3380MMaximumAreaRectangleWithPointConstraintsI =
            new Q3380_M_MaximumAreaRectangleWithPointConstraintsI();
    System.out.println(
        q3380MMaximumAreaRectangleWithPointConstraintsI.maxRectangleArea(
            new int[][] {
              {1, 1},
              {1, 3},
              {3, 1},
              {3, 3}
            }));
    System.out.println(
        q3380MMaximumAreaRectangleWithPointConstraintsI.maxRectangleArea(
            new int[][] {
              {1, 1},
              {1, 3},
              {3, 1},
              {3, 3},
              {2, 2}
            }));
    System.out.println(
        q3380MMaximumAreaRectangleWithPointConstraintsI.maxRectangleArea(
            new int[][] {
              {1, 1},
              {1, 3},
              {3, 1},
              {3, 3},
              {1, 2},
              {3, 2}
            }));
    System.out.println(
        q3380MMaximumAreaRectangleWithPointConstraintsI.maxRectangleArea(
            new int[][] {
              {3, 42},
              {62, 23},
              {3, 46},
              {62, 46},
              {3, 23}
            }));
  }

  public int maxRectangleArea(int[][] points) {
    int length = 101;
    boolean[][] grid = new boolean[length][length];
    for (int[] point : points) grid[point[0]][point[1]] = true;

    int maxArea = -1;

    for (int y = length - 1; y >= 0; y--) {
      int p1 = -1, p2;
      for (int x = 0; x < length; x++) {
        if (grid[x][y]) {
          if (p1 != -1) {
            p2 = x;

            // analyze
            outer:
            for (int k = y - 1; k >= 0; k--) {
              for (int v = p1 + 1; v <= p2 - 1; v++) {
                if (grid[v][k]) {
                  break outer;
                }
              }
              if (grid[p1][k] && grid[p2][k]) {
                maxArea = Math.max(maxArea, (p2 - p1) * (y - k));
                break;
              } else if (grid[p1][k] || grid[p2][k]) {
                break;
              }
            }
          }
          p1 = x;
        }
      }
    }

    return maxArea;
  }

  public int maxRectangleArea2(int[][] points) {
    Map<Integer, List<Point>> rowPointMap = new HashMap<>();
    Map<Integer, List<Point>> colPointMap = new HashMap<>();
    for (int i = 0; i <= 101; i++) {
      rowPointMap.put(i, new ArrayList<>());
      colPointMap.put(i, new ArrayList<>());
    }
    for (int[] point : points) {
      Point p = new Point(point[0], point[1]);
      rowPointMap.get(p.x).add(p);
      colPointMap.get(p.y).add(p);
    }

    int maxArea = -1;
    for (int i = 101; i >= 0; i--) {
      List<Point> rpl = colPointMap.get(i);

      if (rpl.size() < 2) continue;
      Point p1 = rpl.get(0);
      for (int j = 1; j < rpl.size(); j++) {
        Point p2 = rpl.get(j);

        List<Point> c1Points = rowPointMap.get(p1.x);
        List<Point> c2Points = rowPointMap.get(p2.x);
        if (c1Points.isEmpty() || c2Points.isEmpty()) {
          p1 = p2;
          continue;
        }
        int diff = Integer.MAX_VALUE;
        for (Point c1Point : c1Points) {
          if (c1Point.y < p1.y) {
            diff = p1.y - c1Point.y;
            break;
          }
        }
        if (diff == Integer.MAX_VALUE) {
          p1 = p2;
          continue;
        }
        boolean flag = false;
        for (Point c2Point : c2Points) {
          if (c2Point.y < p2.y) {
            diff = Math.min(diff, p2.y - c2Point.y);
            flag = true;
            break;
          }
        }
        if (flag) {
          maxArea = Math.max(maxArea, (p2.x - p1.x) * diff);
        }
      }
    }

    return maxArea;
  }

  private record Point(int x, int y) {}
}
