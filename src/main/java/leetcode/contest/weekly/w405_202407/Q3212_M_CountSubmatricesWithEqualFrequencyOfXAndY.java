package leetcode.contest.weekly.w405_202407;

/**
 * @author Vivek
 * @since 2024-07-06
 */
public class Q3212_M_CountSubmatricesWithEqualFrequencyOfXAndY {

    public static void main(String[] args) {
        Q3212_M_CountSubmatricesWithEqualFrequencyOfXAndY q3212MCountSubmatricesWithEqualFrequencyOfXAndY = new Q3212_M_CountSubmatricesWithEqualFrequencyOfXAndY();
        System.out.println(q3212MCountSubmatricesWithEqualFrequencyOfXAndY.numberOfSubmatrices(new char[][]{
                {'X', 'Y', '.'},
                {'Y', '.', '.'},
        }));
    }

    public int numberOfSubmatrices(char[][] grid) {
        int cnt = 0;
        int[][][] data = new int[grid.length][grid[0].length][2];
        int x = 0, y = 0, i = 0, j = 0;
        for (j = 0; j < grid[0].length; j++) {
            if (grid[0][j] == 'X') x++;
            else if (grid[0][j] == 'Y') y++;
            data[0][j][0] = x;
            data[0][j][1] = y;
            if (data[i][j][0] == data[i][j][1] && data[i][j][0] > 0) cnt++;
        }
        x = y = j = 0;

        for (i = 0; i < grid.length; i++) {
            if (grid[i][0] == 'X') x++;
            else if (grid[i][0] == 'Y') y++;
            data[i][0][0] = x;
            data[i][0][1] = y;
            if (data[i][j][0] == data[i][j][1] && data[i][j][0] > 0) cnt++;
        }
        for (i = 1; i < grid.length; i++) {
            for (j = 1; j < grid[0].length; j++) {
                data[i][j][0] = data[i - 1][j][0] + data[i][j - 1][0] - data[i - 1][j - 1][0] + (grid[i][j] == 'X' ? 1 : 0);
                data[i][j][1] = data[i - 1][j][1] + data[i][j - 1][1] - data[i - 1][j - 1][1] + (grid[i][j] == 'Y' ? 1 : 0);
                if (data[i][j][0] == data[i][j][1] && data[i][j][0] > 0) cnt++;
            }
        }

        return cnt;
    }
}
