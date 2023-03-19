package leetcode.contest.weekly.w337_202303;

/**
 * @author Vivek
 * @since 2023-03-19
 */
public class Q6322_M_CheckKnightTourConfiguration {

    /*private static final int[] moveX = {+2, -1, -2, +1, +1, -2, -2, 2};
    private static final int[] moveY = {-1, -2, +1, +2, -2, -1, +1, 1};*/

    private static final int[] moveX = {-1, +1, +2, +2, -2, -2, -1, +1};
    private static final int[] moveY = {+2, +2, -1, +1, -1, +1, -2, -2};

    public static void main(String[] args) {
        Q6322_M_CheckKnightTourConfiguration q6322MCheckKnightTourConfiguration = new Q6322_M_CheckKnightTourConfiguration();
        System.out.println(q6322MCheckKnightTourConfiguration.checkValidGrid(new int[][]{
                {0, 11, 16, 5, 20}, {17, 4, 19, 10, 15}, {12, 1, 8, 21, 6}, {3, 18, 23, 14, 9}, {24, 13, 2, 7, 22}
        }));
        System.out.println(q6322MCheckKnightTourConfiguration.checkValidGrid(new int[][]{
                {24, 11, 22, 17, 4}, {21, 16, 5, 12, 9}, {6, 23, 10, 3, 18}, {15, 20, 1, 8, 13}, {0, 7, 14, 19, 2}
        }));
    }

    private boolean isNextMoveCorrect(int[][] grid, int i, int j, int current) {
        for (int k = 0; k < moveY.length; k++) {
            int ni = i + moveX[k], nj = j + moveY[k];
            try {
                int val = grid[ni][nj];
                if (val == current + 1) return true;
            } catch (Exception ignored) {
            }
        }
        return false;
    }

    public boolean checkValidGrid(int[][] grid) {
        if (grid[0][0] != 0) return false;
        int m = grid.length; //rows
        int n = grid[0].length; //cols
        int limit = m * n - 1;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int current = grid[i][j];
                if (current != limit && !isNextMoveCorrect(grid, i, j, current)) {
                    return false;
                }
            }
        }
        return true;
    }
}
