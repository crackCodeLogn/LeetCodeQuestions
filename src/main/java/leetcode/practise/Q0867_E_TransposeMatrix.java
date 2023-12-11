package leetcode.practise;

/**
 * @author Vivek
 * @since 2023-12-12
 */
public class Q0867_E_TransposeMatrix {
    public int[][] transpose(int[][] matrix) {
        int n = matrix.length;
        if (matrix.length == 0) return matrix;
        int m = matrix[0].length;
        int[][] data = new int[m][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                data[j][i] = matrix[i][j];
            }
        }
        return data;

    }
}
