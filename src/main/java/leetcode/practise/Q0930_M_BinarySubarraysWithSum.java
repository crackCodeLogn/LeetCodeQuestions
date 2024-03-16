package leetcode.practise;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Vivek
 * @since 2024-03-14
 */
public class Q0930_M_BinarySubarraysWithSum {

    public static void main(String[] args) {
        Q0930_M_BinarySubarraysWithSum q0930MBinarySubarraysWithSum = new Q0930_M_BinarySubarraysWithSum();
        System.out.println(q0930MBinarySubarraysWithSum.numSubarraysWithSum(new int[]{1, 0, 1, 0, 1}, 2)); // 4
        System.out.println(q0930MBinarySubarraysWithSum.numSubarraysWithSum(new int[]{0, 0, 0, 0, 0}, 0)); // 15
    }

    public int numSubarraysWithSum(int[] nums, int goal) {
        int cnt = 0;
        int prefix = 0;
        Map<Integer, Integer> count = new HashMap<>();
        count.put(0, 1);

        for (int num : nums) {
            prefix += num;
            int key = prefix - goal;
            if (count.containsKey(key)) cnt += count.get(key);
            count.merge(prefix, 1, Integer::sum);
        }

        return cnt;
    }

    public int numSubarraysWithSum2(int[] nums, int goal) {
        int n0 = 0, n1 = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) n1++;
            else n0++;
        }
        if (goal == 0) return n0 * (n0 + 1) / 2;
        if (goal == 1) return n1 * (n1 + 1) / 2;
        if (goal > n1) return 0;

        int sum = nums[0], left = 0, right = 0, cnt = 0, n = nums.length;
        while (left <= right && right < n) {
            if (sum == goal) {
                cnt++;
                if (right + 1 < n) ;
            }
        }

        return -1;
    }
}
