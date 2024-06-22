package leetcode.practise;

/**
 * @author Vivek
 * @since 2024-06-22
 */
public class Q1248_M_CountNumberOfNiceSubarrays {

    public static void main(String[] args) {
        Q1248_M_CountNumberOfNiceSubarrays q1248MCountNumberOfNiceSubarrays = new Q1248_M_CountNumberOfNiceSubarrays();
        System.out.println(q1248MCountNumberOfNiceSubarrays.numberOfSubarrays(new int[]{1, 1, 2, 1, 1}, 3)); // 2
        System.out.println(q1248MCountNumberOfNiceSubarrays.numberOfSubarrays(new int[]{2, 4, 6}, 1)); // 0
        System.out.println(q1248MCountNumberOfNiceSubarrays.numberOfSubarrays(new int[]{2, 2, 2, 1, 2, 2, 1, 2, 2, 2}, 2)); // 16
    }

    public int numberOfSubarrays(int[] nums, int k) {
        return numberOfSubarraysAtMost(nums, k) - numberOfSubarraysAtMost(nums, k - 1);
    }

    private int numberOfSubarraysAtMost(int[] nums, int k) {
        int ans = 0;

        for (int l = 0, r = 0; r <= nums.length; )
            if (k >= 0) {
                ans += r - l;
                if (r == nums.length)
                    break;
                if (nums[r] % 2 == 1)
                    --k;
                ++r;
            } else {
                if (nums[l] % 2 == 1)
                    ++k;
                ++l;
            }

        return ans;
    }
}
