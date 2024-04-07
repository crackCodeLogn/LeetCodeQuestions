package leetcode.contest.weekly.w392_202404;

import java.util.Arrays;

/**
 * @author Vivek
 * @since 2024-04-07
 */
public class Q3107_M_MinimumOperationsToMakeMedianOfArrayEqualToK {

    public static void main(String[] args) {
        Q3107_M_MinimumOperationsToMakeMedianOfArrayEqualToK q3107MMinimumOperationsToMakeMedianOfArrayEqualToK = new Q3107_M_MinimumOperationsToMakeMedianOfArrayEqualToK();
        System.out.println(q3107MMinimumOperationsToMakeMedianOfArrayEqualToK.minOperationsToMakeMedianK(new int[]{2, 5, 6, 8, 5}, 4)); // 2
        System.out.println(q3107MMinimumOperationsToMakeMedianOfArrayEqualToK.minOperationsToMakeMedianK(new int[]{2, 5, 6, 8, 5}, 7)); // 3
        System.out.println(q3107MMinimumOperationsToMakeMedianOfArrayEqualToK.minOperationsToMakeMedianK(new int[]{2, 5, 6, 8, 5}, 9)); // 8
        System.out.println(q3107MMinimumOperationsToMakeMedianOfArrayEqualToK.minOperationsToMakeMedianK(new int[]{2, 5, 6, 8, 5}, 1)); // 9
        System.out.println(q3107MMinimumOperationsToMakeMedianOfArrayEqualToK.minOperationsToMakeMedianK(new int[]{1, 2, 3, 4, 5, 6}, 4)); // 0
    }

    public long minOperationsToMakeMedianK(int[] nums, int k) {
        Arrays.sort(nums);
        int midIndex = nums.length / 2;
        if (nums[midIndex] == k) return 0;
        long cnt = 0;
        if (k > nums[midIndex]) {
            for (int i = midIndex; i < nums.length && nums[i] < k; i++)
                cnt += k - nums[i];
        } else {
            for (int i = midIndex; i >= 0 && nums[i] > k; i--)
                cnt += nums[i] - k;
        }
        return cnt;
    }
}
