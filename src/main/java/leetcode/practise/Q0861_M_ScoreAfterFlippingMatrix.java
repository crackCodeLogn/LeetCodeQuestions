package leetcode.practise;

public class Q0861_M_ScoreAfterFlippingMatrix {
    public static void main(String[] args) {
        Q0861_M_ScoreAfterFlippingMatrix q0861MScoreAfterFlippingMatrix = new Q0861_M_ScoreAfterFlippingMatrix();
        System.out.println(q0861MScoreAfterFlippingMatrix.matrixScore(new int[][]{
                {0, 0, 1, 1}, {1, 0, 1, 0}, {1, 1, 0, 0}
        })); // 39

        System.out.println(q0861MScoreAfterFlippingMatrix.matrixScore(new int[][]{
                {0, 1}, {0, 1}, {0, 1}, {0, 0}
        })); // 11
    }

    public int matrixScore(int[][] grid) { // 1ms
        int n = grid.length, m = grid[0].length;
        int[] cols = new int[m];

        for (int i = 0; i < n; i++) {
            boolean flag = grid[i][0] == 0;
            for (int j = 0; j < m; j++) {
                if (flag) grid[i][j] = grid[i][j] == 1 ? 0 : 1;
                cols[j] += grid[i][j];
            }
        }
        int mid = (n + 1) / 2;
        for (int j = 1; j < m; j++) if (cols[j] < mid) for (int i = 0; i < n; i++) grid[i][j] = grid[i][j] == 1 ? 0 : 1;

        int sum = 0;
        for (int i = 0; i < n; i++) {
            StringBuilder data = new StringBuilder();
            for (int j = 0; j < m; j++) data.append(grid[i][j]);
            sum += Integer.parseInt(data.toString(), 2);
        }
        return sum;
    }
}
