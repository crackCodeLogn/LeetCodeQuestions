package leetcode.practise;

/**
 * @author Vivek
 * @since 2026-03-20
 */
public class Q3643_E_FlipSquareSubmatrixVertically {

  private static <T> void printMatrix(int[][] data) {
    for (int i = -1; ++i < data.length; ) {
      for (int j = -1; ++j < data[0].length; ) System.out.print(data[i][j] + " ");
      System.out.println();
    }
  }

  public static void main(String[] args) {
    Q3643_E_FlipSquareSubmatrixVertically q3643EFlipSquareSubmatrixVertically =
        new Q3643_E_FlipSquareSubmatrixVertically();
    printMatrix(
        q3643EFlipSquareSubmatrixVertically.reverseSubmatrix(
            new int[][] {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}}, 1, 0, 3));
    printMatrix(
        q3643EFlipSquareSubmatrixVertically.reverseSubmatrix(
            new int[][] {{3, 4, 2, 3}, {2, 3, 4, 2}}, 0, 2, 2));
  }

  public int[][] reverseSubmatrix(int[][] grid, int x, int y, int k) { // 1ms, beats 58.37%
    for (int j = y; j < y + k; j++) {
      for (int i = x, i2 = x + k - 1; i < i2; i++, i2--) {
        int tmp = grid[i][j];
        grid[i][j] = grid[i2][j];
        grid[i2][j] = tmp;
      }
    }
    return grid;
  }
}
