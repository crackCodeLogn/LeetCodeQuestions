package leetcode.practise;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Vivek
 * @since 2026-03-21
 */
public class Q1886_E_DetermineWhetherMatrixCanBeObtainedByRotation {
  int[] R = {0, 1, 0, -1};
  int[] C = {1, 0, -1, 0};

  public static void main(String[] args) {
    Q1886_E_DetermineWhetherMatrixCanBeObtainedByRotation
        q1886EDetermineWhetherMatrixCanBeObtainedByRotation =
            new Q1886_E_DetermineWhetherMatrixCanBeObtainedByRotation();
    System.out.println(
        q1886EDetermineWhetherMatrixCanBeObtainedByRotation.findRotation(
            new int[][] {{1}}, new int[][] {{0}}));
    System.out.println(
        q1886EDetermineWhetherMatrixCanBeObtainedByRotation.findRotation(
            new int[][] {{1}}, new int[][] {{1}}));
    System.out.println(
        q1886EDetermineWhetherMatrixCanBeObtainedByRotation.findRotation(
            new int[][] {{0, 1}, {1, 0}}, new int[][] {{1, 0}, {0, 1}}));
    System.out.println(
        q1886EDetermineWhetherMatrixCanBeObtainedByRotation.findRotation(
            new int[][] {{0, 1}, {1, 1}}, new int[][] {{1, 0}, {0, 1}}));
    System.out.println(
        q1886EDetermineWhetherMatrixCanBeObtainedByRotation.findRotation(
            new int[][] {{0, 0, 0}, {0, 1, 0}, {1, 1, 1}},
            new int[][] {{1, 1, 1}, {0, 1, 0}, {0, 0, 0}}));
  }

  private boolean isSame(int[][] mat, int[][] target) {
    for (int i = 0; i < mat.length; i++)
      for (int j = 0; j < mat[0].length; j++) if (mat[i][j] != target[i][j]) return false;
    return true;
  }

  private void printMatrix(int[][] matrix) {
    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix[0].length; j++) System.out.print(matrix[i][j] + " ");
      System.out.println();
    }
  }

  public boolean findRotation(int[][] mat, int[][] target) { // 3ms, beats 1.55%
    if (isSame(mat, target)) return true;

    for (int v = 1; v <= 3; v++) {
      int limit = mat.length;
      for (int st = 0; st < mat.length / 2; st++, limit -= 2) {
        Queue<Integer> queue = new LinkedList<>();
        int i = st, j = st, ctr = 0;
        queue.offer(mat[i][j]);
        for (int k = 0; k < 4; k++) {
          while (true) {
            if (ctr > 0) queue.offer(mat[i][j]);
            ctr++;
            if (ctr == limit) break;
            i += R[k];
            j += C[k];
          }
          ctr = 0;
        }
        i = st;
        j = st + limit - 1;
        mat[i][j] = queue.poll();
        ctr = 0;
        for (int k = 1; queue.size() > 1; k = (k + 1) % 4) {
          while (true) {
            if (ctr > 0) mat[i][j] = queue.poll();
            ctr++;
            if (ctr == limit) break;
            i += R[k];
            j += C[k];
          }
          ctr = 0;
        }
      }
      if (isSame(mat, target)) return true;
    }
    return false;
  }
}
