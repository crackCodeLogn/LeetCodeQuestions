package leetcode.contest.weekly.w387_2020403;

/**
 * @author Vivek
 * @since 2024-03-03
 */
public class Q100234_M_MinimumOperationsToWriteTheLetterYOnAGrid {

    public static void main(String[] args) {
        Q100234_M_MinimumOperationsToWriteTheLetterYOnAGrid q100234MMinimumOperationsToWriteTheLetterYOnAGrid = new Q100234_M_MinimumOperationsToWriteTheLetterYOnAGrid();
        System.out.println(q100234MMinimumOperationsToWriteTheLetterYOnAGrid.minimumOperationsToWriteY(new int[][]{{1, 2, 2}, {1, 1, 0}, {0, 1, 0},})); //3
        System.out.println(q100234MMinimumOperationsToWriteTheLetterYOnAGrid.minimumOperationsToWriteY(new int[][]{{0, 1, 0, 1, 0}, {2, 1, 0, 1, 2}, {2, 2, 2, 0, 1}, {2, 2, 2, 2, 2}, {2, 1, 2, 2, 2},})); //12
        System.out.println(q100234MMinimumOperationsToWriteTheLetterYOnAGrid.minimumOperationsToWriteY(new int[][]{{1, 0, 1}, {0, 1, 0}, {0, 1, 0},})); //0
    }

    public int minimumOperationsToWriteY(int[][] grid) {
        int[] yc = new int[3], nyc = new int[3];
        int n = grid.length;

        for (int i = 0; i < n; i++) for (int j = 0; j < n; j++) nyc[grid[i][j]]++;
        for (int i = 0; i < n / 2; i++) {
            yc[grid[i][i]]++;
            nyc[grid[i][i]]--;
            yc[grid[i][n - i - 1]]++;
            nyc[grid[i][n - i - 1]]--;
        }
        for (int i = n / 2, j = n / 2; i < n; i++) {
            yc[grid[i][j]]++;
            nyc[grid[i][j]]--;
        }
        return compute(yc, nyc);
    }

    private int compute(int[] yc, int[] nyc) {
        int cnt = Integer.MAX_VALUE;
        int sum = nyc[0] + nyc[1] + nyc[2];
        int[] eff2 = {
                sum - Math.max(nyc[1], nyc[2]),
                sum - Math.max(nyc[0], nyc[2]),
                sum - Math.max(nyc[0], nyc[1]),
        };
        int[] eff1 = {
                yc[1] + yc[2],
                yc[0] + yc[2],
                yc[0] + yc[1]
        };
        for (int i = 0; i < 3; i++) cnt = Math.min(cnt, eff1[i] + eff2[i]);
        return cnt;
    }
}
