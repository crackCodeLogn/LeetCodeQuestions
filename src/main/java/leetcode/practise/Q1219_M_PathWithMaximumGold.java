package leetcode.practise;

public class Q1219_M_PathWithMaximumGold {
    private static final int[] x = {0, 1, 0, -1};
    private static final int[] y = {1, 0, -1, 0};
    private boolean[][] visited;
    private int[][] grid;
    private int max, n, m;

    public static void main(String[] args) {
        Q1219_M_PathWithMaximumGold q1219MPathWithMaximumGold = new Q1219_M_PathWithMaximumGold();
        System.out.println(q1219MPathWithMaximumGold.getMaximumGold(new int[][]{
                {0, 6, 0}, {5, 8, 7}, {0, 9, 0}
        })); // 24
        System.out.println(q1219MPathWithMaximumGold.getMaximumGold(new int[][]{
                {1, 0, 7}, {2, 0, 6}, {3, 4, 5}, {0, 3, 0}, {9, 0, 20}
        })); // 28

        System.out.println(q1219MPathWithMaximumGold.getMaximumGold(new int[][]{
                {0, 0, 19, 5, 8}, {11, 20, 14, 1, 0}, {0, 0, 1, 1, 1}, {0, 2, 0, 2, 0}
        })); // 77
    }

    public int getMaximumGold(int[][] grid) {
        visited = new boolean[grid.length][grid[0].length];
        n = grid.length;
        m = grid[0].length;
        max = 0;
        this.grid = grid;

        for (int i = 0; i < n; i++) for (int j = 0; j < m; j++) if (grid[i][j] > 0) compute(i, j, 0);
        return max;
    }

    private void compute(int i, int j, int sum) {
        if (i < 0 || i >= n || j < 0 || j >= m || visited[i][j] || grid[i][j] == 0) return;

        visited[i][j] = true;
        sum += grid[i][j];
        max = Math.max(max, sum);
//        System.out.printf("\n%d %d, %d %d\n", i, j, sum, max);
//        display(visited);
        for (int k = 0; k < 4; k++) compute(i + x[k], j + y[k], sum);
        visited[i][j] = false;
    }

    private void display(boolean[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print((matrix[i][j] ? 'T' : 'F') + " ");
            }
            System.out.println();
        }
    }
}
