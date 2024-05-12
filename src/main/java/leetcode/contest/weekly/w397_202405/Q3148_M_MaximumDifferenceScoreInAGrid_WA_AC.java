package leetcode.contest.weekly.w397_202405;

import com.google.common.collect.Lists;

import java.util.List;
import java.util.TreeSet;

public class Q3148_M_MaximumDifferenceScoreInAGrid_WA_AC {

    public static void main(String[] args) {
        Q3148_M_MaximumDifferenceScoreInAGrid_WA_AC q3148MMaximumDifferenceScoreInAGridWAAC = new Q3148_M_MaximumDifferenceScoreInAGrid_WA_AC();
        List<List<Integer>> grid = Lists.newArrayList();
        grid.add(Lists.newArrayList(9, 5, 7, 3));
        grid.add(Lists.newArrayList(8, 9, 6, 1));
        grid.add(Lists.newArrayList(6, 7, 14, 3));
        grid.add(Lists.newArrayList(2, 5, 3, 1));
        System.out.println(q3148MMaximumDifferenceScoreInAGridWAAC.maxScore(grid)); // 9

        grid = Lists.newArrayList();
        grid.add(Lists.newArrayList(4, 3, 2));
        grid.add(Lists.newArrayList(3, 2, 1));
        System.out.println(q3148MMaximumDifferenceScoreInAGridWAAC.maxScore(grid)); // -1

        //wa for => [[5,4,8,6,2],[1,5,8,6,10],[8,6,9,2,10],[3,7,6,10,6]];; expected: 9, output: 8
        grid.clear();
        grid.add(Lists.newArrayList(5, 4, 8, 6, 2));
        grid.add(Lists.newArrayList(1, 5, 8, 6, 10));
        grid.add(Lists.newArrayList(8, 6, 9, 2, 10));
        grid.add(Lists.newArrayList(3, 7, 6, 10, 6));
        System.out.println(q3148MMaximumDifferenceScoreInAGridWAAC.maxScore(grid)); // 9
    }

    public int maxScore(List<List<Integer>> grid) { //29ms -> optimized after maxScore3
        int max = Integer.MIN_VALUE, r = grid.size(), c = grid.get(0).size(), max2 = Integer.MIN_VALUE;
        int[][] data = new int[r][c];
        int[][] maximum = new int[r][c];
        for (int i = 0; i < r; i++) for (int j = 0; j < c; j++) maximum[i][j] = Integer.MIN_VALUE;

        for (int i = r - 1; i >= 0; i--) {
            for (int j = c - 1; j >= 0; j--) {
                int m = 0; // if no move
                if (i < r - 1)
                    maximum[i][j] = Math.max(maximum[i][j], grid.get(i + 1).get(j) - grid.get(i).get(j) + data[i + 1][j]);
                if (j < c - 1)
                    maximum[i][j] = Math.max(maximum[i][j], grid.get(i).get(j + 1) - grid.get(i).get(j) + data[i][j + 1]);

                m = Math.max(m, maximum[i][j]);
                max2 = Math.max(max2, maximum[i][j]);
                data[i][j] = m;
                max = Math.max(max, data[i][j]);
            }
        }
        return max == 0 ? max2 : max;
    }

    public int maxScore3(List<List<Integer>> grid) { // AC, but 8 minutes after contest -> 56ms
        int max = Integer.MIN_VALUE, r = grid.size(), c = grid.get(0).size(), max2 = Integer.MIN_VALUE;
        int[][] data = new int[r][c];
        TreeSet<Integer>[][] sets = new TreeSet[r][c];
        for (int i = 0; i < r; i++) for (int j = 0; j < c; j++) sets[i][j] = new TreeSet<>();

        for (int i = r - 1; i >= 0; i--) {
            for (int j = c - 1; j >= 0; j--) {
                int m = 0; // if no move
                if (i < r - 1) sets[i][j].add(grid.get(i + 1).get(j) - grid.get(i).get(j) + data[i + 1][j]);
                if (j < c - 1) sets[i][j].add(grid.get(i).get(j + 1) - grid.get(i).get(j) + data[i][j + 1]);
                if (j == c - 1 && i == r - 1) sets[i][j].add(Integer.MIN_VALUE);

                m = Math.max(m, sets[i][j].last());
                max2 = Math.max(max2, sets[i][j].last());
                data[i][j] = m;
                max = Math.max(max, data[i][j]);
            }
        }
        return max == 0 ? max2 : max;
    }

    public int maxScore2(List<List<Integer>> grid) { // TLE during contest
        int max = Integer.MIN_VALUE, r = grid.size(), c = grid.get(0).size(), max2 = Integer.MIN_VALUE;
        int[][] data = new int[r][c];

        for (int i = r - 1; i >= 0; i--) {
            for (int j = c - 1; j >= 0; j--) {
                int m = 0; // if no move
                for (int k = j + 1; k <= c - 1; k++) {//east
                    int v = grid.get(i).get(k) - grid.get(i).get(j) + data[i][k];
                    max2 = Math.max(max2, v);
                    m = Math.max(m, v);
                }
                for (int k = i + 1; k <= r - 1; k++) {//south
                    int v = grid.get(k).get(j) - grid.get(i).get(j) + data[k][j];
                    max2 = Math.max(max2, v);
                    m = Math.max(m, v);
                }

                data[i][j] = m;
                max = Math.max(max, data[i][j]);
            }
        }
        return max == 0 ? max2 : max;
    }
}
