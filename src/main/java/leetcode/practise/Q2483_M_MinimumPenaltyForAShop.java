package leetcode.practise;

/**
 * @author Vivek
 * @since 2025-12-25
 */
public class Q2483_M_MinimumPenaltyForAShop {

  public static void main(String[] args) {
    Q2483_M_MinimumPenaltyForAShop q2483MMinimumPenaltyForAShop =
        new Q2483_M_MinimumPenaltyForAShop();
    System.out.println(q2483MMinimumPenaltyForAShop.bestClosingTime("YNYY")); // 4
    System.out.println(q2483MMinimumPenaltyForAShop.bestClosingTime("YYNY")); // 2
    System.out.println(q2483MMinimumPenaltyForAShop.bestClosingTime("NNNNN")); // 0
    System.out.println(q2483MMinimumPenaltyForAShop.bestClosingTime("YYYY")); // 4
  }

  public int bestClosingTime(String customers) { // 13ms, beats 47.24%
    int n = customers.length();
    int[] yc = new int[n + 1];
    int[] nc = new int[n + 1];
    for (int i = 0; i < n; i++) nc[i + 1] = nc[i] + (customers.charAt(i) == 'N' ? 1 : 0);
    for (int i = n - 1; i >= 0; i--) yc[i] = yc[i + 1] + ((customers.charAt(i) == 'Y') ? 1 : 0);
    int min = Integer.MAX_VALUE, minI = -1;
    for (int i = 0; i <= n; i++)
      if (yc[i] + nc[i] < min) {
        min = yc[i] + nc[i];
        minI = i;
      }
    return minI;
  }
}
