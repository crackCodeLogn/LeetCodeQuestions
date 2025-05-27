package leetcode.practise;

/**
 * @author Vivek
 * @since 2025-05-25
 */
public class Q3560_E_FindMinimumLogTransportationCost {
  public static void main(String[] args) {
    Q3560_E_FindMinimumLogTransportationCost q3560EFindMinimumLogTransportationCost =
        new Q3560_E_FindMinimumLogTransportationCost();
    System.out.println(q3560EFindMinimumLogTransportationCost.minCuttingCost(6, 5, 5));
    System.out.println(q3560EFindMinimumLogTransportationCost.minCuttingCost(4, 4, 6));
  }

  public long minCuttingCost(int n, int m, int k) {
    if (k >= m && k >= n) return 0L;
    if (m <= k) return ((long) k) * (n - k);
    else return ((long) k) * (m - k);
  }
}
