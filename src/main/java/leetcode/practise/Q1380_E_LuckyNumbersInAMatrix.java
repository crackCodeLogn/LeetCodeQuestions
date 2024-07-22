package leetcode.practise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Vivek
 * @since 2024-07-22
 */
public class Q1380_E_LuckyNumbersInAMatrix {

    public List<Integer> luckyNumbers(int[][] matrix) {
        List<Integer> data = new ArrayList<>();

        int n = matrix.length, m = matrix[0].length;
        int[] minRow = new int[n];
        Arrays.fill(minRow, Integer.MAX_VALUE);
        int[] maxCol = new int[m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] < minRow[i]) minRow[i] = matrix[i][j];
                if (matrix[i][j] > maxCol[j]) maxCol[j] = matrix[i][j];
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == minRow[i] && matrix[i][j] == maxCol[j]) data.add(matrix[i][j]);
            }
        }

        return data;
    }
}
