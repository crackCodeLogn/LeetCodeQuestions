package leetcode.contest.weekly.w392_202404;

/**
 * @author Vivek
 * @since 2024-04-07
 */
public class Q3105_E_LongestStrictlyIncreasingOrStrictlyDecrasingSubarray {

    public static void main(String[] args) {
        Q3105_E_LongestStrictlyIncreasingOrStrictlyDecrasingSubarray q3105ELongestStrictlyIncreasingOrStrictlyDecrasingSubarray = new Q3105_E_LongestStrictlyIncreasingOrStrictlyDecrasingSubarray();
        System.out.println(q3105ELongestStrictlyIncreasingOrStrictlyDecrasingSubarray.longestMonotonicSubarray(new int[]{3, 2, 1}));
    }

    public int longestMonotonicSubarray(int[] nums) {
        int l1 = 1, l2 = 1, mxL1 = 1, mxL2 = 1, n = nums.length, prev = nums[0];
        for (int i = 1; i < n; i++) {
            if (nums[i] > prev) {
                l1++;
                if (l1 > mxL1) mxL1 = l1;
            } else {
                l1 = 1;
            }
            prev = nums[i];
        }
        prev = nums[0];
        for (int i = 1; i < n; i++) {
            if (nums[i] < prev) {
                l2++;
                if (l2 > mxL2) mxL2 = l2;
            } else {
                l2 = 1;
            }
            prev = nums[i];
        }
        return Math.max(mxL1, mxL2);
    }
}
