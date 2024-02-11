package leetcode.contest.weekly.w384_202402;

/**
 * @author Vivek
 * @since 2024-02-11
 */
public class Q100186_M_NumberOfSubarraysThatMatchAPattern1 {
    public static void main(String[] args) {
        Q100186_M_NumberOfSubarraysThatMatchAPattern1 q100186MNumberOfSubarraysThatMatchAPattern1 = new Q100186_M_NumberOfSubarraysThatMatchAPattern1();
        System.out.println(q100186MNumberOfSubarraysThatMatchAPattern1.countMatchingSubarrays(new int[]{1, 2, 3, 4, 5, 6}, new int[]{1, 1})); // 4
        System.out.println(q100186MNumberOfSubarraysThatMatchAPattern1.countMatchingSubarrays(new int[]{1, 4, 4, 1, 3, 5, 5, 3}, new int[]{1, 0, -1})); // 2
    }

    public int countMatchingSubarrays(int[] nums, int[] pattern) {
        int cnt = 0, n = nums.length, m = pattern.length;

        for (int i = 0; i < n - m; i++) {
            boolean flag = true;
            for (int j = i; j < n && j < i + m; j++) {
                if (getTerm(nums[j], nums[j + 1]) != pattern[j - i]) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                //System.out.println(i);
                cnt++;
            }
        }

        return cnt;
    }

    private int getTerm(int a, int b) {
        if (a < b) return 1;
        else if (a == b) return 0;
        return -1;
    }
}
