package leetcode.practise.grind75;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author Vivek
 * @since 2024-02-02
 */
public class Q0200_M_NumberOfIslands {
    private static final int[] X = {-1, +1, 0, 0};
    private static final int[] Y = {0, 0, -1, +1};
    private char[][] grid;
    private boolean[][] visited;
    private int n;
    private int m;

    public static void main(String[] args) {
        Q0200_M_NumberOfIslands q0200MNumberOfIslands = new Q0200_M_NumberOfIslands();
        System.out.println(q0200MNumberOfIslands.numIslands(new char[][]{
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}
        }));
    }

    public int numIslands(char[][] grid) {
        int cnt = 0;
        this.grid = grid;
        this.n = grid.length;
        this.m = grid[0].length;
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == '1' && !visited[i][j]) {
                    performBfs(i, j);
                    cnt++;
                }
            }
        }
        return cnt;
    }

    private boolean isOut(int x, int y) {
        return x < 0 || x >= n || y < 0 || y >= m;
    }

    private void performBfs(int i, int j) {
        Queue<int[]> queue = new LinkedList<>();
        visited[i][j] = true;
        queue.offer(new int[]{i, j});
        while (!queue.isEmpty()) {
            List<int[]> list = new ArrayList<>();
            while (!queue.isEmpty()) {
                int[] point = queue.poll();
                //visited[point[0]][point[1]] = true;
                for (int k = 0; k < 4; k++) {
                    int x = point[0] + X[k], y = point[1] + Y[k];
                    if (x < 0 || x >= n || y < 0 || y >= m || visited[x][y] || grid[x][y] != '1') continue;
                    visited[x][y] = true;
                    list.add(new int[]{x, y});
                }
            }
            queue.addAll(list);
            list = null;
        }
    }
}
