package leetcode.contest.weekly.w403_202406;

import java.util.Arrays;

/**
 * @author Vivek
 * @since 2024-06-23
 */
public class Q3194_E_MinimumAverageOfSmallestAndLargestElements {

    public static void main(String[] args) {
        Q3194_E_MinimumAverageOfSmallestAndLargestElements q3194EMinimumAverageOfSmallestAndLargestElements = new Q3194_E_MinimumAverageOfSmallestAndLargestElements();
        System.out.println(q3194EMinimumAverageOfSmallestAndLargestElements.minimumAverage(new int[]{7, 8, 3, 4, 15, 13, 4, 1}));
        System.out.println(q3194EMinimumAverageOfSmallestAndLargestElements.minimumAverage(new int[]{1, 9, 8, 3, 10, 5}));
        System.out.println(q3194EMinimumAverageOfSmallestAndLargestElements.minimumAverage(new int[]{1, 2, 3, 7, 8, 9}));
    }

    public double minimumAverage(int[] nums) {
        double avg = Double.MAX_VALUE;
        Arrays.sort(nums);

        for (int i = 0, j = nums.length - 1; i < j; i++, j--) {
            avg = Math.min(avg, (nums[i] + nums[j]) / 2.0);
        }
        return avg;
    }
}
