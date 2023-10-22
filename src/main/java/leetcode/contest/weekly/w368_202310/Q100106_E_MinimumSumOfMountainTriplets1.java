package leetcode.contest.weekly.w368_202310;

/**
 * @author Vivek
 * @since 2023-10-22
 */
public class Q100106_E_MinimumSumOfMountainTriplets1 {
    public int minimumSum(int[] nums) {
        int sum = Integer.MAX_VALUE, n = nums.length;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    if (nums[i] < nums[j] && nums[j] > nums[k]) {
                        sum = Math.min(sum, nums[i] + nums[j] + nums[k]);
                    }
                }
            }
        }
        return sum == Integer.MAX_VALUE ? -1 : sum;
    }
}
