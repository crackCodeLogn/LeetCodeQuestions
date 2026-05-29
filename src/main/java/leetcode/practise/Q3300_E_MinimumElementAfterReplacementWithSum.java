package leetcode.practise;

/**
 * @author Vivek
 * @since 2026-05-28
 */
public class Q3300_E_MinimumElementAfterReplacementWithSum {
  public static void main(String[] args) {
    Q3300_E_MinimumElementAfterReplacementWithSum q3300EMinimumElementAfterReplacementWithSum =
        new Q3300_E_MinimumElementAfterReplacementWithSum();
    System.out.println(
        q3300EMinimumElementAfterReplacementWithSum.minElement(new int[] {10, 12, 13, 14}));
    System.out.println(
        q3300EMinimumElementAfterReplacementWithSum.minElement(new int[] {1, 2, 3, 4, 5}));
    System.out.println(
        q3300EMinimumElementAfterReplacementWithSum.minElement(new int[] {999, 19, 199}));
  }

  public int minElement(int[] nums) {
    int min = Integer.MAX_VALUE;
    for (int v : nums) min = Math.min(min, sum(v));
    return min;
  }

  private int sum(int n) {
    int sum = 0;
    while (n > 0) {
      sum += n % 10;
      n /= 10;
    }
    return sum;
  }
}
