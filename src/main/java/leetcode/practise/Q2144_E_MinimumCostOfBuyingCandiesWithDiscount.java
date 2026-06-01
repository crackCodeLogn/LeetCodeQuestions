package leetcode.practise;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author Vivek
 * @since 2026-05-31
 */
public class Q2144_E_MinimumCostOfBuyingCandiesWithDiscount {

  public static void main(String[] args) {
    Q2144_E_MinimumCostOfBuyingCandiesWithDiscount q2144EMinimumCostOfBuyingCandiesWithDiscount =
        new Q2144_E_MinimumCostOfBuyingCandiesWithDiscount();
    System.out.println(
        q2144EMinimumCostOfBuyingCandiesWithDiscount.minimumCost(new int[] {1, 2, 3}));
    System.out.println(
        q2144EMinimumCostOfBuyingCandiesWithDiscount.minimumCost(new int[] {6, 5, 7, 9, 2, 2}));
    System.out.println(q2144EMinimumCostOfBuyingCandiesWithDiscount.minimumCost(new int[] {5, 5}));
  }

  public int minimumCost(int[] cost) { // 4ms, beats 98.44%
    PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
    for (int v : cost) pq.offer(v);
    int sum = 0;
    int counter = 1;
    while (!pq.isEmpty()) {
      int v = pq.poll();
      if (counter != 3) sum += v;
      else counter = 0;
      counter++;
    }
    return sum;
  }
}
