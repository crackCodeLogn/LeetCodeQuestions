package leetcode.contest.weekly327_202301;

/**
 * @author Vivek
 * @since 2023-01-07
 */
public class Q6283_E_MaximumCountPositiveNegative {

    public int maximumCount(int[] nums) {
        int p = 0, n = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) p++;
            else if (nums[i] < 0) n++;
        }
        return Math.max(n, p);
    }
}