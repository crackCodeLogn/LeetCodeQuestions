package leetcode.contest.weekly.w443_202503;

import java.util.Arrays;

/**
 * @author Vivek
 * @since 2025-03-29
 */
public class Q3502_E_MinimumCostToReachEveryPosition {

  public static void main(String[] args) {
    Q3502_E_MinimumCostToReachEveryPosition q3502EMinimumCostToReachEveryPosition =
        new Q3502_E_MinimumCostToReachEveryPosition();
    System.out.println(
        Arrays.toString(
            q3502EMinimumCostToReachEveryPosition.minCosts(new int[] {5, 3, 4, 1, 3, 2})));
    System.out.println(
        Arrays.toString(q3502EMinimumCostToReachEveryPosition.minCosts(new int[] {1, 2, 4, 6, 7})));
  }

  public int[] minCosts(int[] cost) {
    int n = cost.length;
    int[] data = new int[n];
    Arrays.fill(data, Integer.MAX_VALUE);
    int mc = Integer.MAX_VALUE;
    for (int i = 0; i < n; i++) {
      mc = Math.min(mc, cost[i]);
      data[i] = mc;
    }
    return data;
  }
}
