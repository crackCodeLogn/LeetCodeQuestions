package leetcode.contest.weekly.w432_202501;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Vivek
 * @since 2025-01-11
 */
public class Q3417_E_ZigzagGridTraversalWithSkip {

  public static void main(String[] args) {
    Q3417_E_ZigzagGridTraversalWithSkip q3417EZigzagGridTraversalWithSkip = new Q3417_E_ZigzagGridTraversalWithSkip();
  }

  public List<Integer> zigzagTraversal(int[][] grid) {
    List<Integer> list = new ArrayList<>();
    int cols = grid[0].length;
    boolean flag = true, rowFlag = true;
    for (int i = 0; i < grid.length; i++, rowFlag = !rowFlag) {
      if (rowFlag) {
        for (int j = 0; j < cols; j++, flag = !flag) {
          if (flag) list.add(grid[i][j]);
        }
      } else {
        for (int j = grid[0].length - 1; j >= 0; j--, flag = !flag) {
          if (flag) list.add(grid[i][j]);
        }
      }
    }

    return list;
  }
}
