package leetcode.practise.grind75;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author Vivek
 * @since 2024-01-24
 */
public class Q0542_M_01Matrix {

    private static final int UNVISITED_VAL = Integer.MAX_VALUE;
    private static final int[] x = {-1, +1, +0, +0};
    private static final int[] y = {+0, +0, -1, +1};

    public static void main(String[] args) {
        Q0542_M_01Matrix q0542M01Matrix = new Q0542_M_01Matrix();
        int[][] result = q0542M01Matrix.updateMatrix(new int[][]{
                {0, 1, 1},
                {1, 1, 1},
                {1, 0, 1}
        });
        print(result);
        result = q0542M01Matrix.updateMatrix(new int[][]{
                {0, 0, 0},
                {0, 1, 0},
                {1, 1, 1}
        });
        print(result);
    }

    private static void print(int[][] data) {
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[i].length; j++)
                System.out.print(data[i][j] + " ");
            System.out.println();
        }
    }

    public int[][] updateMatrix(int[][] mat) {
        int n = mat.length, m = mat[0].length;
        int[][] data = new int[n][m];

        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (mat[i][j] == 0) {
                    data[i][j] = 0;
                    queue.offer(new int[]{i, j});
                } else data[i][j] = UNVISITED_VAL;
            }
        }

        int level = 1;
        while (!queue.isEmpty()) {
            List<int[]> list = new ArrayList<>();
            while (!queue.isEmpty()) {
                int[] val = queue.poll();

                for (int k = 0; k < 4; k++) {
                    int vx = val[0] + x[k];
                    int vy = val[1] + y[k];
                    if (isOutsideGrid(n, m, vx, vy)) continue;

                    if (data[vx][vy] == UNVISITED_VAL) {
                        data[vx][vy] = level;
                        list.add(new int[]{vx, vy});
                    }
                }
            }
            level++;
            queue.addAll(list);
        }


        return data;
    }

    private boolean isOutsideGrid(int n, int m, int i, int j) {
        return i < 0 || i >= n || j < 0 || j >= m;
    }
}
