package leetcode.practise;

/**
 * @author Vivek
 * @since 2024-01-26
 */
public class Q0576_M_OutOfBoundaryPaths {
    private static final int MOD = (int) (1e9 + 7);
    private long[][][] data;
    private int n; //cols
    private int m; //rows

    public static void main(String[] args) {
        Q0576_M_OutOfBoundaryPaths q0576MOutOfBoundaryPaths = new Q0576_M_OutOfBoundaryPaths();
        System.out.println(q0576MOutOfBoundaryPaths.findPaths(2, 2, 2, 0, 0)); // 6
        System.out.println(q0576MOutOfBoundaryPaths.findPaths(1, 3, 3, 0, 1)); // 12
        System.out.println(q0576MOutOfBoundaryPaths.findPaths(2, 3, 8, 1, 0)); // 1104
        System.out.println(q0576MOutOfBoundaryPaths.findPaths(8, 50, 23, 5, 26)); // 914783380
        System.out.println(q0576MOutOfBoundaryPaths.findPaths(36, 5, 50, 15, 3)); // 390153306
        System.out.println(q0576MOutOfBoundaryPaths.findPaths(45, 35, 47, 20, 31)); // TLE, then 951853874
    }

    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        this.n = n;
        this.m = m;
        this.data = new long[m + 1][n + 1][maxMove + 1];

        return (int) (compute(startRow, startColumn, maxMove) % MOD);
    }

    private long compute(int row, int col, int maxMove) {
        // System.out.println(row + " == " + col);
        if (isOut(row, col)) return 1;
        if (maxMove <= 0) return 0;
        if (maxMove == 1) {
            if (isCorner(row, col)) {
                return 2 + ((n == 1 || m == 1) ? 1 : 0);
            }
            if (isBorder(row, col)) {
                return 1 + ((n == 1 || m == 1) ? 1 : 0);
            }
        }
        if (isInfeasible(row, col, maxMove)) {
            return 0;
        }

        if (data[row][col][maxMove] > 0) {
            return data[row][col][maxMove];
        }

        long sum = mod(
                mod(compute(row - 1, col, maxMove - 1)) +
                        mod(compute(row + 1, col, maxMove - 1)) +
                        mod(compute(row, col + 1, maxMove - 1)) +
                        mod(compute(row, col - 1, maxMove - 1)));
        data[row][col][maxMove] = sum;
        return sum;
    }

    private boolean isInfeasible(int row, int col, int maxMove) {
        return min(row + 1, col + 1, m - row, n - col) > maxMove;
    }

    private int min(int... vals) {
        int min = vals[0];
        for (int i = 1; i < vals.length; i++) min = Math.min(min, vals[i]);
        return min;
    }

    private boolean isCorner(int row, int col) {
        return (row == 0 || row == m - 1) && (col == 0 || col == n - 1);
    }

    private boolean isBorder(int row, int col) {
        return row == 0 || row == m - 1 || col == 0 || col == n - 1;
    }

    private long mod(long v) {
        return v % MOD;
    }

    private boolean isOut(int i, int j) {
        return i < 0 || i >= m || j < 0 || j >= n;
    }
}
