package leetcode;

/**
 * @author Vivek
 * @since 2024-08-09
 */
public class Q0840_M_MagicSquaresInGrid {
    private static final int[] NUMBERS = {0, 1, 2, 5, 8, 7, 6, 3};
    private static final String S1 = "4381672943816729";
    private static final String S2 = "9276183492761834";

    public static void main(String[] args) {
        Q0840_M_MagicSquaresInGrid q0840MMagicSquaresInGrid = new Q0840_M_MagicSquaresInGrid();
        System.out.println(q0840MMagicSquaresInGrid.numMagicSquaresInside(new int[][]{{4, 3, 8, 4}, {9, 5, 1, 9}, {2, 7, 6, 2}}));
        System.out.println(q0840MMagicSquaresInGrid.numMagicSquaresInside(new int[][]{{8}}));
    }

    public int numMagicSquaresInside(int[][] grid) {
        int ans = 0;
        for (int i = 0; i + 2 < grid.length; i++)
            for (int j = 0; j + 2 < grid[0].length; j++)
                if (grid[i][j] % 2 == 0 && grid[i + 1][j + 1] == 5)
                    if (isMagic(grid, i, j)) ans++;
        return ans;
    }

    private boolean isMagic(int[][] grid, int i, int j) {
        StringBuilder s = new StringBuilder();
        for (int num : NUMBERS) s.append(grid[i + num / 3][j + num % 3]);
        return S1.contains(s) || S2.contains(s);
    }
}
