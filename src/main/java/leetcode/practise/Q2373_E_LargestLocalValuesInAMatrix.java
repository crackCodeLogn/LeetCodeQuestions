package leetcode.practise;

public class Q2373_E_LargestLocalValuesInAMatrix {

    public int[][] largestLocal(int[][] grid) {
        int r = grid.length, c = grid[0].length;
        int[][] data = new int[r - 2][c - 2];
        for (int i = 1; i < r - 1; i++) {
            for (int j = 1; j < c - 1; j++) {
                int max = grid[i][j];
                max = Math.max(max, grid[i - 1][j - 1]);
                max = Math.max(max, grid[i - 1][j]);
                max = Math.max(max, grid[i - 1][j + 1]);
                max = Math.max(max, grid[i][j - 1]);
                max = Math.max(max, grid[i][j + 1]);
                max = Math.max(max, grid[i + 1][j - 1]);
                max = Math.max(max, grid[i + 1][j]);
                max = Math.max(max, grid[i + 1][j + 1]);
                data[i - 1][j - 1] = max;
            }
        }
        return data;
    }

}
