package leetcode.contest.weekly.w378_202312;

/**
 * @author Vivek
 * @since 2023-12-31
 */
public class Q2980_E_CheckIfBitwiseOrHasTrailingZeros {

    public boolean hasTrailingZeros(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (((nums[i] | nums[j]) & 1) != 1) return true;
            }
        }
        return false;
    }

}
