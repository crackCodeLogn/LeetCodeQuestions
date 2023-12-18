package leetcode.practise;

import java.util.Arrays;

/**
 * @author Vivek
 * @since 2023-12-18
 */
public class Q1913_E_MaximumProductDifferenceBetweenTwoPairs {

    public int maxProductDifference(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        return nums[n - 1] * nums[n - 2] - nums[0] * nums[1];
    }
}
