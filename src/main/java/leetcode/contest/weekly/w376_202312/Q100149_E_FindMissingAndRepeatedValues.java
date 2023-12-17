package leetcode.contest.weekly.w376_202312;

/**
 * @author Vivek
 * @since 2023-12-17
 */
public class Q100149_E_FindMissingAndRepeatedValues {

    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int n = grid.length;
        int[] data = new int[n * n + 1];
        int first = -1, second = -1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                data[grid[i][j]]++;
                if (data[grid[i][j]] == 2) {
                    first = grid[i][j];
                }
            }
        }
        for (int i = 1; i <= data.length; i++) {
            if (data[i] == 0) {
                second = i;
                break;
            }
        }
        return new int[]{first, second};
    }
}
