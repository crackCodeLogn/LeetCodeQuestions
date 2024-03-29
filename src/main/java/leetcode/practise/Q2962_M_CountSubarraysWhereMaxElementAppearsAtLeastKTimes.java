package leetcode.practise;

import java.util.Arrays;

/**
 * @author Vivek
 * @since 2024-03-29
 */
public class Q2962_M_CountSubarraysWhereMaxElementAppearsAtLeastKTimes {

    public static void main(String[] args) {
        Q2962_M_CountSubarraysWhereMaxElementAppearsAtLeastKTimes q2962MCountSubarraysWhereMaxElementAppearsAtLeastKTimes = new Q2962_M_CountSubarraysWhereMaxElementAppearsAtLeastKTimes();
        System.out.println(q2962MCountSubarraysWhereMaxElementAppearsAtLeastKTimes.countSubarrays(new int[]{1, 3, 2, 3, 3}, 2)); // 6
        System.out.println(q2962MCountSubarraysWhereMaxElementAppearsAtLeastKTimes.countSubarrays(new int[]{1, 4, 2, 1}, 3)); // 0
    }

    public long countSubarrays(int[] nums, int k) {
        final int maxNum = Arrays.stream(nums).max().getAsInt();
        long ans = 0;
        int count = 0;

        for (int l = 0, r = 0; r < nums.length; r++) {
            if (nums[r] == maxNum) count++;
            while (count == k) if (nums[l++] == maxNum) count--;
            ans += l;
        }

        return ans;
    }
}
