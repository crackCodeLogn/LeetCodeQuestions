package leetcode.practise;

/**
 * @author Vivek
 * @since 2024-08-10
 */
public class Q0959_M_RegionsCutBySlashes {

    public static void main(String[] args) {
        Q0959_M_RegionsCutBySlashes q0959MRegionsCutBySlashes = new Q0959_M_RegionsCutBySlashes();
        System.out.println(q0959MRegionsCutBySlashes.regionsBySlashes(new String[]{" /", "/ "}));
        System.out.println(q0959MRegionsCutBySlashes.regionsBySlashes(new String[]{" /", "  "}));
        System.out.println(q0959MRegionsCutBySlashes.regionsBySlashes(new String[]{"/\\", "\\/"}));
    }

    public int regionsBySlashes(String[] grid) {
        int n = grid.length;
        int[][] g = new int[n * 3][n * 3];

        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                if (grid[i].charAt(j) == '/') {
                    g[i * 3][j * 3 + 2] = 1;
                    g[i * 3 + 1][j * 3 + 1] = 1;
                    g[i * 3 + 2][j * 3] = 1;
                } else if (grid[i].charAt(j) == '\\') {
                    g[i * 3][j * 3] = 1;
                    g[i * 3 + 1][j * 3 + 1] = 1;
                    g[i * 3 + 2][j * 3 + 2] = 1;
                }

        int ans = 0;
        for (int i = 0; i < n * 3; i++)
            for (int j = 0; j < n * 3; j++)
                if (g[i][j] == 0) {
                    dfs(g, i, j);
                    ans++;
                }
        return ans;
    }

    private void dfs(int[][] g, int i, int j) {
        if (i < 0 || i == g.length || j < 0 || j == g[0].length)
            return;
        if (g[i][j] != 0)
            return;

        g[i][j] = 2; // Mark 2 as visited.
        dfs(g, i + 1, j);
        dfs(g, i - 1, j);
        dfs(g, i, j + 1);
        dfs(g, i, j - 1);
    }
}
