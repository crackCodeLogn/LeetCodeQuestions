package leetcode.practise;

/**
 * @author Vivek
 * @since 2024-04-18
 */
public class Q0463_E_IslandPerimeter {

    private static final int[] X = {-1, +1, 0, 0};
    private static final int[] Y = {0, 0, +1, -1};

    public int islandPerimeter(int[][] grid) { // 5ms
        int res = 0;
        for (int i = 0; i < grid.length; i++)
            for (int j = 0; j < grid[i].length; j++)
                if (grid[i][j] == 1) {
                    for (int k = 0; k < 4; k++) {
                        int x = i + X[k], y = j + Y[k];
                        if (x < 0 || x >= grid.length || y < 0 || y >= grid[i].length || grid[x][y] == 0) res++;
                    }
                }
        return res;
    }

    public int islandPerimeter2(int[][] grid) { // 5ms
        int res = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    int cnt = 4;
                    for (int k = 0; k < 4; k++) {
                        int x = i + X[k], y = j + Y[k];
                        if (x < 0 || x >= grid.length || y < 0 || y >= grid[i].length) continue;
                        if (grid[x][y] == 1) {
                            cnt--;
                        }
                    }
                    res += cnt;
                }
            }
        }
        return res;
    }
}
