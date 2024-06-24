package leetcode.practise;

/**
 * @author Vivek
 * @since 2024-06-24
 */
public class Q0995_H_MinimumNumberOfKConsecutiveBitFlips {

    public static void main(String[] args) {
        Q0995_H_MinimumNumberOfKConsecutiveBitFlips q0995HMinimumNumberOfKConsecutiveBitFlips = new Q0995_H_MinimumNumberOfKConsecutiveBitFlips();
        System.out.println(q0995HMinimumNumberOfKConsecutiveBitFlips.minKBitFlips(new int[]{0, 1, 0}, 1)); // 2
        System.out.println(q0995HMinimumNumberOfKConsecutiveBitFlips.minKBitFlips(new int[]{1, 1, 0}, 2)); // -1
        System.out.println(q0995HMinimumNumberOfKConsecutiveBitFlips.minKBitFlips(new int[]{0, 0, 0, 1, 0, 1, 1, 0}, 3)); // 3
    }

    public int minKBitFlips(int[] nums, int k) {
        int ans = 0;
        int flippedTime = 0;

        for (int i = 0; i < nums.length; ++i) {
            if (i >= k && nums[i - k] == 2)
                --flippedTime;
            if (flippedTime % 2 == nums[i]) {
                if (i + k > nums.length)
                    return -1;
                ++ans;
                ++flippedTime;
                nums[i] = 2;
            }
        }

        return ans;
    }
}
