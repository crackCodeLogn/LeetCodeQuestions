package leetcode.contest.weekly.w403_202406;

/**
 * @author Vivek
 * @since 2024-06-23
 */
public class Q3195_M_FindTheMinimumAreaToCoverAllOnesI {

    public static void main(String[] args) {
        Q3195_M_FindTheMinimumAreaToCoverAllOnesI q3195MFindTheMinimumAreaToCoverAllOnesI = new Q3195_M_FindTheMinimumAreaToCoverAllOnesI();
        System.out.println(q3195MFindTheMinimumAreaToCoverAllOnesI.minimumArea(new int[][]{
                {0, 1, 0},
                {1, 0, 1}
        }));
    }

    public int minimumArea(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        int west = 1002, east = -1, north = 1002, south = -1;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    west = Math.min(west, j);
                    north = Math.min(north, i);
                    south = Math.max(south, i);
                    east = Math.max(east, j);
                }
            }
        }
        return (east - west + 1) * (south - north + 1);
    }
}
