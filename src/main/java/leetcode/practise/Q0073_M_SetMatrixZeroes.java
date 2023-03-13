package leetcode.practise;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Vivek
 * @since 2023-03-14
 */
public class Q0073_M_SetMatrixZeroes {

    public void setZeroes(int[][] matrix) {
        Set<Integer> rows = new HashSet<>();
        Set<Integer> columns = new HashSet<>();
        int m = matrix.length, n = matrix[0].length;

        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                if (matrix[i][j] == 0) {
                    rows.add(i);
                    columns.add(j);
                }

        for (Integer row : rows) for (int i = 0; i < n; i++) matrix[row][i] = 0;
        for (Integer col : columns) for (int i = 0; i < m; i++) matrix[i][col] = 0;
    }
}
