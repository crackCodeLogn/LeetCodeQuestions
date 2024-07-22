package leetcode.practise;

/**
 * @author Vivek
 * @since 2024-07-22
 */
public class Q1605_M_FindValidMatrixGivenRowAndColumnSums {

    public int[][] restoreMatrix(int[] rowSum, int[] colSum) {
        int n = rowSum.length, m = colSum.length;
        int[][] data = new int[rowSum.length][colSum.length];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                data[i][j] = Math.min(rowSum[i], colSum[j]);
                rowSum[i] -= data[i][j];
                colSum[j] -= data[i][j];
            }
        }
        return data;
    }
}
