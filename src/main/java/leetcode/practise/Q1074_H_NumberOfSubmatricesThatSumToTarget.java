package leetcode.practise;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Vivek
 * @since 2024-01-28
 */
public class Q1074_H_NumberOfSubmatricesThatSumToTarget {

    public static void main(String[] args) {
        Q1074_H_NumberOfSubmatricesThatSumToTarget q1074HNumberOfSubmatricesThatSumToTarget = new Q1074_H_NumberOfSubmatricesThatSumToTarget();
        System.out.println(q1074HNumberOfSubmatricesThatSumToTarget.numSubmatrixSumTarget(new int[][]{{0, 1, 0}, {1, 1, 1}, {0, 1, 0}}, 0));
        System.out.println(q1074HNumberOfSubmatricesThatSumToTarget.numSubmatrixSumTarget(new int[][]{{1, -1}, {-1, 1}}, 0));
    }

    public int numSubmatrixSumTarget(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int cnt = 0;

        for (int[] row : matrix)
            for (int i = 1; i < n; i++)
                row[i] += row[i - 1];

        for (int xCol = 0; xCol < n; xCol++)
            for (int j = xCol; j < n; j++) {
                Map<Integer, Integer> prefixCount = new HashMap<>();
                prefixCount.put(0, 1);
                int sum = 0;
                for (int i = 0; i < m; i++) {
                    if (xCol > 0) sum -= matrix[i][xCol - 1];
                    sum += matrix[i][j];
                    cnt += prefixCount.getOrDefault(sum - target, 0);
                    prefixCount.merge(sum, 1, Integer::sum);
                }
            }

        return cnt;
    }
}
