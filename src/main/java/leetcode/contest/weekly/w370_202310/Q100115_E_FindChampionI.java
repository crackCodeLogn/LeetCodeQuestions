package leetcode.contest.weekly.w370_202310;

/**
 * @author Vivek
 * @since 2023-11-05
 */
public class Q100115_E_FindChampionI {

    public int findChampion(int[][] grid) {
        int n = grid.length;
        int sum = 0, index = 0;
        for (int i = 0; i < n; i++) sum += grid[0][i];
        for (int i = 1; i < n; i++) {
            int local = 0;
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    local++;
                }
            }
            if (local > sum) {
                index = i;
                sum = local;
            }
        }
        return index;
    }
}
