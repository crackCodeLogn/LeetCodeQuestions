package leetcode.practise;

/**
 * @author Vivek
 * @since 2025-12-28
 */
public class Q1351_E_CountNegativeNumbersInASortedMatrix {
  public static void main(String[] args) {
    Q1351_E_CountNegativeNumbersInASortedMatrix q1351ECountNegativeNumbersInASortedMatrix =
        new Q1351_E_CountNegativeNumbersInASortedMatrix();
    System.out.println(
        q1351ECountNegativeNumbersInASortedMatrix.countNegatives(
            new int[][] {
              {4, 3, 2, -1},
              {3, 2, 1, -1},
              {1, 1, -1, -2},
              {-1, -1, -2, -3}
            })); // 8
    System.out.println(
        q1351ECountNegativeNumbersInASortedMatrix.countNegatives(
            new int[][] {
              {3, 2},
              {1, 0}
            })); // 0
  }

  public int countNegatives(int[][] grid) { // 0 ms, beats 100%
    int row = grid.length;
    int col = grid[0].length;
    int cnt = 0;
    for (int i = 0; i < row; i++)
      for (int j = 0; j < col; j++)
        if (grid[i][j] < 0) {
          cnt += col - j;
          break;
        }
    return cnt;
  }
}
