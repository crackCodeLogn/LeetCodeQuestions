package leetcode.practise;

import java.util.Arrays;

/**
 * @author Vivek
 * @since 2024-07-03
 */
public class Q1509_M_MinimumDifferenceBetweenLargestAndSmallestValueInThreeMoves {

    public static void main(String[] args) {
        Q1509_M_MinimumDifferenceBetweenLargestAndSmallestValueInThreeMoves q1509MMinimumDifferenceBetweenLargestAndSmallestValueInThreeMoves = new Q1509_M_MinimumDifferenceBetweenLargestAndSmallestValueInThreeMoves();
        System.out.println(q1509MMinimumDifferenceBetweenLargestAndSmallestValueInThreeMoves.minDifference(new int[]{5, 3, 2, 4})); // 0
        System.out.println(q1509MMinimumDifferenceBetweenLargestAndSmallestValueInThreeMoves.minDifference(new int[]{1, 5, 10, 0, 14})); // 1
        System.out.println(q1509MMinimumDifferenceBetweenLargestAndSmallestValueInThreeMoves.minDifference(new int[]{3, 100, 20})); // 0
        System.out.println(q1509MMinimumDifferenceBetweenLargestAndSmallestValueInThreeMoves.minDifference(new int[]{1, 10, 15, 18, 20, 22, 24, 25, 30, 35})); // 15
    }

    public int minDifference(int[] nums) {
        if (nums.length <= 4) return 0;
        Arrays.sort(nums);
        int n = nums.length, min = Integer.MAX_VALUE;
        for (int p1 = 0, p2 = n - 4; p1 <= 3; p1++, p2++) min = Math.min(min, nums[p2] - nums[p1]);
        return min;
    }
}
