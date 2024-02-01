package leetcode.practise;

import java.util.Arrays;

/**
 * @author Vivek
 * @since 2024-02-01
 */
public class Q2966_M_DivideArrayIntoArraysWithMaxDifference {
    private static final int[][] EMPTY = new int[0][0];

    public static void main(String[] args) {
        Q2966_M_DivideArrayIntoArraysWithMaxDifference q2966MDivideArrayIntoArraysWithMaxDifference = new Q2966_M_DivideArrayIntoArraysWithMaxDifference();

        int[][] result = q2966MDivideArrayIntoArraysWithMaxDifference.divideArray(new int[]{1, 3, 4, 8, 7, 9, 3, 5, 1}, 2);
    }

    public int[][] divideArray(int[] nums, int v) {
        int n = nums.length;
        if ((n % 3) != 0) return EMPTY;
        int[][] data = new int[n / 3][3];
        Arrays.sort(nums);
        int i = 0, j = 0;
        for (int k = 0; k < n; k++) {
            if (j > 0 && nums[k] - data[i][0] > v) return EMPTY;
            data[i][j] = nums[k];
            j = (j + 1) % 3;
            if (j == 0) i++;
        }
        return data;
    }
}
