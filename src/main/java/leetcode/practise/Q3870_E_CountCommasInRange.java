package leetcode.practise;

/**
 * @author Vivek
 * @since 2026-09-09
 */
public class Q3870_E_CountCommasInRange {
  public int countCommas(int n) {
    // if (n<1000) return 0;
    // return n-1000+1;
    return Math.max(n - 1000 + 1, 0);
  }

  public static void main(String[] args) {
    Q3870_E_CountCommasInRange q3870ECountCommasInRange = new Q3870_E_CountCommasInRange();
    System.out.println(q3870ECountCommasInRange.countCommas(1002));
    System.out.println(q3870ECountCommasInRange.countCommas(998));
  }
}
