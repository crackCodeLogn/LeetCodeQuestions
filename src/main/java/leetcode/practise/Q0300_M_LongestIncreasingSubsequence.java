package leetcode.practise;

/**
 * @author Vivek
 * @since 2024-01-05
 */
public class Q0300_M_LongestIncreasingSubsequence {

    public static void main(String[] args) {
        Q0300_M_LongestIncreasingSubsequence q0300MLongestIncreasingSubsequence = new Q0300_M_LongestIncreasingSubsequence();
        System.out.println(q0300MLongestIncreasingSubsequence.lengthOfLIS(new int[]{10, 9, 2, 5, 3, 7, 101, 18})); // 4
        System.out.println(q0300MLongestIncreasingSubsequence.lengthOfLIS(new int[]{0, 1, 0, 3, 2, 3})); // 4
        System.out.println(q0300MLongestIncreasingSubsequence.lengthOfLIS(new int[]{7, 7, 7, 7, 7, 7, 7})); // 1
        System.out.println(q0300MLongestIncreasingSubsequence.lengthOfLIS(new int[]{0})); // 1
    }

    public int lengthOfLIS(int[] nums) {
        if (nums.length == 1) return 1;
        int[] data = new int[nums.length];
        data[nums.length - 1] = 1;
        int max = -1;

        for (int i = nums.length - 2; i >= 0; i--) {
            int v = 1;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] > nums[i]) {
                    v = Math.max(v, 1 + data[j]);
                }
            }
            data[i] = v;
            max = Math.max(max, v);
        }

        return max;
    }
}
