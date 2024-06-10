package leetcode.practise;

/**
 * @author Vivek
 * @since 2024-06-10
 */
public class Q0974_M_SubarraySumsDivisibleByK {
    public static void main(String[] args) {
        Q0974_M_SubarraySumsDivisibleByK q0974MSubarraySumsDivisibleByK = new Q0974_M_SubarraySumsDivisibleByK();
        System.out.println(q0974MSubarraySumsDivisibleByK.subarraysDivByK(new int[]{4, 5, 0, -2, -3, 1}, 5)); // 7
        System.out.println(q0974MSubarraySumsDivisibleByK.subarraysDivByK(new int[]{5}, 9)); // 0
    }

    public int subarraysDivByK(int[] nums, int k) {
        int ans = 0;
        int prefix = 0;
        int[] count = new int[k];
        count[0] = 1;

        for (int num : nums) {
            prefix = (prefix + num % k + k) % k;
            ans += count[prefix];
            ++count[prefix];
        }

        return ans;
    }
}
