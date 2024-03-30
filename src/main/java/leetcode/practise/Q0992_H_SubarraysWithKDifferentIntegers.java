package leetcode.practise;

/**
 * @author Vivek
 * @since 2024-03-31
 */
public class Q0992_H_SubarraysWithKDifferentIntegers {

    public static void main(String[] args) {
        Q0992_H_SubarraysWithKDifferentIntegers q0992HSubarraysWithKDifferentIntegers = new Q0992_H_SubarraysWithKDifferentIntegers();
        System.out.println(q0992HSubarraysWithKDifferentIntegers.subarraysWithKDistinct(new int[]{1, 2, 1, 2, 3}, 2)); // 7
        System.out.println(q0992HSubarraysWithKDifferentIntegers.subarraysWithKDistinct(new int[]{1, 2, 1, 3, 4}, 3)); // 3
    }

    public int subarraysWithKDistinct(int[] nums, int k) {
        return subarraysWithAtMostKDistinct(nums, k) - subarraysWithAtMostKDistinct(nums, k - 1);
    }

    private int subarraysWithAtMostKDistinct(int[] nums, int k) {
        int res = 0;
        int[] count = new int[nums.length + 1];

        for (int l = 0, r = 0; r < nums.length; r++) {
            if (++count[nums[r]] == 1) k--;
            while (k == -1) if (--count[nums[l++]] == 0) k++;
            res += r - l + 1;
        }

        return res;
    }
}
