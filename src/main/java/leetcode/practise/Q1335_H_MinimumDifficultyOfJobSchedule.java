package leetcode.practise;

import java.util.Arrays;

/**
 * @author Vivek
 * @since 2023-12-30
 */
public class Q1335_H_MinimumDifficultyOfJobSchedule {
    int n;
    int[] values;
    int[][] data;

    public static void main(String[] args) {
        Q1335_H_MinimumDifficultyOfJobSchedule q1335HMinimumDifficultyOfJobSchedule = new Q1335_H_MinimumDifficultyOfJobSchedule();
        System.out.println(q1335HMinimumDifficultyOfJobSchedule.minDifficulty(new int[]{6, 5, 4, 3, 2, 1}, 2));
    }

    public int minDifficulty(int[] jobDifficulty, int d) {
        n = jobDifficulty.length;
        values = jobDifficulty;
        if (n < d) return -1;

        data = new int[n][d + 1];
        for (int i = 0; i < n; i++) Arrays.fill(data[i], -1);
        return compute(0, d);
    }

    private int compute(int i, int d) {
        if (d == 0 && i == n) return 0;
        if (d == 0 || i == n) return Integer.MAX_VALUE;
        if (data[i][d] != -1) return data[i][d];

        int max = values[i];
        int min = Integer.MAX_VALUE;
        for (int j = i; j < n; ++j) {
            max = Math.max(max, values[j]);
            int future = compute(j + 1, d - 1);
            if (future != Integer.MAX_VALUE)
                min = Math.min(min, future + max);
        }

        return data[i][d] = min;
    }
}
