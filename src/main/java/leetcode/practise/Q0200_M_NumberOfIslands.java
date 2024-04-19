package leetcode.practise;

public class Q0200_M_NumberOfIslands {
    private static final int[] X = {-1, +1, 0, 0};
    private static final int[] Y = {0, 0, +1, -1};

    private char[][] grid;
    private char current;

    public int numIslands(char[][] grid) { // 3ms - best of my submissions for this problem until now
        int count = 0;
        this.grid = grid;
        this.current = '\0';

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    current = (char) ('A' + count);
                    dfs(i, j);
                }
            }
        }
        return count;
    }

    private void dfs(int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == '0' || grid[i][j] == current)
            return;

        grid[i][j] = current;
        for (int k = 0; k < 4; k++) dfs(i + Y[k], j + X[k]);
    }
}
