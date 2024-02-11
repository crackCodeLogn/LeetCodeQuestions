package leetcode.practise;

import java.util.Arrays;

/**
 * @author Vivek
 * @since 2024-02-11
 */
public class Q1463_H_CherryPicking2 {

    public int cherryPickup(int[][] grid) {
        final int m = grid.length;
        final int n = grid[0].length;
        int[][][] data = new int[m][n][n];
        for (int[][] A : data) Arrays.stream(A).forEach(B -> Arrays.fill(B, -1));

        return cherryPick(grid, 0, 0, n - 1, data);
    }

    private int cherryPick(int[][] grid, int x, int y1, int y2, int[][][] data) {
        if (x == grid.length) return 0;
        if (y1 < 0 || y1 == grid[0].length || y2 < 0 || y2 == grid[0].length) return 0;
        if (data[x][y1][y2] != -1) return data[x][y1][y2];
        int currRow = grid[x][y1] + (y1 == y2 ? 0 : grid[x][y2]);

        for (int d1 = -1; d1 <= 1; d1++)
            for (int d2 = -1; d2 <= 1; d2++)
                data[x][y1][y2] =
                        Math.max(data[x][y1][y2],
                                currRow + cherryPick(grid, x + 1, y1 + d1, y2 + d2, data));

        return data[x][y1][y2];
    }
}
