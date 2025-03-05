package leetcode.practise;

/**
 * @author Vivek
 * @since 2025-03-04
 */
public class Q2579_M_CountTotalNumberOfColoredCells {

  public static void main(String[] args) {
    Q2579_M_CountTotalNumberOfColoredCells q2579MCountTotalNumberOfColoredCells =
        new Q2579_M_CountTotalNumberOfColoredCells();
    System.out.println(q2579MCountTotalNumberOfColoredCells.coloredCells(1)); // 1
    System.out.println(q2579MCountTotalNumberOfColoredCells.coloredCells(2)); // 5
    System.out.println(q2579MCountTotalNumberOfColoredCells.coloredCells(3)); // 13
  }

  public long coloredCells(int n) { // 0ms, beats 100%
    if (n == 1) return 1;
    long v = n;
    return 2 * v * (v - 1) + 1;
  }
}
