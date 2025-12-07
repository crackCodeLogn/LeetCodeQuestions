package leetcode.practise;

/**
 * @author Vivek
 * @since 2025-12-06
 */
public class Q1523_E_CountOddNumbersInAnIntervalRange {

  public static void main(String[] args) {
    Q1523_E_CountOddNumbersInAnIntervalRange q1523ECountOddNumbersInAnIntervalRange =
        new Q1523_E_CountOddNumbersInAnIntervalRange();
    System.out.println(q1523ECountOddNumbersInAnIntervalRange.countOdds(3, 3));
    System.out.println(q1523ECountOddNumbersInAnIntervalRange.countOdds(4, 8));
    System.out.println(q1523ECountOddNumbersInAnIntervalRange.countOdds(4, 5));
    System.out.println(q1523ECountOddNumbersInAnIntervalRange.countOdds(3, 7));
    System.out.println(q1523ECountOddNumbersInAnIntervalRange.countOdds(8, 10));
  }

  public int countOdds(int low, int high) {
    low = isOdd(low) ? low : low + 1;
    high = isOdd(high) ? high : high - 1;
    if (low > high) return 0;
    return (high - low) / 2 + 1;
  }

  private boolean isOdd(int n) {
    return (n & 1) == 1;
  }
}
