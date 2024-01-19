package leetcode.practise;

import java.util.Arrays;

/**
 * @author Vivek
 * @since 2024-01-19
 */
public class Q0931_M_MinimumFallingPathSum {
    private static final int CONSTANT = Integer.MAX_VALUE;
    private int n;
    private int[][] data;
    private int[][] matrix;

    public static void main(String[] args) {
        Q0931_M_MinimumFallingPathSum q0931MMinimumFallingPathSum = new Q0931_M_MinimumFallingPathSum();
        System.out.println(q0931MMinimumFallingPathSum.minFallingPathSum(new int[][]{
                {2, 1, 3}, {6, 5, 4}, {7, 8, 9}
        }));
    }

    public int minFallingPathSum(int[][] matrix) {
        n = matrix.length;
        this.data = new int[n][n];
        this.matrix = matrix;
        for (int i = 0; i < n; i++) Arrays.fill(data[i], CONSTANT);

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            min = Math.min(compute(0, i), min);
        }
        return min;
    }

    private int compute(int row, int col) {
        if (row >= n || col < 0 || col >= n) return CONSTANT;

        if (data[row][col] != CONSTANT) return data[row][col];
        int v1 = compute(row + 1, col - 1);
        int v2 = compute(row + 1, col);
        int v3 = compute(row + 1, col + 1);
        int v = Math.min(v1, Math.min(v2, v3));
        if (v == CONSTANT) v = 0;
        data[row][col] = v + matrix[row][col];
        return data[row][col];
    }

}
