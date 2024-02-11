package leetcode.contest.weekly.w384_202402;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Vivek
 * @since 2024-02-11
 */
public class Q100230_E_ModifyTheMatrix {

    public int[][] modifiedMatrix(int[][] matrix) {
        int n = matrix.length, m = matrix[0].length;
        int[][] data = new int[n][m];

        for (int j = 0; j < m; j++) {
            int max = -1;
            List<Integer> negatives = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                if (matrix[i][j] == -1) negatives.add(i);
                else max = Math.max(max, matrix[i][j]);
                data[i][j] = matrix[i][j];
            }
            for (int i = 0; i < negatives.size(); i++) data[negatives.get(i)][j] = max;
        }
        return data;
    }

}
