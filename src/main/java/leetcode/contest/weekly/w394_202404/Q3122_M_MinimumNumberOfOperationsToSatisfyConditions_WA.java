package leetcode.contest.weekly.w394_202404;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Vivek
 * @since 2024-04-21
 */
public class Q3122_M_MinimumNumberOfOperationsToSatisfyConditions_WA {

    public static void main(String[] args) {
        Q3122_M_MinimumNumberOfOperationsToSatisfyConditions_WA q3 = new Q3122_M_MinimumNumberOfOperationsToSatisfyConditions_WA();
//        System.out.println(q3.minimumOperations(new int[][]{{1, 0, 2}, {1, 0, 2}})); // 0
//        System.out.println(q3.minimumOperations(new int[][]{{1, 1, 1}, {0, 0, 0}})); // 3
//        System.out.println(q3.minimumOperations(new int[][]{{1}, {2}, {3}})); // 2
//        System.out.println(q3.minimumOperations(new int[][]{{4, 2, 2}, {8, 2, 5}, {1, 5, 2}})); // 5
//        System.out.println(q3.minimumOperations(new int[][]{{9, 6, 6, 7, 2, 8, 6, 7, 5, 5}, {8, 3, 0, 0, 9, 2, 3, 0, 5, 8}})); // 9
//        System.out.println(q3.minimumOperations(new int[][]{{5, 9, 9, 4, 9}, {4, 6, 2, 8, 2}, {8, 9, 6, 2, 7}, {3, 0, 2, 8, 1}, {6, 7, 1, 2, 2}})); // 16
        System.out.println(q3.minimumOperations(new int[][]{{0, 5, 5, 1, 6, 0}, {9, 2, 1, 1, 4, 2}, {7, 0, 1, 0, 8, 6}, {7, 7, 3, 7, 6, 6}, {9, 6, 7, 4, 6, 2}, {8, 0, 4, 4, 9, 9}})); // 23
    }

    public int minimumOperations(int[][] grid) {
        int rows = grid.length, cols = grid[0].length;
        int[] mins = new int[cols];
        List<int[]> colsCount = new ArrayList<>(cols);
        for (int j = 0; j < cols; j++) {
            int[] cnt = new int[10];
            for (int i = 0; i < rows; i++) cnt[grid[i][j]]++;
            colsCount.add(cnt);
        }
        int k = 0;
        for (int[] col : colsCount) mins[k++] = populate(col);
        for (int j = 0; j < cols; j++) {
            if (j < cols - 2 && mins[j] == mins[j + 1] && mins[j] == mins[j + 2]) continue;

            if (j > 0 && j < cols - 1 && mins[j] == mins[j - 1] && mins[j] == mins[j + 1]) {
                colsCount.get(j)[mins[j]] = 0;
                mins[j] = populate(colsCount.get(j));
                j++;
            } else if (j > 0 && mins[j] == mins[j - 1]) {

                colsCount.get(j)[mins[j]] = 0;
                if (j < cols - 1)
                    colsCount.get(j)[mins[j + 1]] = 0;
                mins[j] = populate(colsCount.get(j));
            } else if (j < cols - 1 && mins[j] == mins[j + 1]) {

                if (cost(j, grid, mins[j]) < cost(j + 1, grid, mins[j])) {
                    continue;
                }
                colsCount.get(j)[mins[j]] = 0;
                if (j > 0)
                    colsCount.get(j)[mins[j - 1]] = 0;
                mins[j] = populate(colsCount.get(j));
            }
        }
        int cnt = 0;
        for (int j = 0; j < cols; j++) for (int i = 0; i < rows; i++) if (grid[i][j] != mins[j]) cnt++;
        return cnt;
    }

    private int cost(int j, int[][] grid, int k) {
        int cnt = 0;
        for (int i = 0; i < grid.length; i++) if (grid[i][j] != k) cnt++;
        return cnt;
    }

    private int populate(int[] col) {
        int v = -1, ind = -1;
        for (int i = 0; i < col.length; i++)
            if (col[i] > v) {
                v = col[i];
                ind = i;
            }
        return ind;
    }
}
