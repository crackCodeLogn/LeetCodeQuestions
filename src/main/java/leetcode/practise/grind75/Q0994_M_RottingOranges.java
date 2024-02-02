package leetcode.practise.grind75;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author Vivek
 * @since 2024-02-02
 */
public class Q0994_M_RottingOranges {

    private static final int[] X = {-1, +1, 0, 0};
    private static final int[] Y = {0, 0, -1, +1};
    private int[][] grid;
    private boolean[][] visited;
    private int n;
    private int m;

    public int orangesRotting(int[][] grid) {
        this.grid = grid;
        this.n = grid.length;
        this.m = grid[0].length;
        Queue<int[]> rottens = new LinkedList<>();
        boolean anyGood = false;

        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 2) rottens.offer(new int[]{i, j});
                else if (grid[i][j] == 1) anyGood = true;
            }
        return anyGood ? bfs(rottens) : 0;
    }

    private int bfs(Queue<int[]> queue) {
        this.visited = new boolean[n][m];
        int minz = 0;

        List<int[]> list = new ArrayList<>();
        while (!queue.isEmpty()) {
            while (!queue.isEmpty()) {
                int[] cell = queue.poll();
                visited[cell[0]][cell[1]] = true;
                for (int k = 0; k < 4; k++) {
                    int x = cell[0] + X[k], y = cell[1] + Y[k];
                    if (x < 0 || y < 0 || x >= n || y >= m || visited[x][y] || grid[x][y] == 0) continue;
                    visited[x][y] = true;
                    list.add(new int[]{x, y});
                }
            }
            if (list.isEmpty()) continue;
            minz++;
            queue.addAll(list);
            list.clear();
        }

        for (int q = 0; q < n; q++) for (int w = 0; w < m; w++) if (!visited[q][w] && grid[q][w] == 1) return -1;
        return minz;
    }

}
