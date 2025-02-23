package leetcode.contest.weekly.w438_202502;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @author Vivek
 * @since 2025-02-22
 */
public class Q3462_M_MaximumSumWithAtMostKElements {

  public static void main(String[] args) {
    Q3462_M_MaximumSumWithAtMostKElements q3462MMaximumSumWithAtMostKElements =
        new Q3462_M_MaximumSumWithAtMostKElements();
    System.out.println(
        q3462MMaximumSumWithAtMostKElements.maxSum(
            new int[][] {
              {7, 10, 3, 3, 7, 7, 0},
              {5, 5, 9, 2, 10, 5, 2},
            },
            new int[] {3, 7},
            7));
    System.out.println(
        q3462MMaximumSumWithAtMostKElements.maxSum(
            new int[][] {
              {1, 2},
              {3, 4},
            },
            new int[] {1, 2},
            2));
    System.out.println(
        q3462MMaximumSumWithAtMostKElements.maxSum(
            new int[][] {
              {5, 3, 7},
              {8, 2, 6},
            },
            new int[] {2, 2},
            3));
  }

  public long maxSum(int[][] grid, int[] limits, int k) {
    long result = 0;

    List<PriorityQueue<Integer>> dataList = new ArrayList<>(grid.length);
    for (int i = 0; i < grid.length; i++) {
      PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());
      for (int j = 0; j < grid[0].length; j++) queue.add(grid[i][j]);
      dataList.add(queue);
    }

    while (k-- > 0) {
      int currentMaxIndex = -1;
      int max = -1;

      for (int i = 0; i < grid.length; i++) {
        if (limits[i] <= 0) continue;
        if (dataList.get(i).isEmpty()) continue;
        int peek = dataList.get(i).peek();
        if (peek > max) {
          max = peek;
          currentMaxIndex = i;
        }
      }
      if (max == -1) break;
      result += dataList.get(currentMaxIndex).poll();
      limits[currentMaxIndex]--;
    }

    return result;
  }
}
