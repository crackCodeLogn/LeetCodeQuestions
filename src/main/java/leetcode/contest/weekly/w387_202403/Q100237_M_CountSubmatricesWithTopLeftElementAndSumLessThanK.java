package leetcode.contest.weekly.w387_202403;

/**
 * @author Vivek
 * @since 2024-03-03
 */
public class Q100237_M_CountSubmatricesWithTopLeftElementAndSumLessThanK {
    public static void main(String[] args) {
        Q100237_M_CountSubmatricesWithTopLeftElementAndSumLessThanK q100237MCountSubmatricesWithTopLeftElementAndSumLessThanK = new Q100237_M_CountSubmatricesWithTopLeftElementAndSumLessThanK();
        System.out.println(q100237MCountSubmatricesWithTopLeftElementAndSumLessThanK.countSubmatrices(new int[][]{
                {7, 6, 3},
                {6, 6, 1},
        }, 18));
        System.out.println(q100237MCountSubmatricesWithTopLeftElementAndSumLessThanK.countSubmatrices(new int[][]{
                {7, 2, 9},
                {1, 5, 0},
                {2, 6, 6},
        }, 20));
        System.out.println(q100237MCountSubmatricesWithTopLeftElementAndSumLessThanK.countSubmatrices(new int[][]{
                {1, 10},
                {7, 2},
                {9, 1},
                {4, 1},
        }, 8)); // 2
    }

    public int countSubmatrices(int[][] grid, int k) {
        int cnt = 0;
        int n = grid.length, m = grid[0].length;
        int[][] data = new int[n + 1][m + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                data[i][j] += data[i - 1][j] + data[i][j - 1] - data[i - 1][j - 1] + grid[i - 1][j - 1];
                if (data[i][j] <= k) cnt++;
            }
        }
        return cnt;
    }

}
