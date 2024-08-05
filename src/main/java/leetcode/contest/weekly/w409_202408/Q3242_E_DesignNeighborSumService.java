package leetcode.contest.weekly.w409_202408;

/**
 * @author Vivek
 * @since 2024-08-05
 */
public class Q3242_E_DesignNeighborSumService {

    class neighborSum {
        private final int[][] grid;

        public neighborSum(int[][] grid) {
            // int n = grid.length, k = 0;
            // for (int i = 0; i<n;i++) for (int j = 0; j<n;j++) grid[i][j] = k++;
            this.grid = grid;
        }

        public int adjacentSum(int value) {
            int n = grid.length;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (grid[i][j] == value) {
                        int sum = 0;
                        try {
                            sum += grid[i - 1][j];
                        } catch (Exception ig) {
                        }
                        try {
                            sum += grid[i + 1][j];
                        } catch (Exception ig) {
                        }
                        try {
                            sum += grid[i][j - 1];
                        } catch (Exception ig) {
                        }
                        try {
                            sum += grid[i][j + 1];
                        } catch (Exception ig) {
                        }
                        return sum;
                    }
                }
            }

            return 0;
        }

        public int diagonalSum(int value) {
            int n = grid.length;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (grid[i][j] == value) {
                        int sum = 0;
                        try {
                            sum += grid[i - 1][j - 1];
                        } catch (Exception ig) {
                        }
                        try {
                            sum += grid[i - 1][j + 1];
                        } catch (Exception ig) {
                        }
                        try {
                            sum += grid[i + 1][j - 1];
                        } catch (Exception ig) {
                        }
                        try {
                            sum += grid[i + 1][j + 1];
                        } catch (Exception ig) {
                        }
                        return sum;
                    }
                }
            }
            return 0;
        }
    }

/**
 * Your neighborSum object will be instantiated and called as such:
 * neighborSum obj = new neighborSum(grid);
 * int param_1 = obj.adjacentSum(value);
 * int param_2 = obj.diagonalSum(value);
 */
}
