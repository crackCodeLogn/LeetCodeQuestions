package leetcode.practise;

/**
 * @author Vivek
 * @since 2026-03-27
 */
public class Q2946_E_MatrixSimilarityAfterCyclicShifts {

  public static void main(String[] args) {
    Q2946_E_MatrixSimilarityAfterCyclicShifts q2946EMatrixSimilarityAfterCyclicShifts =
        new Q2946_E_MatrixSimilarityAfterCyclicShifts();
    System.out.println(
        q2946EMatrixSimilarityAfterCyclicShifts.areSimilar(
            new int[][] {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}, 4));
    System.out.println(
        q2946EMatrixSimilarityAfterCyclicShifts.areSimilar(
            new int[][] {{1, 2, 1, 2}, {5, 5, 5, 5}, {6, 3, 6, 3}}, 2));
    System.out.println(
        q2946EMatrixSimilarityAfterCyclicShifts.areSimilar(new int[][] {{2, 2}, {2, 2}}, 3));
  }

  public boolean areSimilar(int[][] mat, int k) { // 1ms, beats 99.47%
    k %= mat[0].length;
    for (int i = 0; i < mat.length; i++)
      for (int j = 0; j < mat[0].length; j++)
        if ((i & 1) == 1) {
          if (mat[i][j] != mat[i][(j + k) % mat[0].length]) return false;
        } else {
          if (mat[i][j] != mat[i][(j - k + mat[0].length) % mat[0].length]) return false;
        }
    return true;
  }
}
