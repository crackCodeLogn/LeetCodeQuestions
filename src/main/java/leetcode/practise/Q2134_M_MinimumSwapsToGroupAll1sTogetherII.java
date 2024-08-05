package leetcode.practise;

import java.util.Arrays;

/**
 * @author Vivek
 * @since 2024-08-05
 */
public class Q2134_M_MinimumSwapsToGroupAll1sTogetherII {

    public int minSwaps(int[] nums) {
        final int n = nums.length;
        final int k = (int) Arrays.stream(nums).filter(a -> a == 1).count();
        int ones = 0;
        int maxOnes = 0;

        for (int i = 0; i < n * 2; ++i) {
            if (i >= k && nums[(i - k) % n] == 1) ones--;
            if (nums[i % n] == 1) ones++;
            maxOnes = Math.max(maxOnes, ones);
        }

        return k - maxOnes;
    }
}
