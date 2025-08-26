package leetcode.practise;

/**
 * @author Vivek
 * @since 8/25/25
 */
public class Q3000_E_MaximumAreaOfLongestDiagonalRectangle {
  public static void main(String[] args) {
    Q3000_E_MaximumAreaOfLongestDiagonalRectangle q3000EMaximumAreaOfLongestDiagonalRectangle =
        new Q3000_E_MaximumAreaOfLongestDiagonalRectangle();
    System.out.println(
        q3000EMaximumAreaOfLongestDiagonalRectangle.areaOfMaxDiagonal(
            new int[][] {{9, 3}, {8, 6}}));
    System.out.println(
        q3000EMaximumAreaOfLongestDiagonalRectangle.areaOfMaxDiagonal(
            new int[][] {{3, 4}, {4, 3}}));
    System.out.println(
        q3000EMaximumAreaOfLongestDiagonalRectangle.areaOfMaxDiagonal(
            new int[][] {{6, 5}, {8, 6}, {2, 10}, {8, 1}, {9, 2}, {3, 5}, {3, 5}}));
  }

  public int areaOfMaxDiagonal(int[][] dimensions) { // 1ms, beats 96%
    int maxA = 0;
    int diag = 0;
    for (int[] dimen : dimensions) {
      int d = dimen[0] * dimen[0] + dimen[1] * dimen[1];
      int a = dimen[0] * dimen[1];
      if (d > diag) {
        diag = d;
        maxA = a;
      } else if (d == diag && a > maxA) {
        maxA = a;
      }
    }
    return maxA;
  }
}
