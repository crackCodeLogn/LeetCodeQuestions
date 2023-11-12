package leetcode.contest.weekly.w371_202311;

/**
 * @author Vivek
 * @since 2023-11-12
 */
public class Q100120_E_MaximumStrongPairXor1 {

    public int maximumStrongPairXor(int[] nums) {
        if (nums.length == 1) return 0;

        int maxXor = Integer.MIN_VALUE, n = nums.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (Math.abs(nums[i] - nums[j]) <= Math.min(nums[i], nums[j])) {
                    int xor = nums[i] ^ nums[j];
                    if (xor > maxXor) {
                        maxXor = xor;
                    }
                }
            }
        }
        return maxXor;
    }
}
