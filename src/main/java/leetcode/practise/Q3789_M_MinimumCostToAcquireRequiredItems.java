package leetcode.practise;

public class Q3789_M_MinimumCostToAcquireRequiredItems {
  public long minimumCost(
      int cost1, int cost2, int costBoth, int need1, int need2) { // 2ms, beats 41.18%
    long c1 = cost1, c2 = cost2, c3 = costBoth, n1 = need1, n2 = need2;
    long sum = c1 * n1 + c2 * n2;
    if (need1 > need2) {
      long m = Math.min(n1, n2);
      sum = Math.min(sum, m * c3 + (need1 - m) * c1);
    } else {
      long m = Math.min(n1, n2);
      sum = Math.min(sum, m * c3 + (need2 - m) * c2);
    }
    sum = Math.min(sum, c3 * Math.max(n1, n2));
    return sum;
  }

  public static void main(String[] args) {
    Q3789_M_MinimumCostToAcquireRequiredItems q3789MMinimumCostToAcquireRequiredItems =
        new Q3789_M_MinimumCostToAcquireRequiredItems();
    System.out.println(
        q3789MMinimumCostToAcquireRequiredItems.minimumCost(54, 41, 67, 3, 10)); // 488
    System.out.println(q3789MMinimumCostToAcquireRequiredItems.minimumCost(3, 2, 1, 3, 2));
    System.out.println(q3789MMinimumCostToAcquireRequiredItems.minimumCost(5, 4, 15, 2, 3));
    System.out.println(q3789MMinimumCostToAcquireRequiredItems.minimumCost(5, 4, 15, 0, 0));
  }
}
