package leetcode.practise;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Vivek
 * @since 2024-06-09
 */
public class Q0523_M_ContinuousSubarraySum {

    public static void main(String[] args) {
        Q0523_M_ContinuousSubarraySum q0523MContinuousSubarraySum = new Q0523_M_ContinuousSubarraySum();
        System.out.println(q0523MContinuousSubarraySum.checkSubarraySum(new int[]{23, 2, 4, 6, 7}, 6)); // true
        System.out.println(q0523MContinuousSubarraySum.checkSubarraySum(new int[]{23, 2, 6, 4, 7}, 6)); // true
        System.out.println(q0523MContinuousSubarraySum.checkSubarraySum(new int[]{23, 2, 6, 4, 7}, 13)); // false
    }

    public boolean checkSubarraySum(int[] nums, int k) {
        int prefix = 0;
        Map<Integer, Integer> prefixToIndex = new HashMap<>();
        prefixToIndex.put(0, -1);

        for (int i = 0; i < nums.length; ++i) {
            prefix += nums[i];
            if (k != 0) prefix %= k;
            if (prefixToIndex.containsKey(prefix)) {
                if (i - prefixToIndex.get(prefix) > 1) return true;
            } else {
                prefixToIndex.put(prefix, i);
            }
        }

        return false;
    }
}
