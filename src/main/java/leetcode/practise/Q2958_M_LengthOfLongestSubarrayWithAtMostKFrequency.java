package leetcode.practise;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Vivek
 * @since 2024-03-28
 */
public class Q2958_M_LengthOfLongestSubarrayWithAtMostKFrequency {

    public static void main(String[] args) {
        Q2958_M_LengthOfLongestSubarrayWithAtMostKFrequency q2958MLengthOfLongestSubarrayWithAtMostKFrequency = new Q2958_M_LengthOfLongestSubarrayWithAtMostKFrequency();
        System.out.println(q2958MLengthOfLongestSubarrayWithAtMostKFrequency.maxSubarrayLength(new int[]{1, 2, 3, 1, 2, 3, 1, 2}, 2));
        System.out.println(q2958MLengthOfLongestSubarrayWithAtMostKFrequency.maxSubarrayLength(new int[]{1, 2, 1, 2, 1, 2, 1, 2}, 1));
        System.out.println(q2958MLengthOfLongestSubarrayWithAtMostKFrequency.maxSubarrayLength(new int[]{5, 5, 5, 5, 5, 5, 5}, 4));
    }

    public int maxSubarrayLength(int[] nums, int k) {
        int result = 0;
        Map<Integer, Integer> count = new HashMap<>();
        for (int l = 0, r = 0; r < nums.length; r++) {
            count.merge(nums[r], 1, Integer::sum);
            while (count.get(nums[r]) == k + 1) count.merge(nums[l++], -1, Integer::sum);
            result = Math.max(result, r - l + 1);
        }
        return result;
    }
}
